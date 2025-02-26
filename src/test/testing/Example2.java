package test.testing;

import test.Example;

public class Example2 extends Example {
    public static void main(String[] args) {
        try{
            throw new StackOverflowError();
        }
        catch(StackOverflowError e){
            System.out.println("Stack OverflowError");
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("finally");
        }

        System.out.println("finally");
        System.out.println("finally");

        System.out.println("finally");

    }
}
