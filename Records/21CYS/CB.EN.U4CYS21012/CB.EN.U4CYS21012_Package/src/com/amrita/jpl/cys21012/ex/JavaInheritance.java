package com.amrita.jpl.cys21012.ex;

/**
 * The Vehicle class is an abstract class representing a generic vehicle.
 */
abstract class Vehicle{
    int run_status;

    /**
     * Starts the vehicle.
     * Updates the run status to indicate that the vehicle is running.
     */
    public void start(){
        System.out.println("[Vehicle] started.");
        run_status = 1;
    }

    /**
     * Stops the vehicle.
     * Updates the run status to indicate that the vehicle is stopped.
     */
    public void stop(){
        System.out.println("[Vehicle] stopped.");
        run_status = 0;
    }

}

/**
 * The Car class is a subclass of Vehicle, representing a car.
 */
class Car extends Vehicle{
    String model_name;
    String years;
    int wheels;

    /**
     * Constructs a Car object with the given parameters.
     *
     * @param a The model name of the car.
     * @param b The manufacturing year of the car.
     * @param c The number of wheels on the car.
     */
    public Car(String a,String b,int c){
        model_name = a;
        years = b;
        wheels = c;
        System.out.println("Car Instantiated with Parameter " + model_name + ", " + years + ", " + wheels);
    }

    /**
     * Drives the car in a specific gear position.
     *
     * @param k The gear position.
     */
    public void drive(int k){
        if (run_status == 0){
            System.out.println("Cannot drive. Start the car first.");
        }
        else {
            System.out.println("Driving the car in gear position: " + k);
        }
    }
}

/**
 * The Bike class is a subclass of Vehicle, representing a bike.
 */
class Bike extends Vehicle{
    String brand_name;
    String years;
    int wheels;

    /**
     * Constructs a Bike object with the given parameters.
     *
     * @param a The brand name of the bike.
     * @param b The manufacturing year of the bike.
     * @param c The number of wheels on the bike.
     */
    public Bike(String a, String b, int c){
        brand_name = a;
        years = b;
        wheels = c;
        System.out.println("Bike Instantiated with Parameter " + brand_name + ", " + years + ", " + wheels);
    }

    /**
     * Pedals the bike at a specific speed.
     *
     * @param k The speed of pedaling.
     */
    public void pedal(int k){
        if (run_status == 1) {
            System.out.println("Pedaling the bike at speed: " + k);
        }
        else{
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

/**
 * The JavaInheritance class is a program that demonstrates inheritance in Java.
 * @author Ashwin Anand
 */
public class JavaInheritance {
    public static void main(String[] args){
        Car Car1 = new Car("Parameter Jaguar XF", "2022", 4);
        Car1.start();
        Car1.drive(3);
        Car1.stop();
        Bike Bike1 = new Bike("Parameter Giant", "2021", 18);
        Bike1.start();
        Bike1.pedal(10);
        Bike1.stop();
    }
}
