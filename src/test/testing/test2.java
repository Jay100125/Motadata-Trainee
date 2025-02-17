package test.testing;

import java.io.IOException;

//class parent
//{
//    void func(){}
//}
//class child extends parent
//{
//    void func() throws IOException {}
//}
public class test2 {
    public static int age = 23;

     public static test2 test = new test2();

     public static String name = "test";

     void execute(int a, int b){
         System.out.println("int");
     }

     void execute(long a, long b){
         System.out.println("long");
     }
    public test2(){
        System.out.println(age);
        System.out.println(name);
    }
    public static void main(String[] args) {
//        System.out.println(age);
//        System.out.println(name);

        test2 test = new test2();
        test.execute(1, 2);
    }
}


/// setLength(0);
// scanner weakness
