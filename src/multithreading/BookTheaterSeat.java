package multithreading;

import java.util.Arrays;
import java.util.List;

public class BookTheaterSeat {
    static final int ROWS = 10;
    static final int COLS = 10;
    static int[][] seats = new int[ROWS][COLS]; // 0 = available, 1 = booked

    public synchronized void displaySeats() {
        System.out.println("\nCurrent Seat Availability:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print((seats[i][j] == 0 ? "[O]" : "[X]") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public synchronized boolean bookSeat(List<int[]> selectedSeats) {
        for(int[] seat : selectedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS || seats[row][col] == 1) {
                System.out.println(Thread.currentThread().getName() + " Sorry, seat (" + row + ", " + col + ") is already booked or invalid.");
                return false;
            }
        }

        for(int[] seat : selectedSeats) {
            seats[seat[0]][seat[1]] = 1;
        }
        System.out.println(Thread.currentThread().getName() + " Successfully booked seats ");
        displaySeats();
        return true;
    }
}


//package multithreading;
//
//public class BookTheaterSeat
//{
//    static final int ROWS = 10;
//    static final int COLUMNS = 10;
//    static int[][] seats = new int[ROWS][COLUMNS];
//
//    static int totalSeats=10;
//
//    public synchronized void displaySeats()
//    {
//        System.out.println("Current available seats: ");
//        for(int i = 0; i < ROWS; i++)
//        {
//            for(int j = 0; j < COLUMNS; j++)
//            {
//                System.out.print(seats[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//
//    public synchronized boolean bookSeat(int row, int col, int numSeats)
//    {
//
//        for (int i = col; i < col + numSeats; i++) {
//            if (seats[row][i] == 1) { // Seat already booked
//                System.out.println(Thread.currentThread().getName() + " Sorry, some seats are already booked.");
//                return false;
//            }
//        }
//        for (int i = col; i < col + numSeats; i++) {
//            seats[row][i] = 1;
//        }
//        System.out.println(Thread.currentThread().getName() + " Successfully booked " + numSeats + " seats.");
//        displaySeats();
//        return true;
//    }
//
//}