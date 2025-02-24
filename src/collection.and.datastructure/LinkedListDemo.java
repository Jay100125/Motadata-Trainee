package collection.and.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {

        Employee james = new Employee(1,"james");
        Employee john = new Employee(2,"john");
        Employee mary = new Employee(3,"mary");

        EmployeLinkedList list = new EmployeLinkedList();

        list.addToFront(james);
        list.addToFront(john);
        list.addToFront(mary);

        list.printList();


        LinkedList<Employee> employees = new LinkedList<>();
        employees.addFirst(james);
        employees.addFirst(john);
        employees.addFirst(mary);

        Iterator iter = employees.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

//        employees.removeFirst();

        System.out.println(employees);
        employees.remove(john);
        System.out.println(employees);


    }
}
