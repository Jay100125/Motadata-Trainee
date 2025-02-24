package practical;

class Vehicle2
{
    private String make;
    private String model;
    private int year;

    Vehicle2(){}

    Vehicle2(String make, String model, int year)
    {
//        this.make = make;
//        this.model = model;
        setMake(make);
        setModel(model);
        setYear(year);
    }

    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Getters and Setters (for encapsulation)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 0)
        {
            System.out.println("Invalid year");
            return;
        }
        this.year = year;
    }
}

class Car2 extends Vehicle2{
    private int numDoors;

    Car2(String make, String model, int year, int numDoors)
    {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numDoors);
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

}

class Motorcycle extends Vehicle2{
    private boolean hasSideCar;

    Motorcycle(String make, String model, int year, boolean hasSideCar)
    {
        super(make, model, year);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Side Car: " + hasSideCar);
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }


}
public class Prac2 {
    public static void main(String[] args) {

        Car2 car = new Car2("Toyota", "Camry", 2004,4);
        car.displayDetails();
        System.out.println();

        Car2 car22 = new Car2("Toyota", "Camry", -100,4);
        car22.displayDetails();
        System.out.println();

        Motorcycle m1 = new Motorcycle("Harley", "classic", 2005, false);
        m1.displayDetails();
        System.out.println();

        Vehicle2 car2 = new Car2("Toyota", "Camry", 2004, 4);
        car2.displayDetails();
        ((Car2)car2).getNumDoors(); //downcasting
        System.out.println();



        Vehicle2 m2 = new Motorcycle("Harley", "classic", 2005, true);
        m2.displayDetails();
        ((Motorcycle)m2).isHasSideCar(); //downcasting
    }
}
