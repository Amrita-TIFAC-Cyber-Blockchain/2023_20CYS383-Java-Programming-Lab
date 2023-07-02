package com.amrita.jpl.cys21015.pract.oop;

/**
 * The abstract class Shape represents a geometric shape.
 * @author Dyanesh S
 */
abstract class Shape {

    /**
     * Abstract method to calculate the area of the shape.
     */
    public abstract void area();

    /**
     * Method to display a message related to calculating the area.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

/**
 * The Circle class represents a circle, which is a subclass of Shape.
 */
class Circle extends Shape {

    /**
     * Calculates the area of a circle.
     */
    public void area() {
        System.out.println("[Abstract Method in Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The Rectangle class represents a rectangle, which is a subclass of Shape.
 */
class Rectangle extends Shape {

    /**
     * Calculates the area of a rectangle.
     */
    public void area() {
        System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L*B");
    }

}

/**
 * The Shapes class demonstrates the usage of abstract classes and subclasses.
 */
public class abstract_Shapes {

    /**
     * The main method is the entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("[Main] Creating Object for Abstract Class is not possible");

        // Shape myShape = new Shape(); // Try uncommenting this line.

        // error: Shape is abstract; cannot be instantiated

        System.out.println("[Main] Creating Objects Circle and Rectangle");
        Circle myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        Rectangle myRect = new Rectangle(); // Create a Rectangle Object
        myRect.display();
        myRect.area();
    }

}
