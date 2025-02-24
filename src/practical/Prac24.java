package practical;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class Demo {
    static {
        System.out.println("Demo class loaded!");
    }

    private void print() {
        System.out.println("Print method");
        System.out.println(b);
    }
    int a = 10;
    private int b = 20;

    void printl(){
        System.out.println("Printl method");
        System.out.println(b);
    }
}

public class Prac24 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, NoSuchFieldException {
        Class<?> classy = Demo.class;

        System.out.println("Mehods of " + classy.getName() + " are ");
        Constructor[] c = classy.getConstructors();
        System.out.println(Arrays.stream(c).toArray());

        for(Field field : classy.getDeclaredFields())
        {
            System.out.println(field.getName());
        }

        //getDeclareMethods only give us class declared methods
        for(Method method : classy.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("-------------------------");
        // getMethod also give inherited methods
        for(Method method : classy.getMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("-------------------------");

        Demo demoInstance =  (Demo) classy.getDeclaredConstructor().newInstance();
        System.out.println("Demo instance created!");

        // invoke private method
        Method privatePrintMethod = classy.getDeclaredMethod("print");
        privatePrintMethod.setAccessible(true); // Bypass private access
        System.out.println("Invoking private print() method:");
        privatePrintMethod.invoke(demoInstance); // Calls print()

        Field privateFieldB = classy.getDeclaredField("b");
        privateFieldB.setAccessible(true); // Bypass private access
        System.out.println("Original value of private field 'b': " + privateFieldB.get(demoInstance));
        privateFieldB.set(demoInstance, 50); // Modify private field
        System.out.println("New value of private field 'b': " + privateFieldB.get(demoInstance));

        System.out.println("_-------------------");


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

//        Class<?> classz = Demo.class;
//        System.out.println("Class obtained, but not initialized!");
//        for(Method method : classz.getDeclaredMethods()) {
//            System.out.println(method.getName());
//        }
//
//        Class<?> clazz = Class.forName(Demo.class.getName());
//        System.out.println("Class obtained and initialized!");

    }
}


// className.class - loads the class but does not initialize - static block is not executed
// Class.forName("className") - loads and initialize the class immediately - static block is executed
// If Class.forName() is used with an invalid class name, it throws ClassNotFoundException.

// getMethod ignore the private method but getdeclareMethod give us private method

