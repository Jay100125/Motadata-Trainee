package TrainManagmentSystem.src;

import java.util.HashMap;
import java.util.Map;

public class Coach {
  private String coachName;
  private Map<String,Seat> seats;

  public Coach (String coachName, int totalSeats) {
    this.coachName = coachName;
    this.seats = new HashMap<>();
    for (int i = 1; i <= totalSeats; i++) {
      seats.put("S" + i, new Seat("S" + i));
    }
  }
  public String getCoachName() {
    return coachName;
  }

  public Map<String, Seat> getSeats() {
    return seats;
  }

}
