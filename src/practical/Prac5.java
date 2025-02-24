package practical;

import java.util.Arrays;

public class Prac5 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3,4,5,6,7};

        int result = Arrays.stream(arr).filter(x -> x % 2 != 0).map(x ->  x * x).sum();

        System.out.println(result);

        // what if overflow occurs--> by default java wraps around converting them to negative numbers

        int arr2[] = new int[]{1,2,3,4,Integer.MAX_VALUE};

        long result2 = Arrays.stream(arr2).filter(x -> x % 2 != 0).mapToLong(x-> (long)x*x).sum();

        System.out.println(result2);

    }

}
