package com.amrita.jpl.cys21009.ex;

/**
 * A simple implementation of inheritance concept
 *
 * @author Aravind
 * @version 1
 */
class Vehicle {
    boolean run_status;
    public void start(){
        System.out.println("[Vehicle] started.");
        run_status=true;
    }
    public void stop(){
        System.out.println("[Vehicle] stopped.");
        run_status=false;
    }

}

class Car extends Vehicle{
    Car(String a,int b,int c){
        String model_name=a;
        int year=b;
        int num_of_wheels=c;

        /**
         * @param a stores the model name of the car
         * @param b stores the year of the car
         * @param c stores the number of wheels in the car
         */
    }

    void drive(int gear_pos){

        System.out.println("Driving the car in gear position: "+gear_pos);

        /**
         * @param gear_pos stores the gear position of the car
         */
    }


}


class Bike extends Vehicle{
    Bike(String a,int b,int c){
        String Brand_name=a;
        int year=b;
        int num_of_gears=c;
        /**
         * @param a stores the brand name of the bike
         * @param b stores the year of the bike
         * @param c stores the number of gears in the bike
         */
    }

    void pedal(int pedal_speed){
        System.out.println("Pedaling the bike at speed: "+pedal_speed);
        /**
         * @param pedal_speed stores the speed of the bike
         */
    }
}

public class pgm_inheritance{
    public static void main(String[] args){
        Bike obj2=new Bike("Giant",2021,18);
        Car obj1=new Car("Jaguar XF",2022,4);
        System.out.println("Car Instantiated with Parameter Jaguar XF, 2022, 4");

        obj1.start();
        obj1.drive(3);
        obj1.stop();

        System.out.println("Bike Instantiated with Parameter Giant, 2021, 18");

        obj2.start();
        obj2.pedal(10);
        obj2.stop();
        /**
         * @param obj1 object of class car
         * @param obj2 object of class bike
         */
    }
}