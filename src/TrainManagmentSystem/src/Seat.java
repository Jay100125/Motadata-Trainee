package TrainManagmentSystem.src;

public class Seat {
  private String seatNumber;
  private boolean isBooked;
//  private Booking booking;

  public Seat(String seatNumber) {
    this.seatNumber = seatNumber;
    this.isBooked = false;
//    this.booking = null;
  }

  public String getSeatNumber() { return seatNumber; }
  public boolean isBooked() { return isBooked; }
//  public Booking getBooking() { return booking; }
  public void setBooked(boolean booked) { this.isBooked = booked; }
//  public void setBooking(Booking booking) { this.booking = booking; }
}
