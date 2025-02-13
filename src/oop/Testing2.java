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

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        String s = "Hello World!";
        String s2 = new String("Hello World!");
        int s1 = 0;
        if(s2 instanceof Object)
            System.out.println("yes....");
        if (array instanceof Object)
            System.out.println("Yes!");

        switch (s1)
        {
            case 0:
                System.out.println("Hello World!");
                break;
            default:
                System.out.println("Hello World!!!!!");
        }
    }
}
