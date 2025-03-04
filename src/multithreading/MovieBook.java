package multithreading;

import java.util.Arrays;
import java.util.List;

public class MovieBook extends Thread {
    static BookTheaterSeat bookTicket = new BookTheaterSeat();
    List<int[]> selectedSeats;

    public MovieBook(List<int[]> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    @Override
    public void run() {
        bookTicket.bookSeat(selectedSeats);
    }

    public static void main(String[] args) {
        bookTicket.displaySeats();


        MovieBook customer1 = new MovieBook(Arrays.asList(new int[]{1, 1}, new int[]{2, 4}));
        MovieBook customer2 = new MovieBook(Arrays.asList(new int[]{3, 3}, new int[]{4, 6}));
        MovieBook customer3 = new MovieBook(Arrays.asList(new int[]{1, 1}, new int[]{3, 4}));
        MovieBook customer4 = new MovieBook(Arrays.asList(new int[]{5, 2}, new int[]{7, 5}));
        MovieBook customer5 = new MovieBook(Arrays.asList(new int[]{6, 8}, new int[]{8, 9}));

//        MovieBook customer1 = new MovieBook(2, 3, 4);
//        MovieBook customer2 = new MovieBook(4, 6, 2);
//        MovieBook customer3 = new MovieBook(2, 3, 2);
//        MovieBook customer4 = new MovieBook(6, 1, 5);
//        MovieBook customer5 = new MovieBook(6, 7, 3);
//        MovieBook customer6 = new MovieBook(6, 8, 4);

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
//        customer6.start();
    }
}

////
////bookTicket = new BookTheaterSeat();
////
////MovieBook customer1 = new MovieBook();
////
////customer1.seats = 7;
////
////
////
////MovieBook customer2 = new MovieBook();
////
////customer2.seats = 2;
////
////
////
////MovieBook customer3 = new MovieBook();
////
////customer3.seats = 1;
////
//////        try
//////        {
//////            customer2.join();
//////        }
//////        catch (InterruptedException e)
//////        {
//////            throw new RuntimeException(e);
//////        }
////
////MovieBook customer4 = new MovieBook();
////
////customer4.seats = 5;
////
////
////
////        customer1.start();
////        customer2.start();
////        customer3.start();
////        customer4.start();
////
//package multithreading;


