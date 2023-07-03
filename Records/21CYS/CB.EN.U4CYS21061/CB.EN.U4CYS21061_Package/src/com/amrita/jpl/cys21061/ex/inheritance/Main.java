package com.amrita.jpl.cys21061.ex.inheritance;

/**
 * @author Roshni-CYS21061
 */
import java.util.Scanner;

class Vehicle {
    /**
     * parent class member function and variable
     */
    public void start() {
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    /**
     * child class member functions
     */
    private String modelName;
    private int yearC;
    private int numOfWheels;
    private int gear;

    public void Car() {
        /**
         * @param YearC
         * @param ModelName
         * @param Num_of_Wheels
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Model Name: ");
        modelName = scanner.nextLine();
        System.out.print("Enter Year: ");
        yearC = scanner.nextInt();
        System.out.print("Enter Number of Wheels: ");
        numOfWheels = scanner.nextInt();
    }

    public void drive() {

        /**
         * @param Gear
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Gear: ");
        gear = scanner.nextInt();
        System.out.println("Driving the car in gear position: " + gear);
    }

    @Override
    public void start() {
        System.out.println("Car Instantiated with Parameters: Model Name = " + modelName +
                ", Year = " + yearC + ", Number of Wheels = " + numOfWheels);
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}

class Bike extends Vehicle {
    /**
     * child class member functions
     */
    private String brandName;
    private int yearB;
    private int numOfGears;
    private int pedalSpeed;

    public void Bike() {
        /**
         * @param YearB
         * @param BrandName
         * @param Num_of_Gears
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Brand Name: ");
        brandName = scanner.nextLine();
        System.out.print("Enter Year: ");
        yearB = scanner.nextInt();
        System.out.print("Enter Number of Gears: ");
        numOfGears = scanner.nextInt();
    }

    public void pedal() {
        /**
         * @param PedalSpeed
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Pedal Speed: ");
        pedalSpeed = scanner.nextInt();
        System.out.println("Pedaling the bike at speed: " + pedalSpeed);
    }

    @Override
    public void start() {
        System.out.println("Bike Instantiated with Parameters: Brand Name = " + brandName +
                ", Year = " + yearB + ", Number of Gears = " + numOfGears);
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}

public class Main {
    public static void main(String[] args) {
        Car C = new Car();
        C.start();
        C.drive();
        C.stop();

        Bike B = new Bike();
        B.start();
        B.pedal();
        B.stop();
    }
}
