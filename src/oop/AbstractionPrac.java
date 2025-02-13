package oop;

abstract class ab {
    public abstract int foo();
    public abstract int bar();
}
class baz extends ab {
    public int foo(){
        System.out.println("foo: " + 10);
        return 10;
    }
    public int bar(){
        return 20;
    }
}
public class AbstractionPrac {
    ab a = new baz();
}
