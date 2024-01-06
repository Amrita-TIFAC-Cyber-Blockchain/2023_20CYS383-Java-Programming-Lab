package com.amrita.jpl.cys21055.ex;

/**
 * @author Penugonda V S Ganasekhar
 * @version 0.1
 * The Vehicle class represents a vehicle with a run status.
 */
class Vehicle {
    protected boolean run_status;

    /**
     * Constructs a Vehicle object and initializes the run status to false.
     */
    public Vehicle() {
        run_status = false;
    }

    /**
     * Starts the vehicle by setting the run status to true.
     */
    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle by setting the run status to false.
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

    /**
     * Constructs a Car object with the specified model, year, and number of wheels.
     *
     * @param model      the model of the car
     * @param year       the year of the car
     * @param numWheels  the number of wheels on the car
     */
    public Car(String model, int year, int numWheels) {
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gear  the gear position
     */
    public void drive(int gear) {
        if (!run_status) {
            System.out.println("Error: Car is not running.");
            return;
        }

        System.out.println("Driving the car in gear position: " + gear);
    }
}

/**
 * The Bike class represents a bike that inherits from Vehicle.
 */
class Bike extends Vehicle {

    /**
     * Constructs a Bike object with the specified brand, year, and number of gears.
     *
     * @param brand      the brand of the bike
     * @param year       the year of the bike
     * @param numGears   the number of gears on the bike
     */
    public Bike(String brand, int year, int numGears) {
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    /**
     * Pedals the bike at the specified speed.
     *
     * @param speed  the pedal speed
     */
    public void pedal(int speed) {
        if (!run_status) {
            System.out.println("Error: Bike is not running.");
            return;
        }

        System.out.println("Pedaling the bike at speed: " + speed);
    }
}

/**
 * The Vehicle_Inheritance class demonstrates the inheritance hierarchy of Vehicle, Car, and Bike classes.
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
