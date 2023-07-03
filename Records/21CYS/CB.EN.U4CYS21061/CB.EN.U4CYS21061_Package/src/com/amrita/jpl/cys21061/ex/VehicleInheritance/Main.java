package com.amrita.jpl.cys21061.ex.VehicleInheritance;
import java.util.Scanner;

class Vehicle {
    public void start() {
    }

    public void stop() {
    }
}

class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numWheels;

    public void setCarDetails(String modelName, int year, int numWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numWheels = numWheels;
    }

    public void drive(int gear) {
        if (gear != 0) {
            System.out.println("Driving the car in gear position: " + gear);
        } else {
            System.out.println("Invalid gear position. Cannot drive.");
        }
    }

    @Override
    public void start() {
        System.out.println("Car instantiated with parameters: " + modelName + ", " + year + ", " + numWheels);
        System.out.println("[Vehicle] started.");
    }

    @Override
    public void stop() {
        System.out.println("[Vehicle] stopped.");
    }
}

class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numGears;

    public void setBikeDetails(String brandName, int year, int numGears) {
        this.brandName = brandName;
        this.year = year;
        this.numGears = numGears;
    }

    public void pedal(int pedalSpeed) {
        if (pedalSpeed != 0) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Invalid pedal speed. Cannot pedal.");
        }
    }

    @Override
    public void start() {
        System.out.println("Bike instantiated with parameters: " + brandName + ", " + year + ", " + numGears);
        System.out.println("[Vehicle] started.");
    }

    @Override
    public void stop() {
        System.out.println("[Vehicle] stopped.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = new Car();
        car.setCarDetails("Jaguar XF", 2022, 4);
        car.start();
        System.out.print("Enter the gear position: ");
        int carGear = scanner.nextInt();
        car.drive(carGear);
        car.stop();

        Bike bike = new Bike();
        bike.setBikeDetails("Giant", 2021, 18);
        bike.start();
        System.out.print("Enter the pedal speed: ");
        int bikePedalSpeed = scanner.nextInt();
        bike.pedal(bikePedalSpeed);
        bike.stop();
    }
}
