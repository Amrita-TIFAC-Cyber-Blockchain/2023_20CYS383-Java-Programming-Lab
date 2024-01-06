package com.amrita.jpl.cys21087.ex;

/**
 * This program demonstrates the concept of inheritance by defining a Vehicle class and two subclasses: Car and Bike.
 *
 * The Vehicle class represents a generic vehicle and provides basic functionality to start and stop the vehicle.
 * The Car class extends the Vehicle class and adds specific features such as model, year, and the ability to drive.
 * The Bike class also extends the Vehicle class and adds brand, year, and the ability to pedal.
 *
 * The program creates instances of the Car and Bike classes, sets their properties, starts them, performs actions,
 * and stops them. The results are displayed in the console.
 *
 */
public class Vehicle {
    protected boolean run_status;

    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }

    static class Car extends Vehicle {
        private String model;
        private int year;
        private int numWheels;

        public Car(String model, int year, int numWheels) {
            this.model = model;
            this.year = year;
            this.numWheels = numWheels;
            System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
        }

        public void drive(int gearPosition) {
            if (run_status) {
                System.out.println("Driving the car in gear position: " + gearPosition);
            } else {
                System.out.println("Error: Cannot drive. Vehicle is not running.");
            }
        }
    }

    static class Bike extends Vehicle {
        private String brand;
        private int year;
        private int numGears;

        public Bike(String brand, int year, int numGears) {
            this.brand = brand;
            this.year = year;
            this.numGears = numGears;
            System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
        }

        public void pedal(int pedalSpeed) {
            if (run_status) {
                System.out.println("Pedaling the bike at speed: " + pedalSpeed);
            } else {
                System.out.println("Error: Cannot pedal. Vehicle is not running.");
            }
        }
    }

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
