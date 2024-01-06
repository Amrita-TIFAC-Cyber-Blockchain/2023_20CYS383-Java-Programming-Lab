package com.amrita.jpl.cys21008.Ex;




import java.util.Scanner;

/**
 * The `Vehicle` class represents a general vehicle with start and stop functionality.
 * @Author:Anuvarshini M K
 */
class Vehicle {
    boolean run_status = false;

    /**
     * Starts the vehicle.
     * Prints "started" to the console.
     */
    public void start() {
        System.out.println("started");
    }

    /**
     * Stops the vehicle.
     * Prints "stopped" to the console.
     */
    public void stop() {
        System.out.println("stopped");
    }
}

/**
 * The `Car` class represents a car and extends the `Vehicle` class.
 */
class Car extends Vehicle {
    Scanner sc = new Scanner(System.in);
    String model_Name;
    int year;
    int num_of_wheels;

    /**
     * Constructs a new instance of the `Car` class.
     * Prompts the user for the car's model name, year, and number of wheels.
     * Prints the instantiated car's parameters to the console.
     */
    public Car() {
        model_Name = sc.nextLine();
        year = sc.nextInt();
        num_of_wheels = sc.nextInt();
        System.out.println("Car Instantiated with Parameters: " + model_Name + " " + year + " " + num_of_wheels);
    }

    /**
     * Drives the car in the specified gear.
     * Prints "Driving the car in gear position: " followed by the gear value to the console.
     *
     * @param gear the gear position to drive the car in
     */
    public void drive(int gear) {
        System.out.println("Driving the car in gear position: " + gear);
    }
}

/**
 * The `Bike` class represents a bike and extends the `Vehicle` class.
 */
class Bike extends Vehicle {
    Scanner sc = new Scanner(System.in);
    String brand_Name;
    int year;
    int num_of_gears;

    /**
     * Constructs a new instance of the `Bike` class.
     * Prompts the user for the bike's brand name, year, and number of gears.
     * Prints the instantiated bike's parameters to the console.
     */
    public Bike() {
        brand_Name = sc.nextLine();
        year = sc.nextInt();
        num_of_gears = sc.nextInt();
        System.out.println("Bike Instantiated with Parameters: " + brand_Name + " " + year + " " + num_of_gears);
    }

    /**
     * Pedals the bike at the specified speed.
     * Prints "Pedaling the bike at speed: " followed by the speed value to the console.
     *
     * @param speed the speed at which to pedal the bike
     */
    public void pedal(int speed) {
        System.out.println("Pedaling the bike at speed: " + speed);
    }
}

/**
 * The `Inheritance` class is the main class that contains the entry point of the program.
 * It demonstrates inheritance by creating instances of `Car` and `Bike` classes, and invoking their methods.
 *
 */
public class Inheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gear = sc.nextInt();
        int speed = sc.nextInt();

        Car c = new Car();
        c.start();
        c.drive(gear);
        c.stop();

        Bike b = new Bike();
        b.start();
        b.pedal(speed);
        b.stop();
    }
}
