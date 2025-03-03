package multithreading.practice;
import java.util.function.Supplier;

class ChocolateBox {
    private ThreadLocal<Integer> chocolates = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return 5;
        }
    };

    InheritableThreadLocal<Integer> inheritables = new InheritableThreadLocal<>() {};

    public void eat() {
        Integer availableChocolate = chocolates.get();

        if (availableChocolate == 0) {
            System.out.println("Dear " + Thread.currentThread().getName() + " You've eaten all you chocolates ");
        } else {
            chocolates.set(--availableChocolate);
            System.out.println("Dear " + Thread.currentThread().getName() + " You ate one chocolate");
        }
    }

    public void availableChocolates() {
        System.out.println("Dear " + Thread.currentThread().getName() + " You have "
                + chocolates.get() + " Chocolates");
    }

}

public class test {
    private static int counter = 10;
    public static void main(String[] args) throws InterruptedException {

//        ChocolateBox chocolateBox = new ChocolateBox();
//
//        Thread kid1 = new Thread(() -> {
//            chocolateBox.eat();
//            chocolateBox.eat();
//            chocolateBox.eat();
//            chocolateBox.availableChocolates();
//        }, "KidOne");
//
//        Thread kid2 = new Thread(() -> {
//            chocolateBox.eat();
//            chocolateBox.availableChocolates();
//            chocolateBox.eat();
//            chocolateBox.availableChocolates();
//        }, "KidTwo");
//
//        kid1.start();
//        kid2.start();



        Thread readingThread = new Thread(() -> {
            while (true) {
                if (counter == 11) {
                    System.out.println("Counter: " + counter);
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread modifyingThread = new Thread(() -> {
            System.out.print("Modifying Counter from " + counter);
            counter++;
            System.out.println(" To " + counter);
        });

        readingThread.start();
        modifyingThread.start();
            }

        }


//import java.util.concurrent.locks.ReentrantLock;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import java.util.concurrent.locks.Lock;
//
//import java.util.concurrent.locks.ReentrantLock;
//
//
//public class test
//{
//
//    ReentrantLock lock = new ReentrantLock();
//
//    public int factorial (int n)
//    {
//
//        int ans = 0;
//
//        if ( n == 0 )
//        {
//            return ans = 1;
//        }
//        else
//        {
//            lock.lock();
//
//            System.out.println(Thread.currentThread().getName()+" - "+lock.getHoldCount()+" ");
//
//            ans = (n) * (factorial(n - 1));
//
//            System.out.println(Thread.currentThread().getName()+" - "+lock.getHoldCount()+" ");
//
////            if(lock.getHoldCount()==3)
////            {
////                lock.unlock();
////            }
//
//            lock.unlock();
//        }
//        return ans;
//    }
//
//    public static void main (String[] args)
//    {
//        test reentrantLock = new test();
//
//        Thread hread = new Thread(new Runnable()
//        {
//
//            @Override
//            public void run ()
//            {
//
//                System.out.println(reentrantLock.factorial(5));
//
//            }
//        });
//
//        Thread thread = new Thread(new Runnable()
//        {
//
//            @Override
//            public void run ()
//            {
//
//                System.out.println(reentrantLock.factorial(9));
//
//            }
//        });
//
//        hread.start();
//
//        thread.start();
//    }
//
//}

//public class test extends Thread
//{
//
//    @Override
//    public void run() {
//        System.out.println("I am in run method");
//        System.out.println(Thread.currentThread().getName());
//    }
//
//    public static void main(String[] args) {
//        test javaThreadCreation2 = new test();
//        Thread javathread = new Thread(javaThreadCreation2);
//
//        javathread.start();
//        javaThreadCreation2.start();
//
//    }
//
//
//}
