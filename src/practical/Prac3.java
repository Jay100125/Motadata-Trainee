package practical;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

// program for number division only for integer
public class Prac3 {
    public static void main(String[] args) throws InterruptedException {
        // scanner object is defined here because we can close it in finally
        // we can also use try with resources like try( Scanner sc = new Scanner(System.in)) --> here we don't require finally block

        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the dividend : ");
            int dividend = sc.nextInt();

            System.out.print("Enter the divisor : ");
            int divisor = sc.nextInt();

            int result = dividend / divisor;
            System.out.println("The result is : " + result);

        }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter integer values only");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Cannot divide by zero");
        }

        finally {
            sc.close();
        }

//        ArrayList<Prac3> p3 = new ArrayList();


//        ExecutorService t = Executors.newCachedThreadPool();
//        for(int i=0; i<1000; i++) {
//            t.submit(() -> {
//                Prac3 prac3 = new Prac3();
//                p3.add(prac3);
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(600000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//
//        Thread.sleep(70000000);

    }
}
