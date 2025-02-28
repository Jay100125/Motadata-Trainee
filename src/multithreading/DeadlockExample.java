package multithreading;
////
public class DeadlockExample {
    public static void main(String[] args) {

        // Start both threads
//        String resource1 = "Resource 1";
//        String resource2 = "Resource 2";
        Object resource1 = new Object();
        Object resource2 = new Object();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Waiting for resource 2...");
                while (true) {
                    synchronized (resource2) {
                        System.out.println("Thread 1: Finally got resource 2!");
                        break; // This line won't execute due to deadlock
                    }
                }
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                try {
                    Thread.sleep(100); // Initial delay to ensure both threads start
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for resource 1...");
                while (true) {
                    synchronized (resource1) {
                        System.out.println("Thread 2: Finally got resource 1!");
                        break; // This line won't execute due to deadlock
                    }
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}

// below code goes to infinite code not in deadlock
//package multithreading;
//
//public class DeadlockExample {
//    private static volatile boolean resource1Locked = false;
//    private static volatile boolean resource2Locked = false;
//
//    public static void main(String[] args) {
//
//        Thread thread1 = new Thread(() -> {
//            // Try to lock resource1
//            while (resource1Locked) {
//                System.out.println("Thread 1: Waiting for resource 1...");
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            resource1Locked = true;
//            System.out.println("Thread 1: Locked resource 1");
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // Try to lock resource2
//            System.out.println("Thread 1: Waiting for resource 2...");
//            while (resource2Locked) {
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            resource2Locked = true;
//            System.out.println("Thread 1: Locked resource 2");
//
//            resource1Locked = false;
//            resource2Locked = false;
//        });
//
//        // Thread 2
//        Thread thread2 = new Thread(() -> {
//            while (resource2Locked) {
//                System.out.println("Thread 2: Waiting for resource 2...");
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            resource2Locked = true;
//            System.out.println("Thread 2: Locked resource 2");
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // Try to lock resource1
//            System.out.println("Thread 2: Waiting for resource 1...");
//            while (resource1Locked) {
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            resource1Locked = true;
//            System.out.println("Thread 2: Locked resource 1");
//
//            resource1Locked = false;
//            resource2Locked = false;
//        });
//
//        thread1.start();
//        thread2.start();
//    }
//}
