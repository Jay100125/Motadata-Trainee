package practical;

import java.util.Arrays;

public class Prac5 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int result = Arrays.stream(arr).filter(x -> x % 2 != 0).map(x -> x * x).sum();

        System.out.println(result);
    }

}
