package Exception;

import basic.Test;
import org.w3c.dom.ls.LSOutput;

class program{

    public void somethingDo(int a , long b)
    {
        System.out.println("this is something inside int program");
        System.out.println(a+b);
    }
    public void somethingDo(long a , int b)
    {
        System.out.println("this is something inside long program");
        System.out.println(a+b);
    }
    public void execute1()
    {
        try{
//            int a = 10/0;
            execute2();
            System.out.println("something inside execute1");
        } catch (Exception e) {
            System.out.println("something inside catch execute1");
        }{
            System.out.println("something inside final execute1");
        }

    }
    private void execute2(){
        try{
            execute3();
            System.out.println("something inside execute2");
        }finally{
            System.out.println("something inside final execute2");
        }
    }
    private void execute3(){
        try {
            execute4();
            System.out.println("something inside execute3");
        }
        catch (Exception e) {
            System.out.println("something inside catch execute3");
        }
//        finally {
//            System.out.println("something inside final execute3");
//        }
    }
    private void execute4(){
        try{
            int a = 10/0;
            System.out.println("something inside execute4");
        }
        finally {
            System.out.println("something inside final execute4");
        }
    }

}
public class Demo extends Test{
    private final static int i = 7;
    static int j = 0;
    int i1 = 4;
     int i2;
    static String str;
    private void demo()
    {
        System.out.println(str);
        System.out.println(i2);

    }
    private Demo(String str, int i2)
    {
        System.out.println(this.str);
        this.str = str;
        this.i2 = i2;
    }
    void show(){
        System.out.println(jay);
    }
    public static void main(String[] args) {
            program program = new program();
//            program program1 = new program();
//            program = program1;
//            program = null;
//           program.execute1();
//        Demo d = new Demo();
//        d.j = 100;
//        System.out.println(i);
//        System.out.println(j);

//        program.somethingDo(10,10);  ambigous if two method have int and long and long and int and you pass int int
            Demo d;
            d = null;
//        System.out.println(d.str);
//        System.out.println(d.i2);

        d = new Demo("hello",22);
        System.out.println(d.str);
        System.out.println(d.i2);

        Test test = new Test();
//        System.out.println(test.jay);
        System.out.println(d.jay);
        new Demo("helo",212).show();
//        System.out.println(d.i1);
    }
}
