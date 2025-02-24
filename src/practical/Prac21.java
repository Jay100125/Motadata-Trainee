package practical;

// this is functional interface
// it contains only one abstract method
// generally used with lamda expression

import java.util.Arrays;
import java.util.Comparator;

interface StringProcessor {
    String process(String str);
}
public class Prac21 {
    public static void main(String[] args) {
        StringProcessor reverseString = str -> new StringBuilder(str.trim()).reverse().toString();
//
//        StringProcessor reverseString = str -> {
//            char[] chars = str.trim().toCharArray();
//            for (int i = 0; i < chars.length / 2; i++) {
//                char temp = chars[i];
//                chars[i] = chars[chars.length - 1 - i];
//                chars[chars.length - 1 - i] = temp;
//            }
//            return new String(chars);
//        };

//        reverse words instead of charcter
//        StringProcessor reverseString = str -> String.join(" ", Arrays.stream(str.trim().split("\\s+")).sorted(Comparator.reverseOrder()).toArray(String[]::new));

        String input = "         Hello World   123             ";
        System.out.println(reverseString.process(input));

        String s = "Jay patel";
        System.out.println(reverseString.process(s));

        StringBuilder stringBuilder = new StringBuilder("jeet patel");
        System.out.println(reverseString.process(stringBuilder.toString()));
    }
}
