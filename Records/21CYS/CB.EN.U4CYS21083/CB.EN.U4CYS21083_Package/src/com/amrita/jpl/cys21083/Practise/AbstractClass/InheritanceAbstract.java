package com.amrita.jpl.cys21083.Practise.AbstractClass;


// if a method is abstract then the inherited classes should have the definition of abstract method, or it throws an error
// A abstract method can be there only in abstract class

/**
 * The Shape class is an abstract class that represents a geometric shape.
 * It provides a common structure for calculating the area of different shapes.
 */
abstract class Shape {
    // abstract method without definition
    public abstract void area();

    // Method with definition
    public void display() {
        System.out.println("[Super] Calculating ");
    }
}

// Subclass (inherited from Shape)

/**
 * The Circle class represents a circle shape.
 * It extends the Shape class and provides the implementation for calculating the area of a circle.
 */
class Circle extends Shape {
    public void area() {
        System.out.println("[Abstract Method in Circle] Area of Circle is PI*R*R");
    }
}

// Subclass (inherited from Shape)

/**
 * The Rectangle class represents a rectangle shape.
 * It extends the Shape class and provides the implementation for calculating the area of a rectangle.
 */
class Rectangle extends Shape {
    public void area() {
        // area() of Rectangle Class - Definition
        System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L*B");
    }
}

/**
 * The Square class represents a square shape.
 * It extends the Shape class and provides the implementation for calculating the area of a square.
 */
class Square extends Shape {
    public void area() {
        System.out.println("[Square] Area of the Circle is (side)^2 ");
    }
}

/**
 * The Triangle class represents a triangle shape.
 * It extends the Shape class and provides the implementation for calculating the area of a triangle.
 */
class Triangle extends Shape {
    public void area() {
        System.out.println("[Triangle] Area of Triangle is 1/2*base*height ");
    }
}

/**
 * The InheritanceAbstract class is the main class that demonstrates inheritance with abstract classes.
 */
public class InheritanceAbstract {
    public static void main(String[] args){

        //   Shape myShape = new Shape(); //Try uncommenting this line.
        //error: Shape is abstract; cannot be instantiated
        // we cannot create an object for abstract class
        Circle myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.area();
        System.out.println("\n");
        Square sq = new Square(); //creating a square object
        sq.display();
        sq.area();
        System.out.println("\n");
        Rectangle myRect = new Rectangle(); // Create a Rectangle object
        myRect.display();
        myRect.area();
        System.out.println("\n");
        Triangle tri = new Triangle();
        tri.display();
        tri.area();
    }
}
