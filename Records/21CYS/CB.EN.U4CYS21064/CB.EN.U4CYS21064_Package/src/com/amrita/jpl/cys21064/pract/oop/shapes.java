package com.amrita.jpl.cys21064.pract.oop;

/**
 * The Shape class is an abstract class that defines the basic structure and behavior of shapes.
 * It contains an abstract method for calculating the area and a display method.
 * Subclasses of Shape must provide an implementation for the area method.
 *
 * @author Rajendraprasad S
 */
abstract class Shape {

    /**
     * Calculates the area of the shape.
     */
    public abstract void area();

    /**
     * Displays a message indicating that the area is being calculated.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

/**
 * The Circle class is a subclass of Shape that represents a circle shape.
 * It provides an implementation for the area method specific to circles.
 */
class Circle extends Shape {

    /**
     * Calculates the area of the circle.
     * This method overrides the area method defined in the Shape class.
     */
    public void area() {
        System.out.println("[Abstract Method in Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The Rectangle class is a subclass of Shape that represents a rectangle shape.
 * It provides an implementation for the area method specific to rectangles.
 */
class Rectangle extends Shape {

    /**
     * Calculates the area of the rectangle.
     * This method overrides the area method defined in the Shape class.
     */
    public void area() {
        System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L*B");
    }

}


public class shapes {

    public static void main(String[] args) {

        System.out.println("[Main] Creating Object for Abstract Class is not possible");

        // Shape myShape = new Shape(); //Try uncommenting this line.

        //error: Shape is abstract; cannot be instantiated

        System.out.println("[Main] Creating Objects Circle and Rectangle");
        Circle myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        Rectangle myRect = new Rectangle(); // Create a Rectangle Object
        myRect.display();
        myRect.area();
    }

}
