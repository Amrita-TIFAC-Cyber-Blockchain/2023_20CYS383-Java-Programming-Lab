package com.amrita.jpl.cys21015.pract.oop;

/**
 * The aShape class represents a generic shape.
 */
class aShape {

    /**
     * Method stub for calculating the area of the shape.
     * This method should be overridden in subclasses.
     */
    public void area() {
        // Method body intentionally left empty
    }

    /**
     * Method to display a message related to calculating the area.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

/**
 * The aCircle class represents a circle, which is a subclass of aShape.
 */
class aCircle extends aShape {

    /**
     * Calculates the area of a circle.
     */
    public void area() {
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The aRectangle class represents a rectangle, which is a subclass of aShape.
 */
class aRectangle extends aShape {

    /**
     * Calculates the area of a rectangle.
     */
    public void area() {
        System.out.println("[Rectangle] Area of Rectangle is L*B");
    }

}

/**
 * The inheritance_Shape class demonstrates the usage of inheritance with shapes.
 */
public class inheritance_Shape {

    /**
     * The main method is the entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("[Main] Creating Objects Circle and Rectangle");

        aCircle myCircle = new aCircle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        aRectangle myRect = new aRectangle(); // Create a Rectangle object
        myRect.display();
        myRect.area();
    }

}
