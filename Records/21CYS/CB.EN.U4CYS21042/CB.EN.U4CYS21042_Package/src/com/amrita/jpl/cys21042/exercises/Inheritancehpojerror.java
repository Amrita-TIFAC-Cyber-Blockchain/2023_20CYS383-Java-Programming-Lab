package com.amrita.jpl.cys21042.exercises;

/**
 * @Author : Mittul R
 * @Roll no : CB.EN.U4CYS21042
 */

// Vehicle class
class Vehicle {
    protected boolean run_status;

    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

// Car class
class Car extends Vehicle {
    private String model;
    private int year;
    private int numWheels;

    public Car(String model, int year, int numWheels) {
        this.model = model;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameters " + model + ", " + year + ", " + numWheels);
    }

    public void drive(int gearPosition) {
        if (!run_status) {
            System.out.println("Cannot drive. Start the car first.");
            return;
        }
        System.out.println("Driving the car in gear position: " + gearPosition);
    }
}

// Bike class
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numGears;

    public Bike(String brand, int year, int numGears) {
        this.brand = brand;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameters " + brand + ", " + year + ", " + numGears);
    }

    public void pedal(int pedalSpeed) {
        if (!run_status) {
            System.out.println("Cannot pedal. Start the bike first.");
            return;
        }
        System.out.println("Pedaling the bike at speed: " + pedalSpeed);
    }
}

// Main class
public class Inheritancehpojerror {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.drive(3); // Cannot drive. Start the car first.
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.pedal(10); // Cannot pedal. Start the bike first.
        bike.stop();
    }
}

