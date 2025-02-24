package collection.and.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        List<Employee> emps = new Vector<>();
        emps.add(new Employee(1, "A"));
        emps.add(new Employee(2, "B"));
        emps.add(new Employee(3, "C"));
        emps.add(new Employee(4, "D"));
    }
}
