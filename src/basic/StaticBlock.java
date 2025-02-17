package basic;

public class StaticBlock {
    static {
        System.out.println("static block executed");

        print();
    }
    {
        System.out.println("Instance initializer block 1");
        display();
    }

    {
        System.out.println("Instance initializer block 2");
    }

    public StaticBlock() {
        System.out.println("Class constructor");
    }

    public static void main(String[] args) {
        StaticBlock testObject = new StaticBlock();
        System.out.println("Main Method");
        testObject.display();
    }
    static void print(){
        System.out.println("print method called");
    }
    void display(){
        System.out.println("display method called");
    }
    {
        System.out.println("Instance initializer block 3");
    }
}