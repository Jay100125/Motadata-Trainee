package multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ScheduledThreadPool {
//    public static void main(String[] args) throws InterruptedException {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//        Runnable runnableJob = () -> {
//            System.out.println("Started Execution On:" + LocalDateTime.now());
//            System.out.println("Hello World");
//            System.out.println("Completed Execution On:" + LocalDateTime.now());
//            System.out.println("\n");
//        };
//
//        scheduledExecutorService.scheduleAtFixedRate(runnableJob, 5, 5, TimeUnit.SECONDS);
//    }
public static void main(String[] args) throws InterruptedException, ExecutionException {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    CountDownLatch count = new CountDownLatch(2);

    Runnable runnableJob = () -> {
        System.out.println("Started Execution On:" + LocalDateTime.now());
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Completed Execution On:" + LocalDateTime.now());
        count.countDown();
        System.out.println("\n");
    };

    scheduledExecutorService.scheduleAtFixedRate(runnableJob, 5, 5, TimeUnit.SECONDS);
    count.await();
    scheduledExecutorService.shutdown();


}
}