package collection.and.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {

        //square using streams
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> square = list.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(square);
        list.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));

        System.out.println();
        List<String> names = Arrays.asList("John", "Jane", "Doe", "Bob");
        List<String> result = names.stream().filter( x -> x.startsWith("J")).collect(Collectors.toList());
        System.out.println(result);

        List<String> names2 = names.stream().filter(x -> x.equals("Jane")).filter(x -> x.endsWith("e")).collect(Collectors.toList());
        System.out.println(names2);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");
        map.put(3, "Doe");
        map.put(4, "Bob");

        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("hii");

        map.put(5, String.valueOf(list1));
        System.out.println(map.get(5));
        System.out.println(map.entrySet().stream().filter(x -> x.getKey() == 5).collect(Collectors.toList()));

        System.out.println(map.keySet().stream().filter(x -> x == 5).map(k -> k+1).collect(Collectors.toList()));
        System.out.println(map.values().stream().map(x -> x+"Hello").collect(Collectors.toList()));

        System.out.println(map.entrySet().stream().filter(e-> e.getValue()=="Jane").collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())));

        System.out.println(map);


        List<String> list2 = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");

        list2.stream().flatMap(num -> Stream.of(num)).forEach(System.out::println);

    }
}
