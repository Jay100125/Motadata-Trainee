package practical;

import java.io.*;

class Student implements Serializable {

    private String name;
    private int age;
    private int rollNo;

    public Student(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }


}
public class Prac15 {
    public static void main(String[] args) {
        // What not serializable
//        static fields
//          transient fields
        // inner class that not implement serializable
        // system level resources

        Student s1 = new Student("Jay", 22, 1);
        Student s2 = new Student("Jeet", 22, 2);
        // Serializable
        try(FileOutputStream fos = new FileOutputStream("prac15.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(s1);
            System.out.println("Object written to file");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Deserializable

        try(FileInputStream fis = new FileInputStream("prac15.ser");
        ObjectInputStream in = new ObjectInputStream(fis))
        {
            Student desStudent = (Student) in.readObject();
            System.out.println(desStudent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//The Serialization Process:
//
//ObjectOutputStream wraps your file output stream
//writeObject() method converts your object to bytes
//The process is recursive - if your object contains references to other objects, they're serialized too
//
//
//The Deserialization Process:
//
//ObjectInputStream wraps your file input stream
//readObject() reconstructs your object
//You need to cast the result to your expected type
