package Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/*
    consumer interface --- accept method -- execute code without returning data
    binaryOperator interface --- apply method --- return a result of an operation or function
    Predicate ------ boolean test method ---- test if a condition is true or false
    Supplier ----- get() method ----- return an instance of something
 */
@FunctionalInterface
interface Operation<T>
{
    T operate(T value1, T value2);
}
public class ConsumerInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"
        ));

        for(String str : list){
            System.out.println(str);
        }

        System.out.println("____________");
        list.forEach(s->System.out.println(s));

        String prefix = "nato";
        // variable used in lamda expression should be final or effective final
        list.forEach((var myString)->{
            char firstChar = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + firstChar);
        });


        int result = calculator((a,b)-> a+b, 5,4);
        System.out.println(result);

    }

    public static <T> T calculator(BinaryOperator<T> operation, T value1, T value2){
        T result = operation.apply(value1, value2);
        System.out.println("result: " + result);
        return result;
    }
}
