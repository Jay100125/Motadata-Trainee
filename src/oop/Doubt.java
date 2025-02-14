package oop;

class B {
    int a = 10;
    public void print() {
        System.out.println("inside B superclass");
    }
}

class C extends B {
    int a = 20;
    int c=20;
    public void print() {
        System.out.println("inside C subclass");
    }
}
//class Program1{
//    try{
//        int a  = 10/0;
//        System.out.println("inside Program1 superclass");
//    }
//    catch(Exception e)
//    {
//        System.out.println(e);
//    }
//}
public class Doubt {
//    public static void main(String[] args) {
//        B b = new C();
//        b.print(); // prints: inside C subclass
//        System.out.println(b.a); // prints superclass variable value 10
    public static void main(String[] args) {
        System.out.println(args.length);    //question 1
        String a = "1";
        a.concat("2");
        System.out.println(a);
        System.out.println(a.concat("3"));

        //stringbuilder

        String s1 = new String("1");
        String s2 = new String("1");
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);




    }
}
