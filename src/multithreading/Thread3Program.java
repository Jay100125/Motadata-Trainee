package multithreading;

import java.io.*;

public class Thread3Program {
    private static final String COUNTER_FILE = "./src/multithreading/counter.txt";

    public static void main(String[] args) {
        Thread thread3 = new Thread(() -> {
            while (true) {
                int counter = readCounter();
                System.out.println("Thread-3 read counter: " + counter);
                try {
                    Thread.sleep(500); // Check every 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }, "Thread-3");

        thread3.start();
        // Let it run for a bit, then stop (for demo purposes)
        try {
            Thread.sleep(5000); // Run for 5 seconds
//            thread3.interrupt();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int readCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            String line = reader.readLine();
            return line != null ? Integer.parseInt(line) : 0;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading counter: " + e.getMessage());
            return 0; // Default to 0 if file doesn’t exist or is invalid
        }
    }
}