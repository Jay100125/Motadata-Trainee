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

    public int print(){
         try{
             System.out.println("print");
             return 1;
         }
         catch(Exception e){
             System.out.println(e);
         }
         finally{
             return 3;
         }
    }


    public static void main(String[] args) {
//        System.out.println(age);
//        System.out.println(name);
//        test2 test = new test2();
//        test.execute(1, 2);

//        byte b = 127;
////        b = b-1;
////        b = (byte) b + 1;
//
//        b++;
//
//        System.out.println(b);
//
//        b +=1;
//        System.out.println(b);
//
//        int i = b + 1;
//        System.out.println(b);
//
//        System.out.println(new test2().print());
//



        try{
            return;
        } catch (Exception e) {
            return;
        }
        finally {
            return;
        }

//        System.out.println("dfsjdnfklas");

    }
}


/// setLength(0);
// scanner weakness
