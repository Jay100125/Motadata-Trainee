package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class NestedMonitorLockout {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private boolean condition = false;

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                condition = true;
                lock2.notify();
            }
        }
    }

    public void method2() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            while (!condition) {
                synchronized (lock2) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " acquired lock2, waiting...");
                        lock2.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Interrupted");
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished waiting, condition is true");
        }
    }

    public static void main(String[] args) {
        NestedMonitorLockout example = new NestedMonitorLockout();

        Thread t1 = new Thread(example::method1, "Thread-1");

        Thread t2 = new Thread(example::method2, "Thread-2");

        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}