package multithreading;

public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(10000);
            }
            System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getPriority());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadDemo td = new ThreadDemo();
//        System.out.println(Thread.currentThread());
//        Thread t1 = new Thread(td);
//        t1.start();
//        System.out.println(td.getState()); // new
//        td.start();
//        System.out.println(td.getState()); // runnable
//        Thread.sleep(1000);
//        System.out.println(td.getState()); // time waiting
//        td.join();
//        System.out.println(td.getState()); // terminated
//
//        t1.join(); // wait till this execute
//        System.out.println("hello");
//
//        System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getPriority());
        Thread thread = new Thread(() -> System.out.println("Hello from " +
                Thread.currentThread().getName()));
        thread.setName("New Thread");
        thread.run();
        thread.start();

        Thread.sleep(2000);


    }
}


//thread.run() does not start the new thread. Instead, it simply runs the run() method of the Runnable object passed into the Thread constructor.

//When we override the start method we need to call super.start(); to make sure Thread's original start() method is called. Otherwise the thread will not be started.
