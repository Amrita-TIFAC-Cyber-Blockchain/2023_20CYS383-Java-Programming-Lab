package com.amrita.jpl.cys21027.practice.classes;

/**
 * The Animal class is an abstract class that represents an animal.
 * It defines an abstract method sound() and a non-abstract method sleep().
 * This class serves as a base for specific animal classes.
 *
 * @author K Nitin
 * @version 1.0
 */
abstract class Animal {
    /**
     * The sound() method is an abstract method that must be implemented by derived classes.
     * It represents the sound made by the animal.
     */
    public abstract void sound();

    /**
     * The sleep() method is a non-abstract method that represents the sleeping behavior of the animal.
     * It prints "Zzz... Coming from Non Abstract Method".
     */
    public void sleep() {
        System.out.println("Zzz... Coming from Non Abstract Method");
    }
}

/**
 * The Jumpable interface represents the ability to jump.
 * It declares the jump() method that must be implemented by classes that implement this interface.
 */
interface Jumpable {
    /**
     * The jump() method represents the action of jumping.
     */
    void jump();
}

/**
 * The Cat class represents a cat, which is a specific type of animal.
 * It extends the Animal class and implements the Jumpable interface.
 * It provides implementations for the sound() method and the jump() method.
 */
class Cat extends Animal implements Jumpable {
    /**
     * The sound() method is implemented to print "Meow! Implementing the abstract method from the abstract class".
     */
    public void sound() {
        System.out.println("Meow! Implementing the abstract method from the abstract class");
    }

    /**
     * The jump() method is implemented to print "Jumping like a cat! and Implement method from the interface".
     */
    public void jump() {
        System.out.println("Jumping like a cat! and Implement method from the interface");
    }
}

/**
 * The Classes class is the main class that demonstrates the usage of abstract classes and interfaces.
 */
public class Classes {
    /**
     * The main() method is the entry point of the program.
     * It creates an instance of the Cat class and calls its sound(), sleep(), and jump() methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sound();
        cat.sleep();
        cat.jump();
    }
}
