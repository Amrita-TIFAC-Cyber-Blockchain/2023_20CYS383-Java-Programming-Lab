package com.amrita.jpl.cys21014.ex;

/**
 * @author Deepthi J
 * @version 1.0
 *
 */

class Vehicle {
    boolean run_status = false;
    public void start(){
        System.out.println("[Vehicle] started.");
        run_status = true;
    }

    public void stop() {
        System.out.println("[Vehicle] stopped.");
        run_status = false;
    }
}

class Car extends Vehicle {
    String model_name;
    int year, wheels_count;
    Car(String name, int yearr, int wheels_countt){
        model_name = name;
        year = yearr;
        wheels_count = wheels_countt;
        System.out.println("Car Instantiated with Parameters: "+ model_name + ", " + year + ", " + wheels_count);
    }

    public void drive(int gear_position){
        if(run_status == false){
            System.out.println("Cannot drive. Please start the car.");
        }
        else{
            System.out.println("Driving the car in gear no.: "+ gear_position);
        }

    }
}

class Bike extends Vehicle {
    String brand_name;
    int year,gears_count;
    Bike(String name, int yearr, int gears_countt){
        brand_name = name;
        year = yearr;
        gears_count = gears_countt;
        System.out.println("Bike Instantiated with Parameters: "+ brand_name + ", " + year + ", " + gears_count);
    }

    public void pedal(int pedal_speed){
        if(run_status == false){
            System.out.println("Cannot pedal. Please start the bike.");
        }
        else{
            System.out.println("Pedaling the bike at speed: "+ pedal_speed);
        }

    }
}

public class q3_vehicle {
    
    public static void main(String[] args){
        Car myCar = new Car("Jaguar XF", 2022, 4);
        myCar.drive(3);
        myCar.stop();
        Bike myBike = new Bike("Giant", 2021, 18);
        myBike.pedal(10);
        myBike.stop();
    }
}