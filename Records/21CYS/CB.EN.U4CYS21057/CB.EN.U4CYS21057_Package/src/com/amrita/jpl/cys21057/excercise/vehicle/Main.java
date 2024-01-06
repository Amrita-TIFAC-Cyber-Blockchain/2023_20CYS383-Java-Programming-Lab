package com.amrita.jpl.cys21057.excercise.vehicle;

/**
 * This a program based on inheritance
 *
 * Author - Pushpanth
 * Version - 0.1
 */

class Vehicle{

    boolean run_status;

    public void start(){
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop(){
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle{

    String name;
    int year;
    int wheels;

    public void drive(int gear){
        System.out.println("Driving the car in gear position: "+gear);
    }

    Car(String name, int year, int wheels){

        this.name = name;
        this.year = year;
        this.wheels = wheels;
    }
}

class Bike extends Vehicle{

    String name;
    int year;
    int gear;

    public void pedal(int speed){
        System.out.println("Pedaling the bike at speed: "+speed);
    }

    Bike(String name, int year, int gear){

        this.name = name;
        this.year = year;
        this.gear = gear;
    }
}


public class Main{

    public static void main(String[] args){

        Car obj1 = new Car("Jaguar XF", 2022, 4);
        Bike obj2 = new Bike("Giant", 2021, 18);


        System.out.println("Car Instantiated with Parameter Jaguar XF, 2022, 4");
        obj1.start();
        obj1.drive(3);
        obj1.stop();

        System.out.println("Bike Instantiated with Parameter Giant, 2021, 18");
        obj2.start();
        obj2.pedal(10);
        obj2.stop();

    }
}
