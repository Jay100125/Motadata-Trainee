package multithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadlockDetection
{
    public static void detectDeadlocks() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        while (true) {
            long[] threadIds = threadMXBean.findDeadlockedThreads();
            if (threadIds != null && threadIds.length > 0) {
                System.out.println("Deadlock detected! Affected threads: ");
                for (long id : threadIds) {
                    System.out.println("Thread ID: " + id);
                }
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args)
    {
        final String resource1 = "Jay Patel";
        final String resource2 = "jay patel";
        Thread t1 = new Thread()
        {
            public void run ()
            {
                synchronized ( resource1 )
                {
                    System.out.println("Thread 1: locked resource 1");
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch ( Exception e )
                    {
                    }
                    synchronized ( resource2 )
                    {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };


        Thread t2 = new Thread()
        {
            public void run ()
            {
                synchronized ( resource2 )
                {
                    System.out.println("Thread 2: locked resource 2");

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch ( Exception e )
                    {
                    }

                    synchronized ( resource1 )
                    {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };


        t1.start();

        t2.start();

        DeadlockDetection.detectDeadlocks();
    }

}