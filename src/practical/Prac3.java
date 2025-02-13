package practical;

import java.util.InputMismatchException;
import java.util.Scanner;

// program for number division only for integer
public class Prac3 {
    public static void main(String[] args) {
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

    }
}
