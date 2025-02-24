
---

### 1. Features of Java?

- **Platform Independent:** Java follows "Write Once, Run Anywhere" (WORA). Code is compiled into bytecode, which runs on any system with a Java Virtual Machine (JVM), regardless of the underlying OS or hardware.
- **Object-Oriented:** Java is based on OOP principles like encapsulation, inheritance, polymorphism, and abstraction, making code modular and reusable.
- **Simple:** Java eliminates complex features like pointers and manual memory management (e.g., no `malloc` or `free`), making it easier to learn and use.
- **Robust:** Java prevents common programming errors through strong type checking, exception handling, and automatic garbage collection.
- **Secure:** The absence of pointers and the sandboxed execution environment (JVM) protect against unauthorized access and malicious code.
- **Multithreaded:** Java supports concurrent execution of multiple threads, enabling efficient multitasking.
- **High Performance:** The Just-In-Time (JIT) compiler in JVM optimizes bytecode into native machine code, improving execution speed.
- **Distributed:** Java supports networked applications through libraries like RMI (Remote Method Invocation) and JDBC.
- **Portable:** Uniform data sizes (e.g., `int` is always 32-bit) ensure consistent behavior across platforms.
- **Dynamic:** Java supports runtime modifications (e.g., reflection) and dynamic class loading.

---

### 2. Why Java Robust?
**Explanation:**  
Java is considered robust because it minimizes runtime errors and ensures reliable execution. Key reasons include:

- **Strong Type Checking:** Java enforces strict compile-time and runtime type checking, catching errors early.
- **Exception Handling:** With `try-catch` blocks, Java gracefully handles runtime exceptions like `NullPointerException`, preventing crashes.
- **Garbage Collection:** Automatic memory management frees developers from manual deallocation, avoiding memory leaks and dangling pointers.
- **No Pointers:** Unlike C/C++, Java abstracts memory access, eliminating pointer-related errors like buffer overflows.
- **Array Bounds Checking:** Java throws `ArrayIndexOutOfBoundsException` if you access an invalid index, preventing memory corruption.

---

### 3. Difference between JDK, JRE, JVM?
**Explanation:**  
These are core components of Java’s ecosystem:

- **JVM (Java Virtual Machine):**
    - The runtime engine that executes bytecode.
    - Provides platform independence by interpreting or JIT-compiling bytecode into machine code.
    - Handles memory management, garbage collection, and security.
    - Abstract layer; doesn’t include tools for development.

- **JRE (Java Runtime Environment):**
    - Includes JVM + runtime libraries (e.g., `java.lang`, `java.util`).
    - Required to *run* Java applications but not to develop them.
    - Example: End-users need JRE to execute `.class` files.

- **JDK (Java Development Kit):**
    - Superset of JRE + development tools (`javac` compiler, `jdb` debugger, `jar` for packaging).
    - Used by developers to write, compile, and debug Java code.
    - Example: `javac MyProgram.java` compiles code into bytecode.


---

### 4. Rules of Overriding?
**Explanation:**  
Method overriding occurs when a subclass provides a specific implementation of a method inherited from a superclass. Rules include:

- **Same Method Signature:** Name, return type (or covariant), and parameters must match exactly.
- **Access Modifier:** Cannot be more restrictive (e.g., `public` can’t become `protected`).
- **Return Type:** Must be the same or a subtype (covariant return type, introduced in Java 5).
- **Exceptions:** Cannot throw broader checked exceptions than the superclass method.
- **Final Methods:** Cannot override `final` methods.
- **Static Methods:** Cannot be overridden (they’re hidden, not overridden).
- **Inheritance Required:** Overriding only applies to inherited methods.

**Example:**
```java
class Parent {
    public void show() throws IOException { }
}
class Child extends Parent {
    public void show() throws FileNotFoundException { } // Valid: narrower exception
}
```

---

### 5. Covariant Return Type?
**Explanation:**  
Introduced in Java 5, covariant return types allow an overridden method to return a subtype of the original return type. This enhances flexibility in polymorphism.

- **Rule:** The return type in the subclass method must be a subtype of the superclass method’s return type.
- **Example:**
```java
class Animal { }
class Dog extends Animal { }
class Parent {
    Animal get() { return new Animal(); }
}
class Child extends Parent {
    Dog get() { return new Dog(); } // Covariant: Dog is a subtype of Animal
}
```

---

### 6. Why Can We Assign Long Value to Float Type?
**Explanation:**  
In Java, you can assign a `long` (64-bit integer) to a `float` (32-bit floating-point) due to **widening primitive conversion**, but it involves nuances:

- **`long`:** 64-bit signed integer, range: `-2^63` to `2^63-1`.
- **`float`:** 32-bit IEEE 754 floating-point, with a wider range but less precision (~7 decimal digits).
- **Conversion:** Java implicitly converts `long` to `float` because `float`’s range exceeds `long`’s, though precision may be lost for very large values.

**Example:**
```java
long l = 123456789L;
float f = l; // Implicit widening, but f may lose precision
```

---

### 7. Benefits of Byte Data Type?
**Explanation:**  
The `byte` data type is an 8-bit signed integer (-128 to 127). Its benefits include:

- **Memory Efficiency:** Uses only 1 byte vs. 4 bytes for `int`, ideal for large arrays or low-memory devices.
- **Data Transmission:** Matches byte-oriented protocols (e.g., network streams, file I/O).
- **Range Suitability:** Perfect for small values, like pixel intensities (0-255 with unsigned interpretation).

**Example:**
```java
byte[] buffer = new byte[1024]; // Efficient for file reading
```

---

### 8. Multiple Inheritance for Interface?
**Explanation:**  
Java doesn’t allow multiple inheritance for classes (to avoid the diamond problem), but interfaces can extend multiple interfaces:

- **Syntax:** `interface C extends A, B { }`
- **Reason:** Interfaces only declare methods, not implementations, so there’s no ambiguity.
- **Example:**
```java
interface A { void methodA(); }
interface B { void methodB(); }
interface C extends A, B { }
class MyClass implements C {
    public void methodA() { }
    public void methodB() { }
}
```

---

### 9. Extends vs Implements?
**Explanation:**

- **`extends`:**
    - Used for inheritance between classes or interfaces.
    - A class can extend one class; an interface can extend multiple interfaces.
    - Inherits implementation (for classes) or method signatures (for interfaces).
    - Example: `class B extends A { }`

- **`implements`:**
    - Used by a class to implement an interface.
    - A class can implement multiple interfaces.
    - Requires providing method implementations.
    - Example: `class B implements I { }`

---

### 10. Package Resolve Hierarchy?
**Explanation:**  
Packages in Java organize classes into namespaces, resolving naming conflicts and providing structure:

- **Hierarchy:** Defined by dot notation (e.g., `java.util`).
- **Resolution:** The compiler and JVM locate classes using the classpath and package names.
- **Import:** `import java.util.List;` resolves `List` to `java.util.List`, avoiding ambiguity with, say, `java.awt.List`.

---

### 11. Default Imported Package?
**Explanation:**  
The `java.lang` package is implicitly imported in every Java program. It includes essential classes like:

- `Object`, `String`, `Math`, `System`, etc.
- No need for `import java.lang.*;`—it’s automatic.
---

### 12. Ways to Create an Object?
**Explanation:**  
Objects in Java can be created in several ways:

1. **Using `new` Keyword:**
    - Most common: `MyClass obj = new MyClass();`
2. **Using `Class.forName()` (Reflection):**
    - `Object obj = Class.forName("MyClass").newInstance();`
3. **Using `clone()`:**
    - `MyClass obj2 = (MyClass) obj1.clone();` (requires `Cloneable`).
4. **Using Deserialization:**
    - Reading an object from a file: `ObjectInputStream.readObject()`.
5. **Using Factory Methods:**
    - `MyClass obj = MyClass.createInstance();`

---

### 13. Execution Flow After Exception Raised?
**Explanation:**  
When an exception occurs:

1. **Exception Thrown:** Execution stops at the error point, and an exception object is created.
2. **Stack Unwinding:** JVM searches the call stack for a matching `catch` block.
3. **Caught:** If found, control transfers to the `catch` block; otherwise, it propagates up until handled or the program terminates.
4. **Finally Block:** Executes regardless (e.g., for cleanup), unless `System.exit()` is called.
5. **Resumes:** Execution continues after the `try-catch` block if handled.

**Example:**
```java
try {
    int x = 1 / 0; // ArithmeticException
} catch (Exception e) {
    System.out.println("Caught"); // Executes
} finally {
    System.out.println("Finally"); // Always executes
}
```

---

### 14. Use of `throws` Keyword?
**Explanation:**  
The `throws` keyword in a method declaration specifies that the method can throw one or more exceptions, delegating handling to the caller.

- **Syntax:** `void method() throws IOException { }`
- **Purpose:** Alerts callers to handle or propagate the exception.
- **Example:**
```java
void readFile() throws FileNotFoundException {
    throw new FileNotFoundException();
}
```

---

### 15. Custom Exception? Recommended Class?
**Explanation:**  
A custom exception is a user-defined exception class for specific error scenarios:

- **Creation:** Extend `Exception` (checked) or `RuntimeException` (unchecked).
- **Recommended:**
    - `Exception` for checked exceptions (caller must handle).
    - `RuntimeException` for unchecked (optional handling, e.g., programming errors).
- **Example:**
```java
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}
```

---

### 16. Difference Between Exception vs Error?
**Explanation:**

- **Exception:**
    - Recoverable conditions (e.g., `IOException`, `NullPointerException`).
    - Handled with `try-catch`.
    - Subclass of `java.lang.Exception`.

- **Error:**
    - Irrecoverable issues (e.g., `OutOfMemoryError`, `StackOverflowError`).
    - Typically not caught—indicate system-level failures.
    - Subclass of `java.lang.Error`.

---

### 17. Return Type of Constructor?
**Explanation:**  
Constructors don’t have a return type—not even `void`:

- **Purpose:** Initialize an object, not return a value.
- **Syntax:** `public MyClass() { }` (no return keyword).
- **Implicit Return:** The newly created object is returned implicitly.

---

### 18. Can We Use `this` Keyword in Static Methods?
**Explanation:**  
No, `this` refers to the current instance, but static methods belong to the class, not an instance:

- **Reason:** Static methods don’t require an object, so `this` has no context.
- **Example:**
```java
class Test {
    static void show() {
        // this.x; // Error: "this" cannot be referenced from a static context
    }
}
```

---

### 19. Anonymous Inner Classes?
**Explanation:**  
An anonymous inner class is a nameless class defined inline, typically to implement an interface or extend a class for one-time use:

- **Syntax:**
```java
Runnable r = new Runnable() {
    public void run() { System.out.println("Running"); }
};
```
- **Use:** Common in event handling, threading, or passing behavior.

---

### 20. What is Stream? Difference Between Stream vs For Loop?
**Explanation:**

- **Stream:** Introduced in Java 8, a stream is a sequence of elements supporting functional-style operations (e.g., `map`, `filter`).
    - Lazy evaluation: Operations execute only when a terminal method (e.g., `collect`) is called.
    - Example: `list.stream().filter(x -> x > 0).collect(Collectors.toList());`

- **Stream vs For Loop:**
    - **Declarative vs Imperative:** Streams declare *what* to do; loops define *how* to do it.
    - **Readability:** Streams are more concise for complex operations.
    - **Parallelism:** Streams support `parallelStream()` for easy multithreading; loops require manual threading.
    - **Performance:** Streams may optimize internally (e.g., lazy evaluation).

---

### 21. Char in Java? Encoding?
**Explanation:**

- **`char`:** A 16-bit Unicode character (0 to 65,535), not 8-bit like in C.
- **Encoding:** Java uses UTF-16 internally for `char` and `String`.
    - Supports multilingual characters (e.g., `'A'`, `'π'`, `'ह'`).
    - Surrogate pairs handle characters beyond 16 bits (e.g., emojis).

---

### 22. What is Record Class?
**Explanation:**  
Introduced in Java 14 (finalized in 16), a `record` is a concise way to create immutable data carrier classes:

- **Syntax:** `record Point(int x, int y) { }`
- **Features:** Auto-generates constructor, getters (`x()`, not `getX()`), `equals()`, `hashCode()`, and `toString()`.
- **Use:** Replaces boilerplate for DTOs or value objects.

---

### 23. Access Modifiers vs Access Specifiers?
**Explanation:**

- **Access Specifiers:** Refers to keywords defining visibility (`public`, `protected`, `default`, `private`).
- **Access Modifiers:** Broader term including specifiers + others like `static`, `final`, `synchronized`.
- **Interview Nuance:** Often used interchangeably, but technically distinct.

---

### 24. String to Char Array?
**Explanation:**  
Convert a `String` to a `char[]` using:

- **`toCharArray()`:**
    - `char[] arr = "Hello".toCharArray();`
- **Manual:** Loop through `charAt(i)` (less common).

---

### 25. Types of Iterator? What is Iterator?
**Explanation:**

- **Iterator:** An interface (`java.util.Iterator`) for traversing collections (e.g., `List`, `Set`).
    - Methods: `hasNext()`, `next()`, `remove()`.
- **Types:**
    - **Iterator:** Basic, for any `Collection`.
    - **ListIterator:** For `List`, adds `previous()`, `add()`, `set()`.
    - **Enumeration:** Legacy (pre-Java 1.2), for `Vector`, `Hashtable`.

---

### 26. Access Protected Variables Outside Package?
**Explanation:**  
A `protected` member is accessible:

- **Within the same package:** Like `default` access.
- **Outside the package:** Only via inheritance (subclass can access it).

**Example:**
```java
package p1;
public class Parent {
    protected int x = 10;
}

package p2;
import p1.Parent;
class Child extends Parent {
    void show() {
        System.out.println(x); // Allowed via inheritance
    }
}
```

---

- Rules For using Private Methods in Interfaces

- Private interface method cannot be abstract and no private and abstract modifiers together.
- Private method can be used only inside interface and other static and non-static interface methods.
- Private non-static methods cannot be used inside private static methods.
- We should use private modifier to define these methods and no lesser accessibility than private modifier.