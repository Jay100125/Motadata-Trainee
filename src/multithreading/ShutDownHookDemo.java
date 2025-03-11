package multithreading;

public class ShutDownHookDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);

        Thread printingHook = new Thread(() -> System.out.println("In the middle of a shutdown"));
        Runtime.getRuntime().addShutdownHook(printingHook);

        System.out.println("Hello world!");
    }
}
