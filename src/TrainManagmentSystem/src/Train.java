package TrainManagmentSystem.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Train
{
   private String trainId;

    private String source;

    private String destination;

    private List<Coach> coaches = new ArrayList<>();

    private LocalDate departureDate;

    private LocalDate arrivalTime;

    public Train(String trainId, String source, String destination, LocalDate departureDate, LocalDate arrivalTime)
    {
      this.trainId = trainId;

      this.source = source;

      this.destination = destination;

      this.departureDate = departureDate;

      this.arrivalTime = arrivalTime;
    }

  public String getTrainId()
  {
    return trainId;
  }

  public String getSource()
  {
    return source;
  }

  public String getDestination()
  {
    return destination;
  }

  public List<Coach> getCoaches()
  {
    return coaches;
  }

  public LocalDate getDepartureDate()
  {
    return departureDate;
  }

  public LocalDate getArrivalTime()
  {
    return arrivalTime;
  }

  @Override
  public String toString() {
    return "Train{" +
      "trainId='" + trainId + '\'' +
      ", source='" + source + '\'' +
      ", destination='" + destination + '\'' +
      ", departureTime=" + departureDate +
      ", arrivalTime=" + arrivalTime +
      '}';
  }
}
