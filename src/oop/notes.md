# constructor
- JVM assign default constructor if doesn't specified

User user = new Editor()
reference  = object
- compiler uses reference type to decide whether a method can be invoked
- Jvm uses object type to decide which method is invoked
### polmorphism
- allows less susesptible code
- flexible


example
- user
- staff
  - email   & editor
    -           chief
  
- editor is staff a staff need not be editor
- classcastexception   //runtime error

- objRef instanceof aclass
- object's tpe is what matters

```java
User u = new User();
Staff s = new Staff();
User us = new Staff();


u instanceOf User -> true
u instanceOf Staff -> false
s instanceOf Staff -> true
s instanceOf User -> true
us instanceOf User -> true
us instanceOf Staff -> true
 
```

- error :- undesirable program behavior
- static type checking = int i = 233.3, generics
- dynamic type checking = classcastexception, arrayindexoutofboudsexception
- 



If you declare:
```java
User user = new Staff();
```

then the reference type is User, and the actual object type is Staff.

#### Which Methods Are Accessible?
- The reference type (User) determines which methods can be called.
- The actual object type (Staff) determines which version of the method runs (due to method overriding).


### method overriding
- redifine behavior of superclass
 
#### method binding
- static method - by compiler based on reference type -->early bounded
- instance method - by jvm based on object type
- instance variable is early bounded


  

- resolved at compile time based on reference type
- resolved at runtime based on object type

-- static methods and overriding
- can't use super keyword
- can't hide instance method
- can't be overridevar by instance method


## object class

- java.lang
- act as polymorphic
- mother of all class
- toString method
- getclass
- clone

## construction
- super() must be first unless this() is used
- this() and super() but never both
- with overloaded constructor, last invoked will call super


## prevent inheritance
- string class is final as developer didn't want subclass of string to be created as they would compromise this immutable behavior

## final class -> not extendible, bt instantiable
## private constructor -> not extendible, not instantiable  -> saves heap space example utility classes




## abstraction
- abstract class
  - Abstract class should be extended
  - possible to have abstract class without any abstract method
- abstract subclass
  - need not override abstract methods
  - can override methods
  - can define abstract and concrete methods
- concrete subclass
  -must override unimplemeted abstract methods
- abstract class still have constructor
- 

## interfaces
- interface can be of reference type
- methods are public and abstract by default
- variables are public, static and final by default
- they don't have any state (means no instance variable)
- non-instantiable
- both class and interface have public and default
- can have static constant variable, abstract method, default methods, static methods
- 

### prefer interfaces over abstract classes
- use interfaces if you want to define mixins or if you want to define representative behavior of subclass

--- Hi Jay,

In User us = new Staff();, object type is right one. Left one is reference type. The lecture uses the following examples to explain the need for instanceof. For e.g., we first had the below code snippet. Staff does not have approveReview() and so compiler would give an error. But, we are applying a cast and assuring compiler that at run-time, 's' would be passed an Editor object that has approveReview(). But, at runtime if a staff object gets passed instead of editor, then we would get an error as the promise made at compile-time is now broken. So, we want to ensure that such problems do not arise at runtime and so we can make use of instanceof operator, which is also shown below in the second snippet. Now, if a staff object gets passed, the if-condition would fail as staff is not an instance of editor and so we avoid the runtime error. If we pass Editor object, then the condition would be true and approve review gets invoked. Similarly, if we pass ChiefEditor object, then the condition would still be true as ChiefEditor is also an instance of Editor as it extends Editor and so approveReview gets invoked. Note that when we say ChiefEditor object, we always mean object type itself. Hope that clears up your doubt. Let me know if you have any further questions. Thanks.

void approveReview(Staff s) {  
((Editor) s).approveReview();
}
void approveReview(Staff s) {  
if (s instanceof Editor) {  
((Editor) s).approveReview();  
}
} 
