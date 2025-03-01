package practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prac22 {
    public static void main(String[] args) {

 Integer[] arr = {11,4,5,50,20,25,30,35,40,50,60,70,80,90};
//
//        Predicate<Integer[]> greaterThan10 = x -> {
//          for(int i : x){
//              if(i <= 10){
//                  return false;
//              }
//          }
//
//          return true;
//        };
         Predicate<Integer> greaterThan10 = x -> x != null && x > 10;
            Predicate<Integer> evenAlso = x -> x % 2 == 0;
//         for(int i : arr)
//         {
//             if(greaterThan10.test(i))
//                 System.out.println(i);
//         }

        List<Integer> ll = Arrays.stream(arr).filter(greaterThan10.and(evenAlso)).collect(Collectors.toList());
         System.out.println(ll);
      //  Arrays.stream(arr).filter(x -> x > 10).forEach(System.out::println);

//            System.out.println(greaterThan10.test(arr));
//        System.out.println(Arrays.toString(arr2));
    }
}
