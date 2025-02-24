package practical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prac18 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,5));
        int result = Arrays.stream(arr).filter(x -> x % 2 == 0).sum();

//        int result2 = list.stream().filter(x -> x %2 == 0)
//        System.out.println(result2);
        System.out.println(result);
    }
}
