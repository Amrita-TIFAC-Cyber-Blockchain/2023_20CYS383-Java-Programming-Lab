package com.amrita.jpl.cys21017.ex;

class JavaInheritance {
    // java class named Vehicle with functions start and stop with variable run_status that is boolean and modified by start and stop functions
    public static class Vehicle {
        boolean run_status = false;
        void start() {
            run_status = true;
            System.out.println("[Vehicle] started.");
        }
        void stop() {
            run_status = false;
            System.out.println("[Vehicle] stopped.");
        }
    }

    // class car that inherits from vehicle
    public static class Car extends Vehicle {
        String model;
        int year;
        int numOfWheels;
        // contructor takes in model, year, and numOfWheels
        Car(String model, int year, int numOfWheels) {
            this.model = model;
            this.year = year;
            this.numOfWheels = numOfWheels;
            System.out.println("Car Instantiated with Parameter " + model + ", " +  year + ", " + numOfWheels);
        }

        // car has function drive which takes in gear position and prints out the gear position
        void drive(int gearPosition) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        }
    }

    public static class Bike extends Vehicle {
        String brandName;
        int year;
        int numOfGears;

        Bike(String brandName, int year, int numOfGears) {
            this.brandName = brandName;
            this.year = year;
            this.numOfGears = numOfGears;
            System.out.println("Bike Instantiated with Parameter " + brandName + ", " +  year + ", " + numOfGears);
        }

        void pedal(int pedalSpeed) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        }
    }

    public static void main(String[] args) {

        // instantiate a car object with model, year, and numOfWheels
        Car myCar = new Car("Jaguar XF", 2022, 4);
        // start the car
        myCar.start();
        myCar.drive(3);
        myCar.stop();
        // instantiate a bike object with brandName, year, and numOfGears
        Bike myBike = new Bike("Giant", 2021, 18);
        myBike.start();
        myBike.pedal(10);
        myBike.stop();
    }

}