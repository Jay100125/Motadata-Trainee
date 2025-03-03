package multithreading.practice;

public class test3 extends Thread {

    public void run() {
        if(Thread.currentThread().isDaemon())
        {
            System.out.println("user therad");
        }
        else
        {
            System.out.println("something else");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test3 t = new test3();
        t.setDaemon(true);

       if(Thread.currentThread().isDaemon())
       {
           System.out.println("Main therad");
       }
       else
       {
           System.out.println("mainnnn else");
       }
       Thread.sleep(1000);

       t.start();
    }
}
