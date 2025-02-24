import java.io.Console;
import java.math.BigDecimal;

class parent{
    parent()
    {
        super();
    }
    void Print(int a){
        System.out.println(a);
        System.out.println("PARENT");
    }
}

class child extends parent{
    void Print(int a){
        System.out.println(a);
        System.out.println("CHILD");
    }
}
abstract class AAA{

}
public class hello {

    static {
        x = 10;
    }
    static int x = 20;
    static void printSomething(Integer n) {
        System.out.println(n);
    }
    public static void main(String[] args) {
        int some = 3;
//        printSomething(some);

        parent p = new parent();
        child c = new child();
        p.Print(some);
        c.Print(some);

        parent pp = new child();
        pp.Print(some);

        System.out.println(x);

        String s1 = new String("Java");
        String s2 = new String("Java");
        String s3 = s1;

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        System.out.println(s1.equals(new String("Java")));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        String s4 = new String("Java");

        double discount_value = 1000*(1-0.9);
        System.out.println(discount_value); //999.999999997 we want 100

        System.out.printf("value is %.3f\n", discount_value);


        // console is thread safe and also protect password
//        Console cc = System.console();
//        System.out.println("Enter the Name");
//        String s = cc.readLine();
//        System.out.println("Name is "+s);

        StringBuilder str3 = new StringBuilder();
        String str4 = str3.toString();
        String str5 = str3.toString();

        System.out.println(str4.equals(str5));

    }
}
