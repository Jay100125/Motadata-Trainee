package test.testing;


import java.io.IOException;

 class parent
{
    int x;
    parent()
    {

    }
    private parent(int x)
    {
        this.x = x;
    }
     void function1(){}
}
class child extends parent
{

}
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



//        try{
//            System.out.println(1/0);
//        } catch (Exception e) {
//           // System.out.println(e.getMessage());
//        }
//        finally {
//            System.out.println("finally");
//        }
//        String one = new String("one");
//        String two = new String("one");
//        String three = one.intern();
//        String four = two.intern();
//        System.out.println(three == four);

//        System.out.println("dfsjdnfklas");

//        byte b = 127;
//        b = b -1;
//        int a = b - 1;
//        int c = b+1;
//        b += 1;
//        b++;
//        b = (byte) b+ 1;
//        b--;
//        b -= 1;

//        if(false)
//        {
//            System.out.println("false");
//        }
        String one = "1" + "2";
        String two = "12";

        System.out.println(one == two);
    }
}


/// setLength(0);
// scanner weakness
