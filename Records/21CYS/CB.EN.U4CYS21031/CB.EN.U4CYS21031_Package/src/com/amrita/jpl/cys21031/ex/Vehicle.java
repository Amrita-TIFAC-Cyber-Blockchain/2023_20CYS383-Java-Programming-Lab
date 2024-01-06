package com.amrita.jpl.cys21031.ex;

/**
 * @author Kishanth K
 * @version 0.5
 *
 * A class Vehicle using Inheritence
 */

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

class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameters: " + modelName + ", " + year + ", " + numOfWheels);
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;

    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameters: " + brandName + ", " + year + ", " + numOfGears);
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Jaguar XF", 2022, 4);
        myCar.start();
        myCar.drive(3);
        myCar.stop();

        System.out.println();

        Bike myBike = new Bike("Giant", 2021, 18);
        myBike.start();
        myBike.pedal(10);
        myBike.stop();
    }
}
