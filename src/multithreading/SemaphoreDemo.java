package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static final Semaphore semaphore = new Semaphore(5, true);
    private static int resourceUsageCount = 0;

    public void useResource(String threadName) {
        try {
            System.out.println(threadName + " is waiting to acquire a resource...");
            semaphore.acquire();
            synchronized (SemaphoreDemo.class) {
                resourceUsageCount++;
                System.out.println(threadName + " acquired a resource. Total in use: " + resourceUsageCount);
            }

            Thread.sleep(2000);

            synchronized (SemaphoreDemo.class) {
                resourceUsageCount--;
                System.out.println(threadName + " released a resource. Total in use: " + resourceUsageCount);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(threadName + " was interrupted");
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo example = new SemaphoreDemo();

        Thread t1 = new Thread(() -> example.useResource("Thread-1"), "Thread-1");
        Thread t2 = new Thread(() -> example.useResource("Thread-2"), "Thread-2");
        Thread t3 = new Thread(() -> example.useResource("Thread-3"), "Thread-3");
        Thread t4 = new Thread(() -> example.useResource("Thread-4"), "Thread-4");
        Thread t5 = new Thread(() -> example.useResource("Thread-5"), "Thread-5");
        Thread t6 = new Thread(() -> example.useResource("Thread-6"), "Thread-6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads completed.");
    }
}