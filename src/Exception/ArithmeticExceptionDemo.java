package Exception;

import java.io.IOException;

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
//        try {
//            int num1 =30 , num2= 0;
//            Class.forName("ArithmeticExceptionDemo");
//            int dividend = num1/num2;
//
//            System.out.println("Result= "+ dividend);
//        }
//        catch (ArithmeticException e){
//
//            System.out.println("ArithmeticException");
//        }
//        catch (ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
        try{
            System.out.println("something");
            int a = 10/0;
        }catch(Exception e)
        {
            System.out.println("sufdsjn");
        }
        finally{
            throw new ArithmeticException();
        }
    }
}
