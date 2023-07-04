package com.amrita.jpl.cys21085.ex;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * Represents a generic Vehicle.
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
 * Represents a Car, a subclass of Vehicle.
 */
class Car extends Vehicle {
    private final String model;
    private final int year;
    private final int wheels;

    /**
     * Constructs a Car object with the given parameters.
     *
     * @param model  the car model
     * @param year   the manufacturing year
     * @param wheels the number of wheels
     */
    public Car(String model, int year, int wheels) {
        this.model = model;
        this.year = year;
        this.wheels = wheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + wheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition the gear position
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
 * Represents a Bike, a subclass of Vehicle.
 */
class Bike extends Vehicle {
    private final String brand;
    private final int year;
    private final int numGears;

    /**
     * Constructs a Bike object with the given parameters.
     *
     * @param brand    the bike brand
     * @param year     the manufacturing year
     * @param numGears the number of gears
     */
    public Bike(String brand, int year, int numGears) {
        this.brand = brand;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    /**
     * Pedals the bike at the specified speed.
     *
     * @param pedalSpeed the pedal speed
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
 * Main class that demonstrates the usage of Car and Bike classes.
 */
public class Inheritance {
    /**
     * Entry point of the program.
     *
     * @param args command-line arguments
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
