package multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try{
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced Resources Queue size now " + queue.size());
            }
        }
        catch (InterruptedException e){
            System.out.println("Producer interrupted");
        }
    }

    Object getResource() throws InterruptedException {
        Thread.sleep(100);
        return new Object();
    }
}
