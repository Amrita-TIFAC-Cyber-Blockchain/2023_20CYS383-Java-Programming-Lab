package com.amrita.jpl.cys21034.ex;
/**
 *class Vehicle
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
/**
 *class Car inheriting Vehicle
 */

class Car extends Vehicle {
    private String model;
    private int year;
    private int numwheels;

    public Car(String model, int year, int numwheels) {
        this.model = model;
        this.year = year;
        this.numwheels = numwheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numwheels);
    }

    public void drive(int gearposition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearposition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}
/**
 *class Bike inheriting Vehicle
 */
class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numgears;

    public Bike(String brand, int year, int numgears) {
        this.brand = brand;
        this.year = year;
        this.numgears = numgears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numgears);
    }

    public void pedal(int pedalspeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalspeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class vinherit {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Car car1 = new Car("Jaguar XF", 2022, 4);
        car1.start();
        car1.drive(3);
        car1.stop();

        Bike bike1 = new Bike("Giant", 2021, 18);
        bike1.start();
        bike1.pedal(10);
        bike1.stop();

        Car car2 = new Car("Jaguar XF", 2022, 4);
        car2.drive(3);
        car2.stop();

        Bike bike2 = new Bike("Giant", 2021, 18);
        bike2.pedal(10);
        bike2.stop();
    }
}
