package Exception;

class Base extends Exception{}
class Derived extends Base{}
public class DerivedException {
    public static void main(String[] args){

        try {
            throw new Derived();
        }
        // Derived classes exceptions should be specified before base class
        // otherwise we will get compilation error
        // Generic exceptions should be put below of  specific exceptions in catch block
        catch (Derived d){

            System.out.println("caught in derived class");
        }
        catch (Base b){

            System.out.println("caught in base class Exception");
        }
    }
}