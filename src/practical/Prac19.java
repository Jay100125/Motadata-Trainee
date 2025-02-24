package practical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Use streams to filter out all names starting with "A" from a list of strings and convert them
to uppercase.
 */
public class Prac19 {
    public static void main(String[] args) {
        String[] strArr = {"Aman", "Anita", "jay", "jayesh", "Kartikey", "aladin", "akaay","Aman"};

        List<String> result = Arrays.stream(strArr).filter(name -> name.toUpperCase().startsWith("A")).map(String::toUpperCase).distinct().collect(Collectors.toList());

        System.out.println(Arrays.toString(strArr));
        System.out.println(result);
    }
}
