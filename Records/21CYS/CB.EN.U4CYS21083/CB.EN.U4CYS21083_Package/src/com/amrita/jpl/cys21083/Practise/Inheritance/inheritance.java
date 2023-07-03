package com.amrita.jpl.cys21083.Practise.Inheritance;
/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

// shape class is the base class
class Shape {
    //public void area() { }
    // Method
    public void display() {
        System.out.println("[Super] Calculating Area");
    }
}
// extends keyword is used for inheritating the class
// Subclass (inherited from Shape)
class Circle extends Shape {
    public void area() {
        // area() of Circle Class - Definition
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }
}

// Subclass (inherited from shape)
class Square extends Shape {
    public void area() {
        System.out.println("[Square] Area of the Circle is (side)^2 ");
    }
}

// Subclass (inherited from Shape)
class Rectangle extends Shape {
    public void area() {
        // area() of Rectangle Class - Definition
        System.out.println("[Rectangle] Area of Rectangle is L*B ");
    }
}

class Triangle extends Shape {
    public void area() {
        System.out.println("[Triangle] Area of Triangle is 1/2*base*height ");
    }
}

public class inheritance {
    public static void main(String[] args) {
        System.out.println("[Main] Creating Objects for Circle, Square, Rectangle, Triangle");
        System.out.println("\n");

        Shape myshape = new Shape(); //creating an object for shape

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

