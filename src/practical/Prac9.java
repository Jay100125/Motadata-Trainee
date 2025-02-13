package practical;

abstract class Vehicle {
    public abstract void start();
    public abstract void stop();

}
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void stop() {
        System.out.println("Car stop");
    }

    public void drive(){
        System.out.println("Car drive");
    }
}

class Bike extends Vehicle {
    @Override
    public void start(){
        System.out.println("Bike start");
    }

    @Override
    public void stop(){
        System.out.println("Bike stop");
    }
}
public class Prac9 {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        myCar.start();
        myCar.stop();

        myBike.start();
        myBike.stop();




        if(myBike instanceof Vehicle){

            System.out.println("Bike Hornnnnnr");
        }
        if(myCar instanceof Car){
            //downcasting
            ((Car)myCar).drive();
            System.out.println("Car Hornnnnnr");
        }
    }
}
