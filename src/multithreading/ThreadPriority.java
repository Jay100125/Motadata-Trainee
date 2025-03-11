package multithreading;

//public class ThreadPriority extends Thread {
//    public void run() {
//        System.out.println(Thread.currentThread().getPriority() + "  " + Thread.currentThread().getName());
//    }
//    public static void main(String[] args) {
//
//
//        ThreadPriority t1 = new ThreadPriority();
//        ThreadPriority t2 = new ThreadPriority();
//        ThreadPriority t3 = new ThreadPriority();
//
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t3.setPriority(Thread.NORM_PRIORITY);
//
//        t2.start();
//        t3.start();
//        t1.start();
//    }
//}


import java.util.HashMap;
import java.util.Properties;

public class ThreadPriority extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " Priority: " + Thread.currentThread().getPriority());
        for (int i = 0; i < 10_000_000; i++) {} // CPU-bound task
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadPriority();
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1

        Thread t2 = new ThreadPriority();
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5

        Thread t3 = new ThreadPriority();
        t3.setPriority(Thread.MAX_PRIORITY); // Priority 10

        t1.start();
        t2.start();
        t3.start();


//        Properties prop = new Properties();
//        prop.computeIfAbsent();

        HashMap<Integer, String> hh = new HashMap<>();
        hh.put(1, "one");
        hh.put(2, "two");
        hh.put(3, "three");

        System.out.println(hh.computeIfAbsent(4, k->"Three"));
        System.out.println(hh.putIfAbsent(3, "four"));
//        hh.putIfAbsent()
    }
}
