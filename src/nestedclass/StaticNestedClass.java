package nestedclass;
import java.util.Comparator;
/*
    enclosed in the structure of another class
    requires the outer class name as part of the qualifying name
    beign able to access private attributes on the outer class
    enclosing class can also accesss any attributes on the static nested class, including private attributes

 */
class Employee{
    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee(){

    }
    public Employee(int employeeId, String name, int yearStarted){
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }

}

//class EmployeeComparator <T extends Employee> implements Comparable<Employee>{
//
//    @Override
//    public int compareTo(Employee o1, Employee o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//
////    @Override
////    public int compareTo(Employee employee) {
////        return 0;
////    }
//}

public class StaticNestedClass {
}
