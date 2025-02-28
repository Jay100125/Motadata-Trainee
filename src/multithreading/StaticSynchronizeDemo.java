package multithreading;
public class StaticSynchronizeDemo {
    private static int count = 0;

    public static synchronized void add(int value) {
        System.out.println(Thread.currentThread().getName() + " entered add method");
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
            count += value;
            System.out.println(Thread.currentThread().getName() + " adding " + value + ", count = " + count);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " exiting add method");
    }

    public static synchronized void subtract(int value) {
        System.out.println(Thread.currentThread().getName() + " entered subtract method");
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
            count -= value;
            System.out.println(Thread.currentThread().getName() + " subtracting " + value + ", count = " + count);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " exiting subtract method");
    }

    public static void main(String[] args) {
        // Thread 1: Calls add
        Thread t1 = new Thread(() -> {
            StaticSynchronizeDemo.add(10);
        }, "Thread-1");

        // Thread 2: Calls subtract
        Thread t2 = new Thread(() -> {
            StaticSynchronizeDemo.subtract(5);
        }, "Thread-2");

        t1.start();
        t2.start();

        // Wait for both threads to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + count);
    }
}


//public class StaticSynchronizeDemo {
//    private int count = 0; // Changed to instance variable since methods are no longer static
//
//    // Non-static, non-synchronized method
//    public synchronized void add(int value) {
//        System.out.println(Thread.currentThread().getName() + " entered add method");
//        try {
//            Thread.sleep(2000); // Sleep for 2 seconds
//            count += value;
//            System.out.println(Thread.currentThread().getName() + " adding " + value + ", count = " + count);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(Thread.currentThread().getName() + " exiting add method");
//    }
//
//    // Non-static, non-synchronized method
//    public void subtract(int value) {
//        System.out.println(Thread.currentThread().getName() + " entered subtract method");
//        try {
//            Thread.sleep(2000); // Sleep for 2 seconds
//            count -= value;
//            System.out.println(Thread.currentThread().getName() + " subtracting " + value + ", count = " + count);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(Thread.currentThread().getName() + " exiting subtract method");
//    }
//
//    public static void main(String[] args) {
//        // Create an instance of StaticSynchronizeDemo
//        StaticSynchronizeDemo demo = new StaticSynchronizeDemo();
//
//        // Thread 1: Calls add on the instance
//        Thread t1 = new Thread(() -> {
//            demo.add(10);
//        }, "Thread-1");
//
//        // Thread 2: Calls subtract on the same instance
//        Thread t2 = new Thread(() -> {
//            demo.subtract(5);
//        }, "Thread-2");
//
//        t1.start();
//        t2.start();
//
//        // Wait for both threads to complete
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        System.out.println("Final count: " + demo.count);
//    }
//}