package com.amrita.jpl.cys21010.exercise;

/**
 * @author arjun
 *
 */

/**
 * the main class
 */
public class JavaInheritance {
    /**
     * main funtion wher the object are created for the class Bike and Car
     * @param args
     */
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF",2022,4);
        car.start();
        car.drive(3);
        car.stop();
        Bike bike = new Bike("Parameter Giant",2021,18);
        bike.start();
        bike.drive(10);
        bike.stop();
    }


}

/**
 * the Base class Vehicle
 */
class Vehicle{
    public boolean run_status;
    void start(){
        run_status = true;
        System.out.println("[Vehicle] started.");
    }
    void stop(){
        run_status = false;
        System.out.println("[Vehicle] stopped.");

    }


}

/**
 * Class Bike inherits  class Vehicle
 */
class Bike extends  Vehicle{
    private String BrandName;
    private int Year;
    private int NumofGears;

    /***
     * Contractor for the class Bike
     * @param BrandName
     * @param Year
     * @param NumofGears
     */
    public  Bike(String BrandName, int Year, int NumofGears){
        this.BrandName = BrandName;
        this.Year = Year;
        this.NumofGears = NumofGears;
        System.out.println("Bike Instantiated with Parameter "+BrandName+", "+Year+", "+NumofGears);
    }

    /***
     * drive funtion to which  will drive the bike if it is started
     * @param pedal
     */
    public void drive(int pedal){
        if (this.run_status) {
            System.out.println("Pedaling the bike at speed: "+pedal);
        }
        else{
            System.out.println("Cannot pedal. Start the bike first.");
        }

    }

}

/**
 * Class Car inherits  class Vehicle
 */
class Car extends Vehicle{
    private String ModelName;
    private int Year;
    private int NumofWheels;

    /**
     * Constractor of Car class
     * @param ModelName
     * @param Year
     * @param NumofWheels
     */
    public  Car(String ModelName,int Year,int NumofWheels){
        this.ModelName = ModelName;
        this.Year = Year;
        this.NumofWheels = NumofWheels;
        System.out.println("Car Instantiated with Parameter "+ModelName+", "+Year+", "+NumofWheels);

    }

    /**
     * drive funtion to which  will drive the car if it is started
     * @param gear
     */
    public void drive(int gear){
        if (this.run_status) {
            System.out.println("Driving the car in gear position: " + gear);
        }
        else{
            System.out.println("Cannot drive. Start the car first.");
        }
    }

}