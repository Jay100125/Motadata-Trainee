package practical;

import java.util.Arrays;

public class Prac18 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int result = Arrays.stream(arr).filter(x -> x % 2 == 0).sum();
        System.out.println(result);
    }
}
