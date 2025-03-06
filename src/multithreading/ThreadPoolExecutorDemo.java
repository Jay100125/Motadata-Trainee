package multithreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());

        for(int i = 0; i < 100; i++)
        {
//            Thread.sleep(4000);
            executor.execute(() -> {
                System.out.println("Task submitted by " + Thread.currentThread().getName());
            });
        }


//        ThreadPoolExecutor executor2 = new
//
//        executor.shutdown();
    }

}

class CustomThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(false);
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
        System.out.println("Rejected");
    }
}