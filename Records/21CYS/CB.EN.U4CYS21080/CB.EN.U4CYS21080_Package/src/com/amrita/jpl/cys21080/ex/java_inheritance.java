package com.amrita.jpl.cys21080.ex;

/**
 * @author T Pavan Kumar Reddy
 * @version 1.0
 *
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

class Car extends Vehicle {
    private String model;
    private int year;
    private int now;

    /**
     * Constructs a Car object with the given model, year, and current gear position.
     *
     * @param model the model of the car
     * @param year  the year of the car
     * @param now   the current gear position of the car
     */
    public Car(String model, int year, int now) {
        this.model = model;
        this.year = year;
        this.now = now;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + now);
    }

    /**
     * Drives the car in the given gear position.
     *
     * @param gp the gear position
     */
    public void drive(int gp) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gp);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle {
    private String brand;
    private int year;
    private int nog;

    /**
     * Constructs a Bike object with the given brand, year, and number of gears.
     *
     * @param brand the brand of the bike
     * @param year  the year of the bike
     * @param nog   the number of gears of the bike
     */
    public Bike(String brand, int year, int nog) {
        this.brand = brand;
        this.year = year;
        this.nog = nog;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + nog);
    }

    /**
     * Pedals the bike at the given speed.
     *
     * @param ps the speed of pedaling
     */
    public void pedal(int ps) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + ps);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class java_inheritance {
    /**
     * The main method is the entry point of the Java inheritance example.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.drive(3);
        car.stop();
        Bike bike = new Bike("Giant", 2021, 18);
        bike.pedal(10);
        bike.stop();
    }
}
