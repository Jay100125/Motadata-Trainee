package basic;
//Scanner is not thread-safe by default. If you’re using it in a multi-threaded environment, you may need to synchronize access or use a different approach (like BufferedReader with explicit synchronization).
// next() only one word
// nextLine() whole string until you enter
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        // Scanner definition
        Scanner scn = new Scanner(System.in);

        // input is a string(one word)
        // read by next() method
        String str1 = scn.nextLine();

        // print string
        System.out.println("Entered String str1: " + str1);

        // input is an integer
        // read by nextInt() method
        int x = scn.nextInt();

        // print integer
        System.out.println("Entered Integer: " + x);

        // input is a floatingValue
        // read by nextFloat() method
        float f = scn.nextFloat();

        // print floating value
        System.out.println("Entered FloatValue: " + f);

        float y = scn.nextInt();
        System.out.println(y);

    }
}
