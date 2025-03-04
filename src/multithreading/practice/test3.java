package multithreading.practice;

import java.util.Comparator;

public class test3 extends Thread {
    private int counter = 0;
    public void run() {
//        if(Thread.currentThread().isDaemon())
//        {
//            System.out.println("My t is deamon");
//        }
//        else
//        {
//            System.out.println("my is alive");
//        }
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        test3 t = new test3();
//        t.setDaemon(true);
//        if(Thread.currentThread().isDaemon())
//        {
//            System.out.println("Main is deamon");
//        }
//        else
//        {
//            System.out.println("Main is alive");
//        }
        t.run();
       t.start();
        System.out.println(t.counter);

    }
}
