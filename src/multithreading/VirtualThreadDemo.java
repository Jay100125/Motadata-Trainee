package multithreading;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {
    private static final int VIRTUAL_THREADS = 20;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside thread : " + Thread.currentThread());

        List<Thread> virtualThreads = new ArrayList<>();

        for(int i = 0; i < VIRTUAL_THREADS; i++)
        {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }

        for(Thread virtualThread : virtualThreads)
        {
            virtualThread.start();
        }

        for(Thread virtualThread : virtualThreads)
        {
            virtualThread.join();
        }
    }
}
