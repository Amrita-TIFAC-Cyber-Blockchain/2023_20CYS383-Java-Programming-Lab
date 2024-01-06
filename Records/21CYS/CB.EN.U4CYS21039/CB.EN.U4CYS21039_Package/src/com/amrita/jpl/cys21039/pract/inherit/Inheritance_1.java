package com.amrita.jpl.cys21039.pract.inherit;

/**
 * @author Manbendra Satpathy
 */

/**
 * A class representing a Vehicle.
 */
class Vehicle {
    int run_status = 0;

    /**
     * Starts the vehicle.
     */
    public void start() {
        run_status = 1;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle.
     */
    public void stop() {
        run_status = 0;
        System.out.println("[Vehicle] stopped.");
    }
}

/**
 * A class representing a Car, extending the Vehicle class.
 */
class Car extends Vehicle {

    /**
     * Constructs a Car object with the given parameters.
     *
     * @param model_name    The model name of the car.
     * @param Year          The year of the car.
     * @param no_of_wheels  The number of wheels of the car.
     */
    public Car(String model_name, int Year, int no_of_wheels) {
        System.out.println("Car Instantiated with Parameter " + model_name + ", " + Year + ", " + no_of_wheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gear_position The gear position to drive the car in.
     */
    public void drive(int gear_position) {
        if (run_status == 0) {
            System.out.println("Cannot drive. Start the car first.");
        } else {
            System.out.println("Driving the car in gear position: " + gear_position);
        }
    }
}

/**
 * A class representing a Bike, extending the Vehicle class.
 */
class Bike extends Vehicle {

    /**
     * Constructs a Bike object with the given parameters.
     *
     * @param brand_name    The brand name of the bike.
     * @param Year          The year of the bike.
     * @param no_of_gears   The number of gears of the bike.
     */
    public Bike(String brand_name, int Year, int no_of_gears) {
        System.out.println("Bike  Instantiated with Parameter " + brand_name + ", " + Year + ", " + no_of_gears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedal_speed   The speed at which to pedal the bike.
     */
    public void pedal(int pedal_speed) {
        if (run_status == 0) {
            System.out.println("Cannot pedal. Start the bike first.");
        } else {
            System.out.println("Pedaling the bike at speed: " + pedal_speed);
        }
    }
}

/**
 * Main class to demonstrate inheritance.
 */
public class Inheritance_1 {
    public static void main(String[] args) {
        Car newCar = new Car("Jaguar XF", 2022, 4);
        newCar.drive(3);
        newCar.stop();
        Bike newBike = new Bike("Giant", 2021, 18);
        newBike.pedal(10);
        newBike.stop();
    }
}
