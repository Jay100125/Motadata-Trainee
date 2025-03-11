package multithreading;

public class WaitWithoutLock {
    public static void main(String[] args) {
        Object lock = new Object();

        // Trying to call wait() without holding the lock
        try {
            synchronized (lock) {

                lock.wait();  // This will throw IllegalMonitorStateException
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        } catch (IllegalMonitorStateException e) {
            System.out.println("Exception: " + e);
        }
    }
}