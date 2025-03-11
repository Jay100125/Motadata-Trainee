package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchWithExecutors {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(5);

        CountDownLatch countDownLatch = new CountDownLatch(3);
        executors.submit(new DependentService(countDownLatch));
        executors.submit(new DependentService(countDownLatch));
        executors.submit(new DependentService(countDownLatch));

        countDownLatch.await();

        System.out.println("all dependent services intialized");
        executors.shutdown();
    }
    public static class DependentService implements Runnable {
        private CountDownLatch countDownLatch;

        public DependentService(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void run() {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            countDownLatch.countDown();
        }
    }
}

