package multithreading;

public class DataRaceDemo {

    public static void main(String[] args) {

        sharedClass shared = new sharedClass();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < Integer.MAX_VALUE; i++)
                {
                    shared.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < Integer.MAX_VALUE; i++)
                {
                    shared.checkForDataRace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static class sharedClass {

        private int x = 0;
        private int y = 0;
        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x data race detected");
            }
        }
    }
}
