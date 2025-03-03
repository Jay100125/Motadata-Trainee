package multithreading.practice;

public class test4 extends Thread {
    public void start()
    {
        System.out.println("start");
    }
    public void run()
    {
        System.out.println("this is run");
    }
    public static void main(String[] args) {
        test4 obj = new test4();
        obj.start();
    }
}
