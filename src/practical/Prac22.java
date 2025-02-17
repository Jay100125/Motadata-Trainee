package practical;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class Prac22 {
    public static void main(String[] args) {

        Integer[] arr = {5,10,15,20,25,30,35,40,50,60,70,80,90};

        Predicate<Integer> greaterThan10 = x -> x > 10;

        Integer[] arr2 = Arrays.stream(arr).filter(greaterThan10).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    }
}
