package Com.Amrita.Jpl.cys21082.Exe;
interface Shape {
    void calculateArea();
    void display();
}


class Circle implements Shape {

    public void calculateArea() {
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }

    public void display() {
        System.out.println("[Circle] Displaying Circle");
    }

}


class Rectangle implements Shape {

    public void calculateArea() {
        System.out.println("[Rectangle] Area of Rectangle is L*B");
    }

    public void display() {
        System.out.println("[Rectangle] Displaying Rectangle");
    }

}

public class Inheritance {

    public static void main(String[] args) {

        System.out.println("[Main] Creating Objects Circle and Rectangle");

        Shape myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.calculateArea();

        Shape myRect = new Rectangle(); // Create a Rectangle object
        myRect.display();
        myRect.calculateArea();
    }

}

