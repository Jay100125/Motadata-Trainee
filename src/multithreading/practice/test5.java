package multithreading.practice;

//public class test5 extends Thread {
//    public void run() {
//      Thread.yield();
//
//      for(int i =0 ;i < 100000000 ;i++){
//          System.out.println("some");
//      }
//    }
//    public static void main(String[] args) throws InterruptedException {
//
//        test5 t = new test5();
//
//        t.start();
//        for(int i =0 ;i < 100000000 ;i++){
//            System.out.println("Main");
//        }
//        Thread.sleep(100000);
//
//    }
//}

class newthread implements Runnable
{
    Thread t1;
    Thread t2;
    newthread()
    {
        t1 = new Thread(this,"Thread_1");
        t2 = new Thread(this,"Thread_2");
        t1.start();
        t2.start();
    }
    public void run()
    {
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.print(t1.equals(t2));
    }
}
public class test5
{
    public static void main(String args[])
    {
        new newthread();
    }
}