package com.amrita.jpl.cys21033.exercise;

/**
 * A base class representing a vehicle.
 * @author Suhitha
 */
class Vehicle {
    boolean runStatus;

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
}

/**
 * A class representing a car, which is a type of vehicle.
 */
class Car extends Vehicle {
    String modelName;
    int year, numWheels;

    /**
     * Constructs a car with the given parameters.
     *
     * @param modelName  the model name of the car
     * @param year       the manufacturing year of the car
     * @param numWheels  the number of wheels on the car
     */
    public Car(String modelName, int year, int numWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car instantiated with parameters: " + modelName + ", " + year + ", " + numWheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition  the gear position to drive in
     */
    public void drive(int gearPosition) {
        if (runStatus) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Car is not running.");
        }
    }
}

/**
 * A class representing a bike, which is a type of vehicle.
 */
class Bike extends Vehicle {
    String brandName;
    int year, numGears;

    /**
     * Constructs a bike with the given parameters.
     *
     * @param brandName  the brand name of the bike
     * @param year       the manufacturing year of the bike
     * @param numGears   the number of gears on the bike
     */
    public Bike(String brandName, int year, int numGears) {
        this.brandName = brandName;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike instantiated with parameters: " + brandName + ", " + year + ", " + numGears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed  the speed at which to pedal the bike
     */
    public void pedal(int pedalSpeed) {
        if (runStatus) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Bike is not running.");
        }
    }
}

/**
 * A class that demonstrates inheritance and the usage of vehicles.
 */
public class VInheritance {
    /**
     * The main method that creates and interacts with vehicles.
     *
     * @param args  the command-line arguments
     */
    public static void main(String[] args) {
        Car myCar = new Car("Jaguar XF", 2022, 4);
        Bike myBike = new Bike("Giant", 2021, 18);

        myCar.start();
        myCar.drive(3);
        myCar.stop();

        myBike.start();
        myBike.pedal(10);
        myBike.stop();
    }
}
