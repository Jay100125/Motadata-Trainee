package test.testing;

import test.Example;

public class Example2 extends Example {
    public static void main(String[] args) {
        Example2 e = new Example2();
        Example e2 = new Example();

        System.out.println(Example2.x);
        System.out.println(Example.x);
    }
}
