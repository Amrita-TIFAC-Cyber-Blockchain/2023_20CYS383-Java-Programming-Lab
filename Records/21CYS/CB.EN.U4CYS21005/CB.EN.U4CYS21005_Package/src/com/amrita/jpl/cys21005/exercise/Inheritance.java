package com.amrita.jpl.cys21005.exercise;
/**
 * @author Alagu Soundarya G
 * @version 1.0
 * Inheritance Program
 */
class Vehicle {
    protected boolean runStatus;

    public void start() {
        runStatus = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        runStatus = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numWheels;

    public Car(String modelName, int year, int numWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numWheels);
    }

    public void drive(int gearPosition) {
        if (!runStatus) {
            System.out.println("Error: Car is not running.");
            return;
        }
        System.out.println("Driving the car in gear position: " + gearPosition);
    }
}

class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numGears;

    public Bike(String brandName, int year, int numGears) {
        this.brandName = brandName;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + numGears);
    }

    public void pedal(int pedalSpeed) {
        if (!runStatus) {
            System.out.println("Error: Bike is not running.");
            return;
        }
        System.out.println("Pedaling the bike at speed: " + pedalSpeed);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();

        Bike bike = new Bike("Giant",2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}