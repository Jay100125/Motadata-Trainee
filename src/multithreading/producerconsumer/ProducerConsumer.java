package multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException
    {
        int numProducers = 3;
        int numConsumers = 5;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<>(20);

        for (int i = 0; i < numProducers; i++){
            new Thread(new Producer(myQueue)).start();
        }

        for (int i = 0; i < numConsumers; i++){
            new Thread(new Consumer(myQueue)).start();
        }

        // Let the simulation run for, say, 10 seconds
        Thread.sleep(10 * 1000);

        // End of simulation - shut down gracefully
        System.exit(0);
    }
}
