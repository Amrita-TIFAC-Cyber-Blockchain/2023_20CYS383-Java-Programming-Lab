package com.amrita.jpl.cys21078.exercise;
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
    private String model;
    private int year;
    private int numOfWheels;

    public Car(String model, int year, int numOfWheels) {
        this.model = model;
        this.year = year;
        this.numOfWheels = numOfWheels;
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Cannot drive the car as it is not running.");
        }
    }
}

class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numOfGears;

    public Bike(String brand, int year, int numOfGears) {
        this.brand = brand;
        this.year = year;
        this.numOfGears = numOfGears;
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Cannot pedal the bike as it is not running.");
        }
    }
}

public class Vehicle1 {
    public static void main(String[] args) {
        System.out.println("Car Instantiated with Parameter Jaguar XF, 2022, 4");
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();

        System.out.println();
        System.out.println("Bike Instantiated with Parameter Giant, 2021, 18");
        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}