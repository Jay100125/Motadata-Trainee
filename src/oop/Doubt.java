package oop;

class B {
    int a = 10;
    public void print() {
        System.out.println("inside B superclass");
    }
}

class C extends B {
    int a = 20;
    int c=20;
    public void print() {
        System.out.println("inside C subclass");
    }
}

public class Doubt {
    public static void main(String[] args) {
        B b = new C();
        b.print(); // prints: inside C subclass
        System.out.println(b.a); // prints superclass variable value 10

    }
}
