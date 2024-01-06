package com.amrita.jpl.cys21016.ex;
/**
 * Inheritence Practice program - HPOJ
 * @author G H Hem Sagar
 * @version 1.0
 * */
class Vehicle2{
    /**
     * The Vehicle2 is the base class used to implement inheritence.
     * It has a private variable run_status.
     * */
    boolean run_status;
    public void start(){
        /*
        * It is a start function that set's the variable run_status = true.
        */
        run_status = true;
        System.out.println(" [Vehicle] started.");
    }
    public void stop(){
        /*
         * It is a start function that set's the variable run_status = true.
         */
        run_status = false;
        System.out.println(" [Vehicle] stopped.");
    }
};

class Car2 extends Vehicle2{
    /**
     * The car2 class inherits from the Vehicle2 class and has it's own method drive*/
    String modelName;
    int year;
    int noOfWheels;
    public Car2(String a, int y, int n){
        /**
         * It is a parameterized constructor for the Car class that takes the following parameters
         * @param a -> a local variable that gets the Car model name.
         * @param y -> a local variable that gets the year of the car model.
         * @param n -> a local variable that gets the no. of wheels in the car.*/
        modelName = a;
        year = y;
        noOfWheels = n;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + noOfWheels);
    }
    public void drive(int gearPos){
        /**
        * It prints at which gear position that the Car is running if the run_status is true i.e(Car is running)
        * @param gearPos -> gets the gear position of the Car. */
        if(!run_status){
            System.out.println("Cannot drive. Start the car first.");
            return;
        }
        System.out.println("Driving the car in gear position: "+gearPos);
    }
};
class Bike2 extends Vehicle2{
    /**
     * The Bike2 class inherits from the Vehicle2 class and has it's own method pedal*/
    String brandName;
    int year;
    int noOfGears;
    public Bike2(String b, int y, int g){
        /**
         * It is a parameterized constructor for the Bike class that takes the following parameters
         * @param b -> a local variable that gets the Bike model name.
         * @param y -> a local variable that gets the year of the Bike model.
         * @param g -> a local variable that gets the no. of gears in the car.
         * */
        brandName = b;
        year = y;
        noOfGears = g;
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + noOfGears);
    }
    public void pedal(int pedalSpeed){
        /**
         * It prints at which pedal Speed that the Bike is running if the run_status is true i.e(Bike is running)
         * @param pedalSpeed -> gets the pedal Speed of the Car. */
        if(!run_status){
            System.out.println("Cannot drive. Start the bike first.");
            return;
        }
        System.out.println("Pedaling the bike at speed: "+ pedalSpeed);
    }
};

public class VInheritence2{
    public static void main(String[] args){
        /**
         * It is the main function that instantiates the Car and Bike classes and performs required operations.
         * @param args -> Commandline arguments
         * */
        Car2 c1 = new Car2("Jaguar XF",2022,4);
        //c1.start();
        c1.drive(3);
        c1.stop();
        Bike2 b1 = new Bike2("Giant",2021,18);
        //b1.start();
        b1.pedal(10);
        b1.stop();
    }
}

