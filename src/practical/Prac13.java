package practical;

import java.util.List;
import java.util.Objects;

public class Prac13 {
    public static void printList(List<?> list)
    {
        for(Object t : list)
        {
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Jay", "jayesh", "Purvik", "kartikey");

        printList(words);
        printList(number);


    }
}
