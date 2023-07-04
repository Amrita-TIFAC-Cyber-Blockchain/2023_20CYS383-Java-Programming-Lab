package com.amrita.jpl.cys21089.ex;

public class Car extends Vehicle {
    String model_name;
    int year, wheels_count;
    Car(String name, int yearr, int wheels_countt){
        model_name = name;
        year = yearr;
        wheels_count = wheels_countt;
        System.out.println("Car Instantiated with Parameter "+ model_name + ", " + year + ", " + wheels_count);
    }

    public void drive(int gear_position){
        if(run_status == false){
            System.out.println("Cannot drive. Start the car first.");
        }
        else{
            System.out.println("Driving the car in gear position: "+ gear_position);
        }

    }
}
