package multithreading.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class demp {
    Lock lock = new ReentrantLock();
    void print() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        print2();
        lock.lockInterruptibly();
        System.out.println("demp");
    }
     void print2() throws InterruptedException {
        try {
             Thread.sleep(5000);
             System.out.println("demp2");
         }finally {
            lock.unlock();
        }
    }
}
public class test7 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                demp d = new demp();
                try {
                    d.print();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                demp d2 = new demp();
                try {
                    d2.print2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();
    }
}
