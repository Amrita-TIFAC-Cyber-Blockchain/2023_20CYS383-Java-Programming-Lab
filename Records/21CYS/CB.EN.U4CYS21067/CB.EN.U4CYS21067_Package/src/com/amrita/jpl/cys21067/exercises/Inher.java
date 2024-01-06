package com.amrita.jpl.cys21067.exercises;

/**
 * The Vehicle class represents a vehicle with start and stop functionality.
 */
class Vehicle {
    protected boolean runstat;

    /**
     * Starts the vehicle.
     */
    public void start() {
        runstat = true;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle.
     */
    public void stop() {
        runstat = false;
        System.out.println("[Vehicle] stopped.");
    }
}

/**
 * The Car class represents a car, which is a type of vehicle.
 */
class Car extends Vehicle {
    private String model;
    private int year;
    private int no_of_wheels;

    /**
     * Constructs a Car object with the given model, year, and number of wheels.
     *
     * @param model        The model of the car.
     * @param year         The year of the car.
     * @param no_of_wheels The number of wheels of the car.
     */
    public Car(String model, int year, int no_of_wheels) {
        this.model = model;
        this.year = year;
        this.no_of_wheels = no_of_wheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + no_of_wheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearpos The gear position to drive the car.
     */
    public void drive(int gearpos) {
        if (runstat) {
            System.out.println("Driving the car in gear position: " + gearpos);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

/**
 * The Bike class represents a bike, which is a type of vehicle.
 */
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int no_of_gears;

    /**
     * Constructs a Bike object with the given brand, year, and number of gears.
     *
     * @param brand       The brand of the bike.
     * @param year        The year of the bike.
     * @param no_of_gears The number of gears of the bike.
     */
    public Bike(String brand, int year, int no_of_gears) {
        this.brand = brand;
        this.year = year;
        this.no_of_gears = no_of_gears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + no_of_gears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed The pedal speed of the bike.
     */
    public void pedal(int pedalSpeed) {
        if (runstat) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

/**
 * The Inher class demonstrates the usage of the Car and Bike classes.
 */
public class Inher {
    /**
     * The main method creates Car and Bike objects and performs operations on them.
     *
     * @param args The command-line arguments (not used).
     */
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
