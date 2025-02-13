package practical;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age");
        }
        else {
            System.out.println("Age is valid");
        }
    }
}
public class Prac25 {
    public static void main(String[] args) {
        try{
           AgeValidator.validateAge(20);
           AgeValidator.validateAge(30);
           AgeValidator.validateAge(10);
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
