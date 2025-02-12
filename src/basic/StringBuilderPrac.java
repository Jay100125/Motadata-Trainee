package basic;

public class StringBuilderPrac {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.reverse());
        System.out.println(sb.reverse());
        sb.setCharAt(2,'a');
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(sb.indexOf("World"));
    }
}
