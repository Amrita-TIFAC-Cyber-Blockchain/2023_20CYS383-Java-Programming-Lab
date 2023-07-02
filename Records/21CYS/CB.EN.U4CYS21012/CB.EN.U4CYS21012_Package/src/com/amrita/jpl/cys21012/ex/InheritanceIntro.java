package com.amrita.jpl.cys21012.ex;

/**
 * The Shape class represents a generic shape.
 * @author Ashwin Anand
 */
class Shape {

    /**
     * Calculates the area of the shape.
     * This method does not have a body and should be overridden by subclasses.
     */
    public void area() { }

    /**
     * Displays a message indicating the calculation of the area.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

/**
 * The Circle class is a subclass of Shape, representing a circle.
 */
class Circle extends Shape {

    /**
     * Calculates the area of the circle.
     * Overrides the area() method defined in the Shape class.
     */
    public void area() {
        // area() of Circle Class - Definition
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The Rectangle class is a subclass of Shape, representing a rectangle.
 */
class Rectangle extends Shape {

    /**
     * Calculates the area of the rectangle.
     * Overrides the area() method defined in the Shape class.
     */
    public void area() {
        // area() of Rectangle Class - Definition
        System.out.println("[Rectangle] Area of Rectangle is L*B");
    }

}

/**
 * The InheritanceIntro class is a program that demonstrates inheritance in Java.
 */
public class InheritanceIntro {

    public class Main {

        public static void main(String[] args) {

            System.out.println("[Main] Creating Objects Circle and Rectangle");

            Circle myCircle = new Circle(); // Create a Circle object
            myCircle.display();
            myCircle.area();

            Rectangle myRect = new Rectangle(); // Create a Rectangle object
            myRect.display();
            myRect.area();
        }

    }
}
