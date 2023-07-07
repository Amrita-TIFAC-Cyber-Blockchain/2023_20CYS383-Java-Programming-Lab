package com.amrita.jpl.cys21068.ex;

import java.util.Scanner;
/**
 * A class representing a Vehicle.
 */
class Vehicle {
    protected boolean run_status;
    /**
     * Starts the vehicle.
     */
    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }
    /**
     * Stops the vehicle.
     */
    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}
/**
 * A class representing a Car, which is a subclass of Vehicle.
 */
class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;
/**
 * Constructs a Car object with the specified model name, year, and number of wheels.
 */
    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameters " + modelName + ", " + year + ", " + numOfWheels);
    }
/**
 * Drives the car in the specified gear position.
 */
    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("[Error] The car is not running.");
        }
    }
}
/**
 * A class representing a Bike, which is a subclass of Vehicle.
 */
class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;
/**
 * Constructs a Bike object with the specified brand name, year, and number of gears.
 */
    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameters " + brandName + ", " + year + ", " + numOfGears);
    }
/**
 * Pedals the bike at the specified pedal speed.
 */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("[Error] The bike is not running.");
        }
    }
}
/**
 * A class that demonstrates the usage of the Vehicle, Car, and Bike classes.
 */
public class Vehicle_Inheritance {
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
