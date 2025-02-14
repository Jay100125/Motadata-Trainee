package oop;
//
//class A
//{
//    Integer x = 0;
//
//    public Number getx()
//    {
//        return x;
//    }
//}
//
//class B extends A{
//    int x = 1;
//    public Integer getx()
//    {
//        return 1;
//    }
//}
public class Testing2 {
    static String str2 = "KEEP IT "; //Line n1
    public static void main(String[] args) {
//        int[] array = {1,2,3,4};
//        String s = "Hello World!";
//        String s2 = new String("Hello World!");
//        int s1 = 0;
//        if(s2 instanceof Object)
//            System.out.println("yes....");
//        if (array instanceof Object)
//            System.out.println("Yes!");
//
//        switch (s1)
//        {
//            case 0:
//                System.out.println("Hello World!");
//                break;
//            default:
//                System.out.println("Hello World!!!!!");
//        }
//        int[] arr = new int[0];
//        System.out.println(arr[0]);

//        System.out.println(args[0]);
//        boolean flag1 = true;
//        boolean flag2 = false;
//        boolean flag3 = true;
//        boolean flag4 = false;
//
//        System.out.println(!flag1 == flag2 != flag3 == !flag4); //Line n1
//        System.out.println(flag1 = flag2 != flag3 == !flag4); //Line n2
//
//        byte b = 100;
//        System.out.println(b);

         String s2 = "abc";
        final String s3 = "def";
        String s4 = new String(s2 + s3);
        try{
            System.out.println("lll");
            throw new RuntimeException("sonme");
//            System.out.println("lll");
        }
        catch (Exception e){
            System.out.println(e);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        System.out.println(sb.toString());
//        System.out.println(new RuntimeException()); //Line n1
//        System.out.println(new RuntimeException("HELLO")); //Line n2
//        System.out.println(new RuntimeException(new RuntimeException("HELLO"))); //Line n3
        int elements = 0;
        Object [] arr = {"A", "E", 2, new Object(), "O", "U"}; //Line n1
        for(Object obj : arr) { //Line n2
            if(obj instanceof String) {
                continue;
            } else {
                break;
            }
//            elements++; //Line n3
        }
        System.out.println(elements); //Line n4
        String str = str2 +  "SIMPLE"; //Line n2
        sb.append(str);
        System.out.println(str);

    }
}
