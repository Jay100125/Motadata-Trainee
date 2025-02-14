package Exception;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Testing extends Exception{
//    public static void main(String[] args) {
//        try
//        {
//            System.out.println("Hello World");
//            throw new FileNotFoundException();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//
//    }
//}

//import java.io.IOException;
//
//public class Testing {
//
//    public static void main(String[] args) {
//
//        try {
//
//            foo();
//
//        } catch (IOException e) {}
//
//        System.out.println("end of main ...");
//
//    }
//
//    private static void foo() throws IOException {
//
//        System.out.println("In foo ...");
//
//        try {
//
//            bar();
//
//            System.out.println("After invoking bar ...");
//
//        } finally {
//
//            System.out.println("finally: foo");
//
//        }
//
//        System.out.println("end of foo ...");
//
//    }
//
//    private static void bar() throws IOException {
//
//        System.out.println("In bar ...");
//
//        try {
//
//            throw new IOException();
//
//        } finally {
//
//            System.out.println("finally: bar");
//
//        }
//
//    }
//
//}
public class Testing {
    public static void main(String[] args) {
        Testing t = new Testing();
        t.method1();
    }

    private void method1() {
        method2();
    }

    private void method2() {
        System.out.println("Statement-1");
        try {
            System.out.println(10/0);
        } catch (ArithmeticException ex) {
            System.out.println("Statement-2");
        //    ex.printStackTrace();
   System.out.println(ex);
        }
        System.out.println("Statement-3");
    }
}