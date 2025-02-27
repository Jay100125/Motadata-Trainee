package multithreading;

public class NoThreadLocalDemo {
    // A regular static variable shared across all threads
    private static String sharedValue = "Initial Value";

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(), "Thread-1");
        Thread thread2 = new Thread(new Task(), "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final shared value: " + sharedValue);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            // Print the initial value of the shared variable
            System.out.println(Thread.currentThread().getName() +
                    " initial value: " + sharedValue);

            sharedValue = Thread.currentThread().getName() + " specific value";

            // Simulate some work (to increase chance of race condition)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +
                    " updated value: " + sharedValue);
        }
    }
}