package com.amrita.jpl.cys21043.ex;

// Base class representing a Vehicle
class Vehicle {
    protected boolean run_status;

    // Constructor to initialize run_status to false
    public Vehicle() {
        run_status = false;
    }

    // Method to start the vehicle
    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    // Method to stop the vehicle
    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

// Subclass Car, inheriting from Vehicle
class Car extends Vehicle {

    // Constructor to initialize Car with model, year, and number of wheels
    public Car(String model, int year, int numWheels) {
        System.out.println("Car Instantiated with Parameters: " + model + ", " + year + ", " + numWheels);
    }

    // Method to drive the car in a specific gear position
    public void drive(int gear) {
        // Check if the car is running
        if (!run_status) {
            System.out.println("Error: Car is not running.");
            return;
        }

        System.out.println("Driving the car in gear position: " + gear);
    }
}

// Subclass Bike, inheriting from Vehicle
class Bike extends Vehicle {

    // Constructor to initialize Bike with brand, year, and number of gears
    public Bike(String brand, int year, int numGears) {
        System.out.println("Bike Instantiated with Parameters: " + brand + ", " + year + ", " + numGears);
    }

    // Method to pedal the bike at a specific speed
    public void pedal(int speed) {
        // Check if the bike is running
        if (!run_status) {
            System.out.println("Error: Bike is not running.");
            return;
        }

        System.out.println("Pedaling the bike at speed: " + speed);
    }
}

public class vechicle {
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
