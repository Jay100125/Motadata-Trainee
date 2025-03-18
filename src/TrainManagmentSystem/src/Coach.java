package TrainManagmentSystem.src;

import java.util.HashMap;
import java.util.Map;

public class Coach
{
  private String type;

  private String coachId;

  private Map<String,Booking> seatBookings;

  public Coach (String type, String coachId, int totalSeats)
  {
    this.type = type;

    this.coachId = coachId;

    this.seatBookings = new HashMap<>();

    for (int i = 1; i <= totalSeats; i++)
    {
      seatBookings.put("S" + i, null);
    }
  }

  public String getCoachId()
  {
    return coachId;
  }

  public String getType()
  {
    return type;
  }

  public Map<String, Booking> getSeatBookings()
  {
    return seatBookings;
  }
}
