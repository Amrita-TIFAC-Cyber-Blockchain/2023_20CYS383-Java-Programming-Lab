package com.amrita.jpl.cys21048.ex;


/**
 * practice on inheritance
 * three non main classes have been provided
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

/**
 * car class inheriting class vehicle
 */

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

/**
 * bike class inheriting class vehicle
 */
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

/**
 * main class
 */

public class inheritance {
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

