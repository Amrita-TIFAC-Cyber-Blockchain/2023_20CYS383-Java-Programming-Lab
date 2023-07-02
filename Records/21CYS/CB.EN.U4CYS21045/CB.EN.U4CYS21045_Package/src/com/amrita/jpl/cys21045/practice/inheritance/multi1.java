package com.amrita.jpl.cys21045.practice.inheritance;

/**
 * Represents a vehicle.
 */
class Vehicle12 {
    protected String brand;

    /**
     * Sets the brand of the vehicle.
     *
     * @param brand the brand name
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Displays information about the vehicle.
     */
    public void displayInfo() {
        System.out.println("Brand: " + brand);
    }
}

/**
 * Represents a car that extends the Vehicle class.
 */
class Car12 extends Vehicle12 {
    private int numberOfDoors;

    /**
     * Sets the number of doors of the car.
     *
     * @param doors the number of doors
     */
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }

    /**
     * Displays information about the car, including the number of doors.
     */
    public void displayCar12Info() {
        displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

/**
 * Represents a sedan that extends the Car12 class.
 */
class Sedan extends Car12 {
    private int seatingCapacity;

    /**
     * Sets the seating capacity of the sedan.
     *
     * @param capacity the seating capacity
     */
    public void setSeatingCapacity(int capacity) {
        this.seatingCapacity = capacity;
    }

    /**
     * Displays information about the sedan, including the seating capacity.
     */
    public void displaySedanInfo() {
        displayCar12Info();
        System.out.println("Seating capacity: " + seatingCapacity);
    }
}

/**
 * A sample class to demonstrate multi-level inheritance and usage of the Vehicle12, Car12, and Sedan classes.
 */
public class multi1 {
    /**
     * The main method that demonstrates the usage of the classes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.setBrand("Toyota");
        sedan.setNumberOfDoors(4);
        sedan.setSeatingCapacity(5);
        sedan.displaySedanInfo();
    }
}
