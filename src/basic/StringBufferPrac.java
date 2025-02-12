package basic;

// (older capacity * 2) + 2
public class StringBufferPrac {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" World!");

        System.out.println(sb);

        System.out.println(sb.capacity());
        System.out.println(sb.length());
        System.out.println(sb.reverse());
        System.out.println(sb.reverse());
        System.out.println(sb.charAt(2));
        System.out.println(sb.insert(0,"bye "));
        System.out.println(sb.replace(0,3," "));
        sb.setCharAt(2,'a');
        System.out.println(sb);
    }
}
