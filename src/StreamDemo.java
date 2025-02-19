import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Java");
        stringList.add("Python");
        long i = stringList.stream().filter(s -> s.equals("Hello")).count();
        //System.out.println(i);
        stringList.stream().sorted().forEach(string -> System.out.println(string));

        stringList.stream().forEach(string -> System.out.println(string));
//        System.out.println(i);

        List<Integer> integerList =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        integerList.stream().forEach(integer -> System.out.println(integer));

        Optional<Integer> sum = integerList.stream().reduce((a, b) -> a + b);
        System.out.println(sum);
       List<Integer> evenNumbers =  integerList.parallelStream().filter(integer -> integer %2 == 0).collect(Collectors.toList());
       //System.out.println(evenNumbers);

    }
}
