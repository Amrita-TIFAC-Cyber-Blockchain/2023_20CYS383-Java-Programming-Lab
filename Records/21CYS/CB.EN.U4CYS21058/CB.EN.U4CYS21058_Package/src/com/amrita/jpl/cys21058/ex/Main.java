package com.amrita.jpl.cys21058.ex;

import java.util.Scanner;

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
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numOfWheels);
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
    private String brand;
    private int year;
    private int numOfGears;

    public Bike(String brand, int year, int numOfGears) {
        this.brand = brand;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numOfGears);
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

public class Main {
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

//author Siddharth Krishna R
//@version 0.1