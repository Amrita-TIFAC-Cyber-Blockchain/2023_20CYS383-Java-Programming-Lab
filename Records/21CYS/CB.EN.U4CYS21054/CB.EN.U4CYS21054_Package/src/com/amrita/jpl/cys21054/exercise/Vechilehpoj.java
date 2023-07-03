package com.amrita.jpl.cys21054.exercise;

/**
 * Represents a generic vehicle.
 */
class Vehicle {
    int run_status = 0;

    /**
     * Starts the vehicle.
     */
    public void start() {
        run_status = 1;
        System.out.println("[Vehicle] started.");
    }

    /**
     * Stops the vehicle.
     */
    public void stop() {
        run_status = 0;
        System.out.println("[Vehicle] stopped.");
    }
}

/**
 * Represents a car that extends the Vehicle class.
 */
class Car extends Vehicle {

    /**
     * Constructs a Car object with the specified model name, year, and number of wheels.
     *
     * @param model_name     the model name of the car
     * @param Year           the manufacturing year of the car
     * @param no_of_wheels   the number of wheels on the car
     */
    public Car(String model_name, int Year, int no_of_wheels) {
        System.out.println("Car Instantiated with Parameter " + model_name + ", " + Year + ", " + no_of_wheels);
    }

    /**
     * Drives the car in the specified gear position.
     *
     * @param gear_position   the gear position to drive the car in
     */
    public void drive(int gear_position) {
        if (run_status == 0) {
            System.out.println("Cannot drive. Start the car first.");
        } else {
            System.out.println("Driving the car in gear position: " + gear_position);
        }
    }
}

/**
 * Represents a bike that extends the Vehicle class.
 */
class Bike extends Vehicle {

    /**
     * Constructs a Bike object with the specified brand name, year, and number of gears.
     *
     * @param brand_name     the brand name of the bike
     * @param Year           the manufacturing year of the bike
     * @param no_of_gears    the number of gears on the bike
     */
    public Bike(String brand_name, int Year, int no_of_gears) {
        System.out.println("Bike Instantiated with Parameter " + brand_name + ", " + Year + ", " + no_of_gears);
    }

    /**
     * Pedals the bike at the specified pedal speed.
     *
     * @param pedal_speed   the speed at which the bike is being pedaled
     */
    public void pedal(int pedal_speed) {
        if (run_status == 0) {
            System.out.println("Cannot pedal. Start the bike first.");
        } else {
            System.out.println("Pedaling the bike at speed: " + pedal_speed);
        }
    }
}

/**
 * Main class to test the Vehicle, Car, and Bike classes.
 */
public class Vechilehpoj {

    /**
     * Main method to create instances of Car and Bike and test their functionalities.
     *
     * @param args   the command line arguments
     */
    public static void main(String[] args) {
        Car newCar = new Car("Jaguar XF", 2022, 4);
        newCar.drive(3);
        newCar.stop();
        Bike newBike = new Bike("Giant", 2021, 18);
        newBike.pedal(10);
        newBike.stop();
    }
}
