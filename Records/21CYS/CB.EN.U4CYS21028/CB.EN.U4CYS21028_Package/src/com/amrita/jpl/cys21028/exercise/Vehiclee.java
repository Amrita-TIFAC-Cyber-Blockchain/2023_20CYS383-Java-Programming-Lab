package com.amrita.jpl.cys21028.exercise;
class Vehicle {
    protected boolean runStatus;

    public void start() {
        runStatus = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        runStatus = false;
        System.out.println("Vehicle stopped");
    }
}

// Car class
class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
    }

    public void drive(String gearPosition) {
        if (runStatus) {
            System.out.println("Car is driving in " + gearPosition + " gear");
        } else {
            System.out.println("Car is not started");
        }
    }
}

// Bike class
class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;

    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
    }

    public void pedal(int pedalSpeed) {
        if (runStatus) {
            System.out.println("Bike is pedaling at speed " + pedalSpeed);
        } else {
            System.out.println("Bike is not started");
        }
    }
}

// Main class
public class Vehiclee {
    public static void main(String[] args) {
        /**
         * @param args gives arguement typpe of string
         */
        Car car = new Car("sfsdsad", 2022, 4);
        car.start();
        car.drive("third");
        car.stop();

        System.out.println();

        // Instantiate Bike object
        Bike bike = new Bike("Giant", 2022, 10);
        bike.start();
        bike.pedal(200);
        bike.stop();
    }
}
