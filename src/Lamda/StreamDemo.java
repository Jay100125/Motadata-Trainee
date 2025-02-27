package Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        list.stream().forEach(System.out::println);
//        list.parallelStream().forEach(System.out::println);

        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");
//
//        Stream<String> stream = items.stream();
//       stream
//                .map((value) -> { return value.toUpperCase(); })
//                .forEach(System.out::println);

//        System.out.println("count = " + count);
//        List<String> stringList = new ArrayList<String>();
//
//        stringList.add("abc");
//        stringList.add("def");
//
//        Stream<String> stream = stringList.stream();
//
//        Stream<String> streamPeeked = stream.peek((value) -> {
//            System.out.println("value");
//        });

        AtomicInteger i = new AtomicInteger();
        Stream.iterate(1,n -> n+1).limit(1000).forEach(System.out::println);
        Stream.generate(() -> i.addAndGet(1)).limit(1000).forEach(System.out::println);

//        IntStream.rangeClosed(1, 100)
//                .forEach(System.out::println);


        List<String> stringList = new ArrayList<String>();

        stringList.add(null);
//        stringList.add("One flew over the cuckoo's nest");
//        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

//        long count = stream.flatMap((value) -> {
//                    String[] split = value.split(" ");
//                    return (Stream<String>) Arrays.asList(split).stream();
//                })
////                .count();
//
//        System.out.println("count = " + count);
//
//        Optional<String> anyElement = stream.findAny();
//        System.out.println(anyElement.isPresent());
//        System.out.println(anyElement.get());



        List<List<List<Integer>>> ll = Arrays.asList(
               Arrays.asList(Arrays.asList(1,2,4,4),Arrays.asList(5,6,9),Arrays.asList(7,8,9)),
                Arrays.asList(Arrays.asList(1,2,4,4),Arrays.asList(5,6,9),Arrays.asList(7,8,9))
        );

        Stream<List<List<Integer>>> ss = ll.stream();
//        ss.filter(x -> x.contains(1)).forEach(System.out::println);
//        ss.flatMap(x -> {return x.contains(1)}).forEach(System.out::println);

        ss.flatMap(l -> l.stream().flatMap(r->r.stream())).forEach(System.out::println);


        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Stream<Integer> stream1 = list.stream();
//        Optional<Integer> op1 = stream1.reduce((a,b)->a+b);
//        System.out.println(op1.get());
    }
}
