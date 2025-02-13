
# Exception
-object of throwable

- Here are couple of rules when it comes to exceptions & method overriding.

    - Rule 1: If the super class method does not declare an exception, then the overriding method in the subclass cannot declare a checked exception, but can declare an unchecked exception.

Rule 2:

- (a) If the super class method declares a checked exception, then the overriding method in the subclass can declare same exception or a subclass exception or no exception at all, but cannot declare a broader (generic) exception. Subclass can also declare any unchecked exception.

- (b) If the super class method declares an unchecked exception, then the overriding method can declare any unchecked exception or no exception at all, but cannot declare a checked exception. This rule is similar to Rule 1 in what a subclass can declare.


- SUPPRESTION AND MASKED EXCEPTION
  - 