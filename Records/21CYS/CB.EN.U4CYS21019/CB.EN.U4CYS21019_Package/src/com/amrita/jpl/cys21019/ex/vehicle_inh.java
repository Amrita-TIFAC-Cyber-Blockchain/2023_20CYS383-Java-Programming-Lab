package com.amrita.jpl.cys21019.ex;
/**
 * @author Gokulachselvan C D
 * The Vehicle class represents a generic vehicle.
 */
class Vehicle {
    /** The running status of the vehicle. */
    public boolean runStatus;

    /**
     * Starts the vehicle.
     */
    public void start() {
        runStatus = true;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle.
     */
    public void stop() {
        runStatus = false;
        System.out.println("[Vehicle] stopped.");
    }

    /**
     * Checks if the vehicle is running.
     *
     * @return true if the vehicle is running, false otherwise.
     */
    public boolean isRunning() {
        return runStatus;
    }
}

/**
 * The Car class represents a car, which is a type of vehicle.
 */
class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;

    /**
     * Constructs a Car object with the given parameters.
     *
     * @param modelName    the model name of the car
     * @param year         the year of the car
     * @param numOfWheels  the number of wheels on the car
     */
    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numOfWheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition  the gear position to drive the car in
     */
    public void drive(int gearPosition) {
        if (isRunning()) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

/**
 * The Bike class represents a bike, which is a type of vehicle.
 */
class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;

    /**
     * Constructs a Bike object with the given parameters.
     *
     * @param brandName    the brand name of the bike
     * @param year         the year of the bike
     * @param numOfGears   the number of gears on the bike
     */
    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + numOfGears);
    }

    /**
     * Pedals the bike at the specified speed.
     *
     * @param pedalSpeed  the speed at which to pedal the bike
     */
    public void pedal(int pedalSpeed) {
        if (isRunning()) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

/**
 * The Filetransfer class contains the main method to test the Car and Bike classes.
 */
public class vehicle_inh {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        // car.start();
        car.drive(3);
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);
        // bike.start();
        bike.pedal(10);
        bike.stop();
    }
}