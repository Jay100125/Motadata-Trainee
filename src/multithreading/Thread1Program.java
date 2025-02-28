//package multithreading;

//public class Thread1Program {
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Thread-1: " + i);
//                try {
//                    Thread.sleep(1000); // Simulate some work
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "Thread-1");
//
//        thread1.start();
//
//        // Optional: Wait for thread to finish before JVM exits
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}

package multithreading;

import java.io.*;

public class Thread1Program {
    private static final String COUNTER_FILE = "./src/multithreading/counter.txt";

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (Thread1Program.class) // Lock to avoid race conditions
                {
                    int counter = readCounter();
                    counter++;
                    writeCounter(counter);
                    System.out.println("Thread-1 incremented counter to: " + counter);
                }
                try {
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int readCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            String line = reader.readLine();
            return line != null ? Integer.parseInt(line) : 0;
        } catch (IOException | NumberFormatException e) {
            return 0; // Default to 0 if file doesn’t exist or is invalid
        }
    }

    private static void writeCounter(int counter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(String.valueOf(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}