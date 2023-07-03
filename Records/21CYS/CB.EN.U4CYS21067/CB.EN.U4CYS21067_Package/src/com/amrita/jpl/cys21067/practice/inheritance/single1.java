package com.amrita.jpl.cys21067.practice.inheritance;

/**
 * Represents a vehicle.
 */
class Vehicle11 {
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
 * Represents a car that extends the Vehicle11 class.
 */
class Car11 extends Vehicle11 {
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
    public void displayCar11Info() {
        displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

/**
 * A sample class to demonstrate single inheritance and usage of the Vehicle11 and Car11 classes.
 */
public class single1 {
    /**
     * The main method that demonstrates the usage of the classes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car11 car11 = new Car11();
        car11.setBrand("Toyota");
        car11.setNumberOfDoors(4);
        car11.displayCar11Info();
    }
}
