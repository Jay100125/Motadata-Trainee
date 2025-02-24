package practical;

class Box<T>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class Prac6 {
    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>();
        box.setValue(22);
        System.out.println(box.getValue());

        Box<Double> box2 = new Box<Double>();
        box2.setValue(2.0);
        System.out.println(box2.getValue());

        Box<String> box3 = new Box<String>();
        box3.setValue("Jay");
        System.out.println(box3.getValue());



    }
}
