package com.amrita.jpl.cys21039.pract.inherit;

/**
 * @author Manbendra Satpathy
 */
/**
 * A class representing a Vehicle.
 */
class Vehicle_2 {
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
 * A class representing a Car, extending the Vehicle_2 class.
 */
class Car_2 extends Vehicle_2 {
    private String model;
    private int year;
    private int wheel;

    /**
     * Constructs a Car_2 object with the given parameters.
     *
     * @param model The model of the car.
     * @param year  The manufacturing year of the car.
     * @param wheel The number of wheels of the car.
     */
    public Car_2(String model, int year, int wheel) {
        super();
        this.model = model;
        this.year = year;
        this.wheel = wheel;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + wheel);
    }

    /**
     * Drives the car in the specified gear.
     *
     * @param gear The gear position to drive the car in.
     */
    public void drive(int gear) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gear);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

/**
 * A class representing a Bike, extending the Vehicle_2 class.
 */
class Bike_2 extends Vehicle_2 {
    private String brand;
    private int year;
    private int numgear;

    /**
     * Constructs a Bike_2 object with the given parameters.
     *
     * @param brand    The brand of the bike.
     * @param year     The manufacturing year of the bike.
     * @param numgear  The number of gears of the bike.
     */
    public Bike_2(String brand, int year, int numgear) {
        super();
        this.brand = brand;
        this.year = year;
        this.numgear = numgear;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numgear);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed The speed at which to pedal the bike.
     */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

/**
 * Main class to demonstrate inheritance.
 */
public class Inheritance_2 {
    public static void main(String[] args) {
        Car_2 car = new Car_2("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();
        Bike_2 bike = new Bike_2("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}
