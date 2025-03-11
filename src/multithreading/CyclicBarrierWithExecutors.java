package multithreading;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierWithExecutors {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        executorService.execute(new Task4(cyclicBarrier));
        executorService.execute(new Task4(cyclicBarrier));
        executorService.execute(new Task4(cyclicBarrier));

        Thread.sleep(1000);

    }

    public static class Task4 implements Runnable {

        private CyclicBarrier cyclicBarrier;
        public Task4(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            while(true)
            {
                try{
                    System.out.println(cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Notification to all");
            }
        }
    }
}
