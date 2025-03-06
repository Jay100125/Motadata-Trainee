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

            threadLocal.set(Thread.currentThread().getName() + " specific value");
            System.out.println(Thread.currentThread().getName() +
                    " updated value: " + threadLocal.get());

            threadLocal.remove();
        }
    }
}
