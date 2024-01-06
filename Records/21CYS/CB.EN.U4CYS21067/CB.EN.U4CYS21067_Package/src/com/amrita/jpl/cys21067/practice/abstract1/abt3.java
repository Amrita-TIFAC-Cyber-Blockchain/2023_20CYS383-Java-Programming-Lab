package com.amrita.jpl.cys21067.practice.abstract1;

/**
 * Represents an animal.
 */
abstract class Animal {
    private String name;

    /**
     * Constructs an animal object with the given name.
     *
     * @param name the name of the animal
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Makes a sound specific to the animal.
     */
    public abstract void makeSound();

    /**
     * Makes the animal sleep.
     */
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

/**
 * Represents a dog that extends the Animal class.
 */
class Dog extends Animal {
    /**
     * Constructs a dog object with the given name.
     *
     * @param name the name of the dog
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * Makes the dog bark.
     */
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

/**
 * Represents a cat that extends the Animal class.
 */
class Cat extends Animal {
    /**
     * Constructs a cat object with the given name.
     *
     * @param name the name of the cat
     */
    public Cat(String name) {
        super(name);
    }

    /**
     * Makes the cat meow.
     */
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

/**
 * A sample class to demonstrate abstract classes and usage of the Animal, Dog, and Cat classes.
 */
public class abt3 {
    /**
     * The main method that demonstrates the usage of the classes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        dog.makeSound();
        dog.sleep();

        cat.makeSound();
        cat.sleep();
    }
}
