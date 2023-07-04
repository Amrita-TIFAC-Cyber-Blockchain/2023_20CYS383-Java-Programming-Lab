package com.amrita.jpl.cys21089.ex;

public class Bike extends Vehicle {
    String brand_name;
    int year,gears_count;
    Bike(String name, int yearr, int gears_countt){
        brand_name = name;
        year = yearr;
        gears_count = gears_countt;
        System.out.println("Bike Instantiated with Parameter "+ brand_name + ", " + year + ", " + gears_count);
    }

    public void pedal(int pedal_speed){
        if(run_status == false){
            System.out.println("Cannot pedal. Start the bike first.");
        }
        else{
            System.out.println("Pedaling the bike at speed: "+ pedal_speed);
        }

    }
}
