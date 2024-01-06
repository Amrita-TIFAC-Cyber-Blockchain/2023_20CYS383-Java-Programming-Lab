package com.amrita.jpl.cys21044.ex.vehicle;

class Vehicle {
    /**
     * @author ravi
     */
    protected boolean run_status;

    public void start() {

        run_status = true;
        System.out.println("[Vehicle] started.");
        /**
         * @param run_status - will inform about whether vehicle is already started or not.
         */
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

    /**
     * @param modelName- model name of the car
     * @param year- models year
     * @param  numOfWheels- no.of wheels
     */

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numOfWheels);
    }

    public void drive(int gearPosition) {

        System.out.println("Driving the car in gear position: " + gearPosition);
    }
}

class Bike extends Vehicle {

    private String brandName;
    private int year;
    private int numOfGears;
    /**
     * @param brandName- brand name of the bike
     * @param year-model year
     * @param numOfGears-no.of gears
     */

    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + numOfGears);
    }

    public void pedal(int pedalSpeed) {
        if (!run_status) {
            System.out.println("Error: Vehicle is not running. Cannot pedal.");
            return;
        }
        System.out.println("Pedaling the bike at speed: " + pedalSpeed);
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

        Car car1 = new Car("Jaguar XF", 2022, 4);
        car1.drive(3); // Try to drive without starting
        car1.stop();

        Bike bike1 = new Bike("Giant", 2021, 18);
        bike1.pedal(10); // Try to pedal without starting
        bike1.stop();
    }
}
