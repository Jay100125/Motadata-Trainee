package nestedclass;

public class InnerClassDemo {

   private class InnerClass {
//        InnerClass() {
//            System.out.println("Inner Class constructor");
//        }

    }

    class InnerClass2 extends InnerClass {
//        InnerClass2() {
//            super();
//            System.out.println("InnerClass2 constructor");
//        }
    }
    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
        InnerClass2 innerClass2 = demo.new InnerClass2();
    }
}
