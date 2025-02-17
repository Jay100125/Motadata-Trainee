package Exception;
//
public class ExceptionPropogation {

    public static void main(String[] args){

        ExceptionPropogation testObject = new ExceptionPropogation();

        int num = Integer.parseInt("100");
        System.out.println(num);
//        testObject.handle();

    }
    void divide()
    {
        int data = 50 / 0;
        System.out.println("divide");
    }

    void propagate()
    {
        try{
            divide();
            System.out.println("propagate");
        }
        catch(ArithmeticException e)
        {
            System.out.println("arithmeticException");
        }
    }

    void handle()
    {
        try {
            propagate();

            System.out.println("handle");
        }
        catch (Exception e) {

            System.out.println(e +" Exception handled");
        }
        finally {
            System.out.println("finally handled");
        }
    }


}

//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//class SuperClass {
//    void method() {
//
//        System.out.println("Super Class");
//    }
//}
//class SubClass extends SuperClass{
//    // if we declare checked exception in subclass method here we get a compilation error
//
//    void method() throws ArithmeticException {
//        System.out.println("Sub class");
//    }
//}
//public class ExceptionPropogation {
//    public static void main(String[] args){
//
//        SuperClass testObject = new SubClass();
//        testObject.method();
//
//
//    }
//
//}