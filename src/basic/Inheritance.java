package basic;

class temp{
    int a = 10;
}
public class Inheritance {
    public static void main(String[] args) {
        temp t = new temp();
        System.out.println(t.a);
        Inheritance i = new Inheritance();
        i.print();
    }
    public void print(){
        System.out.println("Hello");
    }
}
