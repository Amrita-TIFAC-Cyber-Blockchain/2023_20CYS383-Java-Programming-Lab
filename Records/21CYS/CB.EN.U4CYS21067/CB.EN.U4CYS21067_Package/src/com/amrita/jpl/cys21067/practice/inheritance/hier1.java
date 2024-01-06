package com.amrita.jpl.cys21067.practice.inheritance;

/**
 * Represents a vehicle.
 */
class Vehicle13 {
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
class Car13 extends Vehicle13 {
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
    public void displayCar13Info() {
        displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

/**
 * Represents a motorcycle that extends the Vehicle class.
 */
class Motorcycle extends Vehicle13 {
    private boolean hasSideCar13;

    /**
     * Sets whether the motorcycle has a sidecar.
     *
     * @param hasSideCar13 true if the motorcycle has a sidecar, false otherwise
     */
    public void setHasSideCar13(boolean hasSideCar13) {
        this.hasSideCar13 = hasSideCar13;
    }

    /**
     * Displays information about the motorcycle, including whether it has a sidecar.
     */
    public void displayMotorcycleInfo() {
        displayInfo();
        System.out.println("Has sidecar: " + hasSideCar13);
    }
}

/**
 * A sample class to demonstrate inheritance and usage of the Vehicle, Car13, and Motorcycle classes.
 */
public class hier1 {
    /**
     * The main method that demonstrates the usage of the classes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car13 car13 = new Car13();
        car13.setBrand("Toyota");
        car13.setNumberOfDoors(4);
        car13.displayCar13Info();

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("Harley-Davidson");
        motorcycle.setHasSideCar13(false);
        motorcycle.displayMotorcycleInfo();
    }
}
