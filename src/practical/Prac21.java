package practical;

// this is functional interface
// it contains only one abstract method
// generally used with lamda expression

interface StringProcessor {
    String process(String str);
}
public class Prac21 {
    public static void main(String[] args) {
        StringProcessor reverseString = str -> new StringBuilder(str).reverse().toString();

        String input = "Hello World";
        System.out.println(reverseString.process(input));

        String s = "Jay";
        System.out.println(reverseString.process(s));
    }
}
