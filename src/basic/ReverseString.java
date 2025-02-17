package basic;

public class ReverseString {
    public static void main(String[] args) {
        String str = "HELLO WORLD";

        String reverseStr = reverseMyString(str);
        System.out.println(reverseStr);
    }

    public static String reverseMyString(String str) {
        if(str == null || str.length() <= 1)
            return str;

        return reverseMyString(str.substring(1)) + str.charAt(0);
    }
}
