package TrainManagmentSystem.src;

import java.time.LocalDate;

public class Train {
    private String trainId;
    private String source;
    private String destination;
    private LocalDate departureTime;
    private LocalDate arrivalTime;

    public Train(String trainId, String source, String destination, LocalDate departureTime, LocalDate arrivalTime) {
      this.trainId = trainId;
      this.source = source;
      this.destination = destination;
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
    }

  public String getTrainId() {
    return trainId;
  }

  public String getSource() {
    return source;
  }

  public String getDestination() {
    return destination;
  }

  public LocalDate getDepartureTime() {
    return departureTime;
  }

  public LocalDate getArrivalTime() {
    return arrivalTime;
  }

  @Override
  public String toString() {
    return "Train{" +
      "trainId='" + trainId + '\'' +
      ", source='" + source + '\'' +
      ", destination='" + destination + '\'' +
      ", departureTime=" + departureTime +
      ", arrivalTime=" + arrivalTime +
      '}';
  }
}
