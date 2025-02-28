package multithreading;

class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000); // Simulate background work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set thread as daemon
        daemonThread.start();

        System.out.println("Main thread sleeping for 3 seconds...");
        try {
            Thread.sleep(30000); // Main thread sleeps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished. Daemon thread will stop now.");
        // JVM exits automatically since only the daemon thread remains.
    }
}
