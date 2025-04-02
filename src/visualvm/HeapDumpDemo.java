package visualvm;
import java.util.ArrayList;

public class HeapDumpDemo {
  public static void main(String[] args) throws InterruptedException {
    ArrayList<StringBuilder> memoryHog = new ArrayList<>();

    for (long i = 0; i < 1_000_000_000; i++) {
      StringBuilder stringBuilder = new StringBuilder(10_000);
      stringBuilder.append("hello");
      memoryHog.add(stringBuilder);

      Thread.sleep(10);
      System.out.println("Added");
    }
  }
}
