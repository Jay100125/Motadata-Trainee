package multithreading;
public class ThreadLocalDemo {
    private static final ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(() -> "Initial Value");

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task(), "Thread-1");
        Thread thread2 = new Thread(new Task(), "Thread-2");

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            // Each thread gets its own copy of the ThreadLocal variable
            System.out.println(Thread.currentThread().getName() +
                    " initial value: " + threadLocal.get());

            // Modify the value for this thread
            threadLocal.set(Thread.currentThread().getName() + " specific value");

            // Print the updated value
            System.out.println(Thread.currentThread().getName() +
                    " updated value: " + threadLocal.get());

            // Clean up (optional, good practice)
            threadLocal.remove();
        }
    }
}
