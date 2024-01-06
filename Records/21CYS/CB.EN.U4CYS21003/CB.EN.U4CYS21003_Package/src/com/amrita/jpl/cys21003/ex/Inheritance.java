package com.amrita.jpl.cys21003.ex;
/**
 * This class demonstrates the Inheritance program
 *
 * @author Aishwarya G
 * @version 1.0
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
    private String modelname;
    private int year;
    private int numofWheels;

    /**
     *
     * @param modelname
     * @param year
     * @param numofWheels
     */
    public Car(String modelname, int year, int numofWheels) {
        this.modelname = modelname;
        this.year = year;
        this.numofWheels = numofWheels;
        System.out.println("Car Instantiated with Parameter " + modelname + ", " + year + ", " + numofWheels);
    }

    /**
     *
     * @param gearPosition
     */
    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error");
        }

    }

}

class Bike extends Vehicle {
    private String brandname;
    private int year;
    private int numofGears;

    /**
     *
     * @param brandname
     * @param year
     * @param numofGears
     */
    public Bike(String brandname, int year, int numofGears) {
        this.brandname = brandname;
        this.year = year;
        this.numofGears = numofGears;
        System.out.println("Bike Instantiated with Parameter " + brandname + ", " + year + ", " + numofGears);
    }

    /**
     *
     * @param pedalSpeed
     */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error.");
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