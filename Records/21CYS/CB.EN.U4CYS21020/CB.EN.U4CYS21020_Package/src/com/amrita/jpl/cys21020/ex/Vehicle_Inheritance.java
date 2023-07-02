package com.amrita.jpl.cys21020.ex;

/**
 * @author Hemesh sai
 * @version 1.0
 * The Vehicle_Inheritance class demonstrates the concept of inheritance in Java.
 * It defines a base class Vehicle and two derived classes, Car and Bike, which inherit from the Vehicle class.
 */
public class Vehicle_Inheritance {

    /**
     * The Vehicle class represents a generic vehicle with a running status.
     */
    static class Vehicle {
        boolean running_status;

        /**
         * Sets the running status of the vehicle to true.
         */
        public void start() {
            this.running_status = true;
        }

        /**
         * Sets the running status of the vehicle to false and displays a stop message.
         */
        public void stop() {
            this.running_status = false;
            System.out.println("[Vehicle] stopped.");
        }
    }

    /**
     * The Car class is a derived class of Vehicle, representing a car with additional properties.
     */
    static class Car extends Vehicle {
        String Model;
        int Year;
        int Num;

        /**
         * Constructs a Car object with the specified model, year, and number of wheels.
         * It also initializes the car by calling the start method and displaying an instantiation message.
         *
         * @param x   The model of the car.
         * @param y   The year of the car.
         * @param z   The number of wheels of the car.
         */
        Car(String x, int y, int z) {
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Car Instantiated with Parameter " + x + ", " + y + ", " + z);
            System.out.println("Cannot drive. Start the car first.");
            start();
        }

        /**
         * Displays the gear position the car is currently in and calls the stop method.
         *
         * @param g   The gear position of the car.
         */
        public void gears(int g) {
            System.out.println("Driving the car in gear position: " + g);
            stop();
        }
    }

    /**
     * The Bike class is a derived class of Vehicle, representing a bike with additional properties.
     */
    static class Bike extends Vehicle {
        String Model;
        int Year;
        int Num;

        /**
         * Constructs a Bike object with the specified model, year, and number of gears.
         * It also initializes the bike by calling the start method and displaying an instantiation message.
         *
         * @param x   The model of the bike.
         * @param y   The year of the bike.
         * @param z   The number of gears of the bike.
         */
        Bike(String x, int y, int z) {
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Bike Instantiated with Parameter " + x + ", " + y + ", " + z);
            System.out.println("Cannot pedal. Start the bike first.");
            start();
        }

        /**
         * Displays the speed at which the bike is being pedaled and calls the stop method.
         *
         * @param p   The speed at which the bike is being pedaled.
         */
        public void pedal(int p) {
            System.out.println("Pedaling the bike at speed: " + p);
            stop();
        }
    }

    /**
     * The main method creates instances of Car and Bike classes, demonstrating the use of inheritance and method overriding.
     *
     * @param args   The command-line arguments.
     */
    public static void main(String args[]) {
        Car x = new Car("Jaguar XF", 2022, 4);
        //x.gears(3);
        Bike y = new Bike("Giant", 2021, 18);
        //y.pedal(10);
    }
}
