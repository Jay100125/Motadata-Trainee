
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


    }
}
