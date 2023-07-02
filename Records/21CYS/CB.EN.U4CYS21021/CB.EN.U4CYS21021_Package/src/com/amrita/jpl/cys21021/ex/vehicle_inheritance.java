package com.amrita.jpl.cys21021.ex;

import java.util.Scanner;

/**
 * The Vehicle class represents a general vehicle.
 */
class Vehicle {
    protected boolean run_status;

    /**
     * Constructs a new Vehicle object.
     */
    public Vehicle() {
        run_status = false;
    }

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
 * The Car class represents a car that inherits from Vehicle.
 */
class Car extends Vehicle {
    private String model;
    private int year;
    private int numWheels;

    /**
     * Constructs a new Car object with the given parameters.
     *
     * @param model      the model of the car
     * @param year       the year of the car
     * @param numWheels  the number of wheels on the car
     */
    public Car(String model, int year, int numWheels) {
        this.model = model;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
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
            System.out.println("Error: The car is not running.");
        }
    }
}

/**
 * The Bike class represents a bike that inherits from Vehicle.
 */
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numGears;

    /**
     * Constructs a new Bike object with the given parameters.
     *
     * @param brand     the brand of the bike
     * @param year      the year of the bike
     * @param numGears  the number of gears on the bike
     */
    public Bike(String brand, int year, int numGears) {
        this.brand = brand;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed the speed at which to pedal the bike
     */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: The bike is not running.");
        }
    }
}

/**
 * The vehicle_inheritance class contains the main method to test the Vehicle, Car, and Bike classes.
 */
public class vehicle_inheritance {
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
