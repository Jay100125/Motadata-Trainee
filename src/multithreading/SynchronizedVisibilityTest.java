package multithreading;

class Values {
    public int valA;
    public int valB;
    public int valC;

    public Values(int a, int b, int c) {
        this.valA = a;
        this.valB = b;
        this.valC = c;
    }
}

public class SynchronizedVisibilityTest {
    private int valA;
    private int valB;
    private int valC;

    public void set(Values v) {
        this.valA = v.valA;
        this.valB = v.valB;
        synchronized(this) {
            this.valC = v.valC;
        }
    }

    public void get(Values v) {
        synchronized(this) {
            v.valC = this.valC;
        }

        v.valB = this.valB;
        v.valA = this.valA;
    }

    public static void main(String[] args) {
        SynchronizedVisibilityTest syncTest = new SynchronizedVisibilityTest();
        Values values = new Values(0, 2, 3);

        Thread writer = new Thread(() -> {
            syncTest.set(values);
            System.out.println("Values set: " + values.valA + ", " + values.valB + ", " + values.valC);
        });

        Thread reader = new Thread(() -> {
            Values readValues = new Values(0, 0, 0);
            syncTest.get(readValues);
            System.out.println("Values read: " + readValues.valA + ", " + readValues.valB + ", " + readValues.valC);
        });
        writer.start();
        reader.start();
        try {
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
