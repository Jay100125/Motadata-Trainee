package practical;

import java.lang.reflect.Method;

public class Prac24 {
    public static void main(String[] args) {
        Class<?> classy = Prac8.class;

        System.out.println("Mehods of " + classy.getName() + " are ");
        for(Method method : classy.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

//        Integer i = null;
//        int j = null;
//        System.out.println(i);
//        System.out.println(j);

    }
}

