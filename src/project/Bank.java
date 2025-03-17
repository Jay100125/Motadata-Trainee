import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

class Train{
  private String trainId;
  private String source;
  private String destination;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
  private List<Coach> coaches;
}

class Coach{
  private String coachId;
  private String type; // e.g., "Sleeper", "AC"
  private Map<String, Seat> seats;
}


class Seat{
  private String seatNumber;
  private boolean isBooked;
}

class Booking {
  private String bookingId;
  private String userId;
  private String trainId;
  private String coachId;
  private List<Seat> seats;
  private boolean isCancelled;
}
