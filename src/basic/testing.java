package basic;

class User{
    User(int id){}
}
class Staff extends User{
    Staff(int id){
        super(id);
    }
}
public class testing {
    public static void main(String[] args) {
        int a = (int) 5.6;
        System.out.println(a);
        int b = (int)Float.parseFloat("5.6");
        System.out.println(b);


        int d = 97;
        char c = (char)d;
        long l = (long)1.9;
        System.out.println(c);
        System.out.println(d);
        System.out.println(l);

        int i = 1000;
        String s = Integer.toString(i);
        System.out.println(s.intern().charAt(0));
        System.out.println(s.charAt(0));

        char[] ch = {'a','b','c'};
        System.out.println(ch[0]);
        String s2 = new String(ch);
        String s1 = "123456789";
        System.out.println(s1.charAt(0));

    }
}
