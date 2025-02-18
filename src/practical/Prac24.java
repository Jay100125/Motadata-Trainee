package practical;

import java.lang.reflect.Method;

class Demo {
    static {
        System.out.println("Demo class loaded!");
    }

    private void print() {
        System.out.println("Print method");
    }
}

public class Prac24 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classy = Prac8.class;

        System.out.println("Mehods of " + classy.getName() + " are ");
        for(Method method : classy.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

//        Integer i = null;
//        int j = null;
//        System.out.println(i);
//        System.out.println(j);

//        try {
//            // Load class dynamically
//            Class<?> clazz = Class.forName("java.io.BufferedReader");
//
//            // Print class name
//            System.out.println("Class Name: " + clazz.getName());
//
//            // Print fields
//            System.out.println("Fields:");
//            for (var field : clazz.getDeclaredFields()) {
//                System.out.println(field.getName() + " - " + field.getType());
//            }
//
//            // Print methods
//            System.out.println("Methods:");
//            for (var method : clazz.getDeclaredMethods()) {
//                System.out.println(method.getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Class<?> classz = Demo.class;
        System.out.println("Class obtained, but not initialized!");
        for(Method method : classz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        Class<?> clazz = Class.forName("Demo");
        System.out.println("Class obtained and initialized!");

    }
}


// className.class - loads the class but does not initialize - static block is not executed
// Class.forName("className") - loads and initialize the class immediately - static block is executed

