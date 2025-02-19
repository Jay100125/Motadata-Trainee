package practical;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prac20 {
    public static void main(String[] args) {
        List<Integer> empId = Arrays.asList(1, 2, 4);
        List<String> empName = Arrays.asList("Jay","jayesh", "kartikey");

        AtomicInteger count = new AtomicInteger(0);
       Map<Integer,String> map = empName.stream().collect(Collectors.toMap((e) -> empId.get(count.getAndIncrement()) , name -> name ));

        map.forEach((k,v)->{
            System.out.println(k + " " + v);
        });

    }
}
