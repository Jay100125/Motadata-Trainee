package multithreading;

import java.util.Arrays;
import java.util.Collections;

public class VolatileVisibilityTest {
    private int x = 1;              // Regular variable
    private volatile int signal = 0; // Volatile variable

    public void writer() throws InterruptedException {

        x = 42;   // Write to non-volatile variable
        signal = 1;    // Write to volatile variable

    }

    public void reader() {
        while (signal != 1) { // Read volatile variable

        }

        System.out.println("x = " + x); // Read non-volatile variable

    }

    public static void main(String[] args) throws InterruptedException {
        VolatileVisibilityTest example = new VolatileVisibilityTest();

        Thread writerThread = new Thread(() -> {
            try {
                example.writer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread readerThread = new Thread(() -> {
            example.reader();
        });

//        Thread.sleep(1000);
        readerThread.start();
        writerThread.start();



    }
}

