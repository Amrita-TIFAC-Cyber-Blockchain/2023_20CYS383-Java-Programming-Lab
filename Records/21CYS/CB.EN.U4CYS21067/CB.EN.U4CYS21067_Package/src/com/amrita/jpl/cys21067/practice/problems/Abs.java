package com.amrita.jpl.cys21067.practice.problems;

/**
 * The Shape class is an abstract class representing a shape.
 */
abstract class Shape {

  /**
   * Abstract method to calculate the area of the shape.
   */
  public abstract void area();

  /**
   * Method to display a message.
   */
  public void display() {
    System.out.println("[Super] Calculating Area");
  }

}

/**
 * The Circle class is a subclass of Shape representing a circle.
 */
class Circle extends Shape {

  /**
   * Implementation of the area() method for a circle.
   */
  public void area() {
    System.out.println("[Abstract Method in Circle] Area of Circle is PI*R*R");
  }

}

/**
 * The Rectangle class is a subclass of Shape representing a rectangle.
 */
class Rectangle extends Shape {

  /**
   * Implementation of the area() method for a rectangle.
   */
  public void area() {
    System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L*B");
  }

}

/**
 * The Abs class is the main class that demonstrates the usage of abstract classes.
 */
public class Abs {

  /**
   * The main method is the entry point of the program.
   *
   * @param args the command-line arguments
   */
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
