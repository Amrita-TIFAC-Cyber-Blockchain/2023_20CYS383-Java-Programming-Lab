package com.amrita.jpl.cys21004.exerscise;

/**
 * @author Aishwarya GS
 */
class Vehicle {

    protected boolean run_status;
    public void start() {

        this.run_status = true;
        System.out.println("[Vehicle] started.");

    }
    public void stop() {

        this.run_status = false;
        System.out.println("[Vehicle] stopped.");

    }

}

class Car extends Vehicle {

    private String model_name;
    private int year;
    private int num_wheels;


    public Car(String model_name, int year, int num_wheels) {

        this.model_name = model_name;
        this.year = year;
        this.num_wheels = num_wheels;
        this.run_status = false;

    }



    public void drive(int gear_position) {
        System.out.println("Driving the car in gear position: " + gear_position);
    }

}


class Bike extends Vehicle {

    private String brand_name;
    private int year;
    private int num_gears;

    public Bike(String brand_name, int year, int num_gears) {

        this.brand_name = brand_name;
        this.year = year;
        this.num_gears = num_gears;
        this.run_status = false;

    }

    public void pedal(int pedal_speed) {
        System.out.println("Pedaling the bike at speed: " + pedal_speed);
    }

}

public class VehicleInheritance {

    /**
     * Inheritance with the example of car and bike
     * @param args default argument
     */

    public static void main(String[] args) {

        Car car = new Car("Jaguar XF", 2022, 4);
        Bike bike = new Bike("Giant", 2021, 18);

        System.out.println("Car Instantiated with Parameter Jaguar XF, 2022, 4");
        car.start();
        car.drive(3);
        car.stop();

        System.out.println("Bike Instantiated with Parameter Giant, 2021, 18");
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}
