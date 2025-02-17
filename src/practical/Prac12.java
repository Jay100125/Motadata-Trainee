package practical;

class MathOperations<T extends Number>
{
    private T num1, num2;

    public MathOperations(T num1, T num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add(){
        return  num1.doubleValue() + num2.doubleValue();
    }

    public double sub(){
        return num1.doubleValue() - num2.doubleValue();
    }

    public double mul(){
        return num1.doubleValue() * num2.doubleValue();
    }

}
public class Prac12 {
    public static void main(String[] args) {
         MathOperations<Integer> num1 = new MathOperations<Integer>(10, 5);
         MathOperations<Double> num2 = new MathOperations<Double>(0.5, 0.5);

         System.out.println("Integer Addition : " + num1.add());
         System.out.println("Integer Subtraction : " + num1.sub());
         System.out.println("Integer Multiplication : " + num1.mul());

        System.out.println("Double Addition : " + num2.add());
        System.out.println("Double Subtraction : " + num2.sub());
        System.out.println("Double Multiplication : " + num2.mul());
    }
}
