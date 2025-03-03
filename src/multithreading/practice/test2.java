package multithreading.practice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class test2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });


        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
//
////        t1.setDaemon(true);
////        t2.setDaemon(true);
        t1.start();
////        t2.start();
////        Thread.sleep(10);
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread());
//        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
//
//        boolean oldValue = atomicBoolean.getAndSet(false);
//
//        System.out.println(oldValue);
//        System.out.println(atomicBoolean.get());
//
//        AtomicInteger atomicInteger = new AtomicInteger(123);
//
//        int expectedValue = 123;
//        int newValue      = 234;
//        atomicInteger.compareAndSet(expectedValue, newValue);
//
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.getAndAdd(10));
//        System.out.println(atomicInteger.addAndGet(10));


    }
}
