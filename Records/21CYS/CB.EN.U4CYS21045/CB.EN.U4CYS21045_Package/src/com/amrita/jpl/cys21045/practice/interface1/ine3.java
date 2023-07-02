package com.amrita.jpl.cys21045.practice.interface1;
/**
 * The Shape interface represents a geometric shape.
 */
interface Shape {

    /**
     * Calculates the area of the shape.
     *
     * @return the area of the shape
     */
    double calculateArea();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return the perimeter of the shape
     */
    double calculatePerimeter();
}

/**
 * The Rectangle class represents a rectangle shape.
 */
class Rectangle implements Shape {
    private double length;
    private double width;

    /**
     * Constructs a new Rectangle object with the given length and width.
     *
     * @param length the length of the rectangle
     * @param width the width of the rectangle
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    public double calculateArea() {
        return length * width;
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     */
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

/**
 * This class is used to demonstrate the usage of the Rectangle class.
 */
public class ine3 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 3);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
    }
}
