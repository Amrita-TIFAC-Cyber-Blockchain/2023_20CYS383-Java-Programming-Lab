 package com.amrita.jpl.cys21072.hpoj;
/**
 * @author Sri Sai Tanvi Sonti  CB.EN.U4CYS21072
 */

// base class

class Vehicle {
    public boolean run_status;

    public Vehicle() {
        this.run_status = false;
    }

    public void start() {
        if (!run_status) {
            run_status = true;
            System.out.println("[Vehicle] started.");
        } else {
            System.out.println("[Vehicle] didn't start..");
        }
    }

    public void stop() {
        if (run_status) {
            run_status = false;
            System.out.println("[Vehicle] stopped.");
        } else {
            System.out.println("[Vehicle] is moving.");
        }
    }
}

class Car extends Vehicle {
    public String ModelName;
    public int Year;
    public int NumofWheels;

    /**
     *
     * @param ModelName name of the car
     * @param Year year that the car manufactured
     * @param NumofWheels no.of wheels that are available for car
     */

    public Car(String ModelName, int Year, int NumofWheels) {
        this.ModelName = ModelName;
        this.Year = Year;
        this.NumofWheels = NumofWheels;

        System.out.println("Car Instantiated with Parameter: " + ModelName + ", " + Year + ", " + NumofWheels);
    }

    /**
     *
     * @param gearPosition Gearn Number that car is using at that particular time.
     */

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Car is being driven in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Vehicle is not running. Start the vehicle before driving.");
        }
    }
}
class Bike extends Vehicle {
    public String BrandName;
    public int Year;
    public int NumofGears;

    /**
     *
     * @param BrandName Name of the bike
     * @param Year year that the bike manufactured
     * @param NumofGears totals gears available for bike
     */
    public Bike(String BrandName, int Year, int NumofGears) {
        this.BrandName = BrandName;
        this.Year = Year;
        this.NumofGears = NumofGears;

        System.out.println("Car Instantiated with Parameter: " + BrandName + ", " + Year + ", " + NumofGears);

    }

    /**
     *
     * @param pedalSpeed speed number that the bike is using
     */
    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running. Start the vehicle before pedaling.");
        }
    }
}

public class VehicleQ{
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
