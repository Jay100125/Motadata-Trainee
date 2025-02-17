package practical;

interface Calculator {
    double operation(double a, double b);
}
public class Prac23 {
    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;
        Calculator div = (a, b) -> a / b;

        double x = 10, y = 5;
        System.out.println("Addition of two numbers is " + add.operation(x, y));
        System.out.println("Subtraction of two numbers is " + sub.operation(x, y));
        System.out.println("Multiplication of two numbers is " + mul.operation(x, y));
        System.out.println("Division of two numbers is " + div.operation(x, y));
    }
}
