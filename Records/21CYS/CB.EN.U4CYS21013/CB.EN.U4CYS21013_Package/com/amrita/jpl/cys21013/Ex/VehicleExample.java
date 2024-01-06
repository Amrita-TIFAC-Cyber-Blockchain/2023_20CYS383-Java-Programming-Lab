package com.amrita.jpl.cys21013.Ex;

/**
 * Shows class inheritance
 * @author rohit
 * @version 1.0
 */

/**
 * Represents a Vehicle with start and stop functions.
 */
class Vehicle {
    protected boolean run_status;

    /**
     * Constructs a Vehicle object with run_status set to false.
     */
    public Vehicle() {
        run_status = false;
    }

    /**
     * Starts the vehicle by setting run_status to true.
     */
    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle by setting run_status to false.
     */
    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

/**
 * Represents a Car that inherits from Vehicle.
 */
class Car extends Vehicle {
    private String model;
    private int year;
    private int wheels;

    /**
     * Constructs a Car object with the specified model, year, and number of wheels.
     *
     * @param model  the model name of the car
     * @param year   the year of the car
     * @param wheels the number of wheels on the car
     */
    public Car(String model, int year, int wheels) {
        this.model = model;
        this.year = year;
        this.wheels = wheels;
        System.out.println("Car Instantiated with Parameters: " + model + ", " + year + ", " + wheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition the gear position to drive the car in
     */
    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

/**
 * Represents a Bike that inherits from Vehicle.
 */
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int gears;

    /**
     * Constructs a Bike object with the specified brand, year, and number of gears.
     *
     * @param brand the brand name of the bike
     * @param year  the year of the bike
     * @param gears the number of gears on the bike
     */
    public Bike(String brand, int year, int gears) {
        this.brand = brand;
        this.year = year;
        this.gears = gears;
        System.out.println("Bike Instantiated with Parameters: " + brand + ", " + year + ", " + gears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed the speed at which the bike is being pedaled
     */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

/**
 * Demonstrates the usage of the Vehicle, Car, and Bike classes.
 */
public class VehicleExample {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}
