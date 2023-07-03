package com.amrita.jpl.cys21069.exercise;
/**
 * The Vehicle class represents an example for an inhertance.
 * It has Vehicle as main class.
 * Usage:
 * -car and bike inherits from vehicle class
 *
 * Vehicle class has two functions start and stop
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */
class Vehicle {
    protected boolean run_status;

    public Vehicle() {
        run_status = false;
    }

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

    public Car(String model, int year, int numWheels) {
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
    }

    public void drive(int gear) {
        if (!run_status) {
            System.out.println("Error: Car is not running.");
            return;
        }

        System.out.println("Driving the car in gear position: " + gear);
    }
}

class Bike extends Vehicle {

    public Bike(String brand, int year, int numGears) {
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    public void pedal(int speed) {
        if (!run_status) {
            System.out.println("Error: Bike is not running.");
            return;
        }

        System.out.println("Pedaling the bike at speed: " + speed);
    }
}

public class VehicleInheritance {
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
