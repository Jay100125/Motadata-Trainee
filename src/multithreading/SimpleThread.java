package multithreading;

class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // Pause for 1 second between prints
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SimpleThread {
    public static void main(String[] args) throws InterruptedException {
        NumberPrinter thread = new NumberPrinter();
        thread.start(); // Start the thread
        Thread.sleep(1000);
        thread.join();
        System.out.println("Main thread started");
        System.out.println(Thread.currentThread().getName());

        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
//        System.exit(0);
    }
}
