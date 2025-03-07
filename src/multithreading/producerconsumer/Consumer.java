package multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable{
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    public void run() {
        try
        {
            while (true)
            {
                Object obj = queue.take();
                System.out.println("Consumed resource - Queue size now = "  + queue.size());
                take(obj);
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    void take(Object obj)
    {
        try
        {
            Thread.sleep(100); // simulate time passing
        }
        catch (InterruptedException ex)
        {
            System.out.println("Consumer Read INTERRUPTED");
        }
        System.out.println("Consuming object " + obj);
    }
}
