package Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
    a functional interface is an interface that has one and only one abstract method
    A functional interface is the target type for a lamda expression
 */
public class LamdaDemo {

    // record in inside class are static like inner class or enum
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new LamdaDemo.Person("Lucy", "Van pelt"),
                new Person("John", "Doe"),
                new Person("Sally", "Brown"),
                new Person("Peppermint", "Patty"),
                new Person("Michael", "Smith")));



        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);


    }
}
