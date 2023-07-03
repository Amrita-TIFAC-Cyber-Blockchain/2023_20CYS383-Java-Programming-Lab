package com.amrita.jpl.cys21062.ex;

/**
 * @author Ruthwik Krishna Bandreddy
 * The Vehicle class represents a generic vehicle with start and stop functionality.
 */
class Vehicle {
    public boolean run_status;

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
 * The Car class represents a car that extends the Vehicle class.
 */
class Car extends Vehicle {
    private String model;
    private int year;
    private int numOfWheels;

    /**
     * Constructs a Car object with the given model, year, and number of wheels.
     *
     * @param model       The model of the car.
     * @param year        The year of the car.
     * @param numOfWheels The number of wheels of the car.
     */
    public Car(String model, int year, int numOfWheels) {
        this.model = model;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numOfWheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition The gear position to drive the car in.
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
 * The Bike class represents a bike that extends the Vehicle class.
 */
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numOfGears;

    /**
     * Constructs a Bike object with the given brand, year, and number of gears.
     *
     * @param brand       The brand of the bike.
     * @param year        The year of the bike.
     * @param numOfGears  The number of gears of the bike.
     */
    public Bike(String brand, int year, int numOfGears) {
        this.brand = brand;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numOfGears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed The speed at which the bike is being pedaled.
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
 * The JavaInheritance class is the entry point for the program.
 * It creates instances of Car and Bike and demonstrates inheritance.
 */
public class JavaInheritance {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();

        System.out.println();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}
