package com.amrita.jpl.cys21027.exercise;

/**

 * The Vehicle class represents a generic vehicle with start and stop functionality.

 * @author K Sri Sai Nitin
 * @version 1.0

 */
class Vehicle{

    protected boolean run_status;

    /**

     * Starts the vehicle.
     */
    public void start(){
        run_status = true;
        System.out.println("[Vehicle] started.");
    }
    /**

     * Stops the vehicle.
     */
    public void stop(){
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}
/**

 * The Car class extends the Vehicle class and represents a car with specific attributes.
 */
class Car extends Vehicle {
    private String modelname;
    private int year;
    private int numofwheels;

    /**

    *  Constructs a Car object with the given model name, year, and number of wheels.
     * @param modelname the model name of the car
     * @param year the manufacturing year of the car
     * @param numofwheels the number of wheels of the car
     */
    public Car(String modelname, int year, int numofwheels){
        this.modelname = modelname;
        this.year = year;
        this.numofwheels = numofwheels;
        System.out.println("Car Instantiated with Parameter " + modelname + ", " + year + ", " + numofwheels);
    }
    /**

     * Drives the car in the specified gear position.
     * @param gear_position the gear position to drive the car in
     */
    public void drive(int gear_position){
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gear_position);
        } else {
            System.out.println("Error: The car is not running.");
        }
    }
}

/**

 * The Bike class extends the Vehicle class and represents a bike with specific attributes.
 */
class Bike extends Vehicle {
    private String brandname;
    private int year;
    private int numofgears;

    /**

     * Constructs a Bike object with the given brand name, year, and number of gears.
     * @param brandname the brand name of the bike
     * @param year the manufacturing year of the bike
     * @param numofgears the number of gears of the bike
     */
    public Bike(String brandname, int year, int numofgears) {
        this.brandname = brandname;
        this.year = year;
        this.numofgears = numofgears;
        System.out.println("Bike Instantiated with Parameter " + brandname + ", " + year + ", " + numofgears);
    }
    /**

     * Pedals the bike at the specified pedal speed.
     * @param pedal_speed the speed at which to pedal the bike
     */
    public void pedal(int pedal_speed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedal_speed);
        } else {
            System.out.println("Error: The bike is not running.");
        }
    }
}

/**

 * The Vehicle_Inheritance class is the main class that demonstrates the inheritance hierarchy
 * between the Vehicle, Car, and Bike classes.
 */
public class Vehicle_Inheritance {
    public static void main(String[] args) {
        /**
         * The main method allows users to input two numbers and performs addition and subtraction.
         * @param args the command-line arguments
         */
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