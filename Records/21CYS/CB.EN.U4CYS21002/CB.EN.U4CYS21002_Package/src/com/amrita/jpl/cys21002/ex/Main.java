package com.amrita.jpl.cys21002.ex;
import java.util.Scanner;
/**
 * The Vehicle class represents a generic vehicle.
 */

class Vehicle {
    protected boolean runStatus;
    /**
     * Starts the vehicle.
     */

    public void start() {
        runStatus = true;
        System.out.println("Vehicle started.");
    }
    /**
     * Stops the vehicle.
     */

    public void stop() {
        runStatus = false;
        System.out.println("Vehicle stopped.");
    }
}
/**
 * The Car class represents a car and extends the Vehicle class.
 */
class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;
    /**
     * Constructs a Car object with the given model name, year, and number of wheels.
     *
     * @param modelName   the model name of the car
     * @param year        the year of the car
     * @param numOfWheels the number of wheels of the car
     */

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
    }
    /**
     * Drives the car in the specified gear position.
     *
     * @param gearPosition the gear position of the car
     */

    public void drive(int gearPosition) {
        if (runStatus) {
            System.out.println("Car is driving in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}
/**
 * The Bike class represents a bike and extends the Vehicle class.
 */
class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;
    /**
     * Constructs a Bike object with the given brand name, year, and number of gears.
     *
     * @param brandName   the brand name of the bike
     * @param year        the year of the bike
     * @param numOfGears  the number of gears of the bike
     */

    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
    }
    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedalSpeed the pedal speed of the bike
     */

    public void pedal(int pedalSpeed) {
        if (runStatus) {
            System.out.println("Bike is pedaling at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}
/**
 * The Main class is the entry point of the program.
 */
public class Main {
    /**
     * The main method where the program starts execution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter car model name: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter car year: ");
        int carYear = scanner.nextInt();
        System.out.print("Enter car number of wheels: ");
        int carWheels = scanner.nextInt();

        Car car = new Car(carModel, carYear, carWheels);

        System.out.print("Enter bike brand name: ");
        scanner.nextLine(); // Consume the remaining newline character
        String bikeBrand = scanner.nextLine();
        System.out.print("Enter bike year: ");
        int bikeYear = scanner.nextInt();
        System.out.print("Enter bike number of gears: ");
        int bikeGears = scanner.nextInt();

        Bike bike = new Bike(bikeBrand, bikeYear, bikeGears);

        car.start();
        System.out.print("Enter car gear position: ");
        int carGear = scanner.nextInt();
        car.drive(carGear);
        car.stop();

        bike.start();
        System.out.print("Enter bike pedal speed: ");
        int bikeSpeed = scanner.nextInt();
        bike.pedal(bikeSpeed);
        bike.stop();

        scanner.close();
    }
}



