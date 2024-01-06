package com.amrita.jpl.cys21060.Ex;

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
    private int numWheels;

    public Car(String modelName, int year, int numWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameter "+modelName+", "+year+", "+numWheels);
    }
    public void drive(int gearPosition){
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numGears;
    public Bike(String brandName, int year,int numGears){
        this.brandName = brandName;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter "+brandName+", "+year+", "+numGears);
    }
    public void pedal(int pedalSpeed){
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class Inheritance {
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