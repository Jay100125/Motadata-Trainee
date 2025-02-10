package basic;

public class Test {
    static int x = 11;

    // Instance Variable
    private int y = 33;

    // Parameter Scope (x)
    public void testFunc(int x) {
        // Method Scope (t)
        Test t = new Test();
        this.x = 22;
        y = 44;

        // Printing variables with different scopes
        System.out.println("Test.x: " + Test.x);
        System.out.println("t.x: " + t.x);
        System.out.println("t.y: " + t.y);
        System.out.println("y: " + y);
    }

    public static void main(String[] args)
    {
        // String class is loaded by bootstrap loader, and
        // bootstrap loader is not Java object, hence null
        System.out.println(String.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
        // Test class is loaded by Application loader
        System.out.println(Test.class.getClassLoader());
        System.out.println(Test.class.getClassLoader().getParent());

        Test t = new Test();
        t.testFunc(5);
        System.out.println(t.y);
    }
}