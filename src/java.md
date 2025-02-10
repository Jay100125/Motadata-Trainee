# JAVA
- Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.
- It is intended to let application developers “write once, run anywhere” (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.
- Java was originally developed by **James Gosling** at Sun Microsystems


## Doubt
- The JVM is called virtual because it provides a machine interface that does not depend on the underlying operating system and machine hardware architecture. This independence from hardware and the operating system is a cornerstone of the write-once-run-anywhere value of Java programs.

## object and class
- In Java, objects are containers like data structures that have state and behavior. 
- The classes are the template that describes the state and behavior of its objects. 
- A class can be used to create multiple objects. which are similar in structure but can have different states.
- An ***instance initializer*** is simply a block of code inside the body of a class, but outside of any methods or constructors. An instance initializer does not have a name. Its code is simply placed inside an opening brace and a closing brace.
```
public class Main
{
    {
        //instance initializer block
    }   
}
```

- Code for all instance initializers is executed before any constructor.
- An instance initializer is executed once per object whereas a static initializer is executed only once for a class when the class definition is loaded into JVM.
- null is a literal of the null type. We cannot assign null to a primitive type variable, and that’s why the Java compiler does not allow us to compare a primitive value to a null value.



##### doubt
protected :- it is accessble to any subclass wheater it is in same package or not.
however the variable is not accessbile via reference to the subclass object if the acceessing class is not in the same package as super class