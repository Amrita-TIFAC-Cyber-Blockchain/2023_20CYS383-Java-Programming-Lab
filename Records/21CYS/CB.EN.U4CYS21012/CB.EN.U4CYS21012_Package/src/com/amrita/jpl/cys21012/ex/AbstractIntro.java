package com.amrita.jpl.cys21012.ex;

/*
 * Author - Ashwin Anand
 * Date: 08-May-2023
 *
 */
abstract class AShape {

    // Abstract Method without Definition
    public abstract void area();

    // Method
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

// Subclass (inherited from Shape)
class ACircle extends AShape {

    public void area() {
        // area() of Circle Class - Definition
        System.out.println("[Abstract Method in Circle] Area of Circle is PI*R*R");
    }

}

// Subclass (inherited from Shape)
class ARectangle extends AShape {

    public void area() {
        // area() of Rectangle Class - Definition
        System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L*B");
    }

}
public class AbstractIntro {
    public static void main(String[] args) {

        System.out.println("[Main] Creating Object for Abstract Class is not possible");

        // Shape myShape = new Shape(); //Try uncommenting this line.

        //error: Shape is abstract; cannot be instantiated

        System.out.println("[Main] Creating Objects Circle and Rectangle");
        ACircle myCircle = new ACircle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        ARectangle myRect = new ARectangle(); // Create a Rectangle Object
        myRect.display();
        myRect.area();
    }
}
