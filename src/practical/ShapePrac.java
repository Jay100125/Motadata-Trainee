package practical;

abstract class Shape {
    abstract double calculateArea();

}
// cicle subclass
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Overridden method to calculate area
    @Override
    double calculateArea() {
        double area = Math.PI * radius * radius;
        return Math.round(area * 100.0) / 100.0;
    }
}

// Reactangle
class Rectangle extends Shape {
    private double length, breadth;
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double calculateArea() {
        return length * breadth;
    }

}
// triangle subclass
class Triangle extends Shape {
    private double base, height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Overridden method to calculate area
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class ShapePrac {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);

        System.out.println("Area of circle : " + circle.calculateArea() );
        System.out.println("Area of rectangle : " + rectangle.calculateArea() );
        System.out.println("Area of triangle : " + triangle.calculateArea() );

    }
}
