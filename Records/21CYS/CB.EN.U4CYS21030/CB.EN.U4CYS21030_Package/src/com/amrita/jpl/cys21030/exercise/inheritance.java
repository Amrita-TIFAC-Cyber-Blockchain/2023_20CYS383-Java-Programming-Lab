
package com.amrita.jpl.cys21030.exercise;
import java.util.Scanner;
class Vehicle {
    protected boolean run_status;

    public void start() {
        run_status = true;
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
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numOfWheels);
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving car with gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
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
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + numOfGears);
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling bike with speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.drive(3);
        car.stop();

        System.out.println();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.pedal(10);
        bike.stop();
    }
}