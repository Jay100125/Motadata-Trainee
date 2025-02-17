////package test;
////
////import java.util.Random;
////
////
////public class Demo {
////    public static void main(String []args)
////    {
//////        try {
//////            int array[] = new int[10];
//////
//////            array[10] = 30 / 0;
//////
//////        }
//////        catch (ArrayIndexOutOfBoundsException e) {
//////
//////            System.out.println(e.getMessage());
//////
//////        }catch (ArithmeticException e) {
//////
//////            System.out.println(e.getMessage());
//////
//////        }
////
////        try {
////            int a[]=new int[10];
////            System.out.println(a[12]);
////            try {
////                System.out.println("Division");
////                int res = 100/ 0;
////            }
////            catch (ArithmeticException ex2) {
////                System.out.println("Sorry! Division by zero isn't feasible!");
////            }
////        }
////        catch (ArrayIndexOutOfBoundsException ex1) {
////            System.out.println("ArrayIndexOutOfBoundsException");
////        }
////    }
////}
//
//
////package test.testing.testing;
//
//package test;
//import test.testing.testing;
//
//public class Demo extends testing{
//    public int i;
//    private int j;
//    protected int k;
//    int l;
//    public static void main(String[] args) {
//
//        testing d = new testing();
//        System.out.println(d.a);
//        System.out.println(d.b);
//        System.out.println(d.c);
//        System.out.println(d.d);
//        Demo object = new Demo();
//
//        object.stringConcatenate("Jay",null);
//
//        String sLiteral1 = "Jay";
//
//        String sLiteral2 = "Jay";
//
//        object.stringConcat(sLiteral1,sLiteral2);
//
//        String sObj1= new String("Jay");
//
//        String sObj2 = new String("Jay");
//
//        object.comparison(sObj1,sObj2);
//        object.comparison(sLiteral1,sLiteral2);
//    }
//    int stringLength(String string){
//
//        if (string == null){
//
//            return 0;
//        }
//
//        else {
//
//            int length = string.length();
//
//            return length;
//
//        }
//    }
//
//    String stringConcatenate(String string1, String string2){
//
//        // this method will also concatenate null value as "null" string ex: "Jay"+ null string = Jaynull
//        String concatenated = string1+string2;
//        System.out.println(concatenated);
//        return concatenated;
//
//    }
//    void stringConcat(String string1, String string2){
//
//        // this uses concat method for concatenation throws null pointer exception
//        try {
//
//            if(string1 == null || string2 == null){
//
//                System.out.println("null strings can't be concatenated using concat() method");
//            }
//            else {
//
//                // here strings are concatenated and saved in new string
//                String concatenated = string1.concat(string2);
//
//                // this returns old value of string1 as the new string is created while concatenating, but it's not assigned to string1
//                string1.concat(string2);
//
//                System.out.println("concat string1"+ string1);
//
//                System.out.println("concatenated "+concatenated);
//            }
//
//        }catch (NullPointerException nullPointerException){
//
//            System.out.println(nullPointerException);
//        }
//    }
//
//    void comparison(String string1, String string2){
//
//        //== checks if the reference to string objects are equal or not.
//        // Here, string1 and string2 are two different references
//        boolean result1 = (string1 == string2);
//
//        System.out.println("Using == operator: " + result1);
//
//        // using equals() method
//        //equals() checks if the content of the string object are equal
//        boolean result2 = string1.equals(string2);
//
//        System.out.println("Using equals(): " + result2);
//
//    }
//
//
//}