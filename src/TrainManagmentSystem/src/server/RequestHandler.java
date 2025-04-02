package TrainManagmentSystem.src.server;

import TrainManagmentSystem.src.Booking;
import TrainManagmentSystem.src.Coach;
import TrainManagmentSystem.src.Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RequestHandler implements Runnable
{
  private Socket socket;

  private List<Train> trains;

  private Map<String, Train> trainMap;

  private Map<String, Booking> bookings;

  public RequestHandler(Socket socket, List<Train> trains, Map<String, Train> trainMap,
                        Map<String, Booking> bookings)
  {
    this.socket = socket;

    this.trains = trains;

    this.trainMap = trainMap;

    this.bookings = bookings;
  }

  @Override
  public void run()
  {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
    {
      System.out.println("Client connected");

      String request = in.readLine();

      if (request != null)
      {
        String response = processRequest(request);

        if (response != null)
        {
          out.println(response);
        }
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private String processRequest(String request)
  {
    String[] parts = request.split(" ");

    String command = parts[0];

    String response = null;

    switch (command)
    {
      case "SEARCH":
        response = handleSearch(parts);
        break;

      case "BOOK":
        response = handleBooking(parts);
        saveData();
        break;

      case "CANCEL":
        response = handleCancellation(parts);
        saveData();
        break;

      default:
        response = "Invalid command";
    }

    return response;
  }

  public String handleSearch(String[] parts)
  {
    String source = parts[1];

    String destination = parts[2];

    LocalDate date;

    try
    {
      date = LocalDate.parse(parts[3]);
    }
    catch (DateTimeParseException e)
    {
      return "Invalid date format";
    }

    if(date.isBefore(LocalDate.now()))
    {
      return "Date cannot be in the past";
    }

    List<Train> result = searchTrains(source, destination, date);

    if (result.isEmpty())
    {
      return "No trains available for the given criteria.";
    }

    StringBuilder responseBuilder = new StringBuilder("Available Trains:\n");

    for (Train train : result)
    {
      responseBuilder.append("Train ID: ").append(train.getTrainId())
        .append(", Source: ").append(train.getSource())
        .append(", Destination: ").append(train.getDestination())
        .append(", Departure: ").append(train.getDepartureDate())
        .append(", Arrival: ").append(train.getArrivalTime())
        .append("\nCoaches:\n");

      for (Coach coach : train.getCoaches())
      {
        int totalSeats = coach.getSeatBookings().size();

        long availableSeats = coach.getSeatBookings().values().stream()
          .filter(booking -> booking == null)
          .count();

        responseBuilder.append("  Coach ID: ").append(coach.getCoachId())
          .append(", Type: ").append(coach.getType())
          .append(", Total Seats: ").append(totalSeats)
          .append(", Available Seats: ").append(availableSeats)
          .append("\n");
      }
      responseBuilder.append("\n");
    }
    return responseBuilder.toString();
  }

  private List<Train> searchTrains(String source, String destination, LocalDate date)
  {
    return trains.stream()
      .filter(t -> t.getSource().equalsIgnoreCase(source) &&
        t.getDestination().equalsIgnoreCase(destination) &&
        t.getDepartureDate().equals(date))
      .toList();
  }

  public String handleBooking(String[] parts)
  {
    String userId = parts[1];

    String trainId = parts[2];

    String coachId = parts[3];

    int numberOfSeats = Integer.parseInt(parts[4]);

    if(numberOfSeats <= 0)
    {
      return "Invalid number of seats";
    }

    Train train = trainMap.get(trainId);

    if (train == null) return "Train not found";

    Coach coach = train.getCoaches().stream()
      .filter(c -> c.getCoachId().equals(coachId))
      .findFirst().orElse(null);

    if (coach == null)
    {
      return "Coach not found";
    }

    List<String> confirmedSeats = coach.getSeatBookings().entrySet().stream()
      .filter(entry -> entry.getValue() == null)
      .map(Map.Entry::getKey)
      .limit(numberOfSeats)
      .toList();

    if (confirmedSeats.size() < numberOfSeats)
    {
      return "Not enough seats available";
    }

    String pnr = generatePNR();

    Booking booking = new Booking(pnr, userId, trainId, coachId, confirmedSeats);

    synchronized (coach.getSeatBookings())
    {
      confirmedSeats.forEach(seatNumber -> coach.getSeatBookings().put(seatNumber, booking));

      bookings.put(pnr, booking);
    }
    return "Booking successful. PNR: " + pnr + " Seats: " + String.join(",", confirmedSeats);
  }

  private String generatePNR()
  {
    long pnr = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);

    return String.valueOf(pnr);
  }

  private String handleCancellation(String[] parts)
  {
    String pnr = parts[1];

    Booking booking = bookings.get(pnr);

    if (booking == null)
    {
      return "Booking not found";
    }

    Train train = trainMap.get(booking.getTrainId());

    if (train != null)
    {
      Coach coach = train.getCoaches().stream()
        .filter(c -> c.getCoachId().equals(booking.getCoachId()))
        .findFirst().orElse(null);

      if (coach != null)
      {
        synchronized (coach)
        {
          for (String seatNumber : booking.getSeats())
          {
            coach.getSeatBookings().put(seatNumber, null);
          }
        }
      }
    }

    bookings.remove(pnr);

    return "Booking with PNR: " + pnr + " cancelled successfully.";
  }

  private void saveData()
  {
    // This triggers a save after critical operations
    TextDataPersistenceManager.saveAllData(trains, bookings);
  }
}
