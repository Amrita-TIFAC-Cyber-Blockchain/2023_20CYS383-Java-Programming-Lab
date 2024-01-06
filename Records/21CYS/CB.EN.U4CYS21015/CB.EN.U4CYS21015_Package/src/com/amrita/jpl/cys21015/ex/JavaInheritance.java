package com.amrita.jpl.cys21015.ex;

import java.util.Scanner;

class Vehicle
{
    boolean run_status;

    void start()
    {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    void stop()
    {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle
{
    String model_name;
    int year;
    int wheels;
    int gear;
    int gear_pos;
    public Car(String model_name, int year, int wheels)
    {
        this.model_name = model_name;
        this.year = year;
        this.wheels = wheels;
        System.out.println("Car Instantiated with Parameter " + model_name + ", " + year + ", " + wheels);
    }

    void drive(int gear_pos)
    {
        if (run_status) {
            this.gear_pos = gear_pos;
            System.out.println("Driving the car in gear position: " + gear_pos);
        }

        else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle
{
    String model_name;
    int year;
    int gears;
    int speed;
    public Bike(String model_name, int year, int gears)
    {
        this.model_name = model_name;
        this.year = year;
        this.gears = gears;
        System.out.println("Bike Instantiated with Parameter " + model_name + ", " + year + ", " + gears);
    }

    void pedal(int speed)
    {
        if(run_status)
        {
            this.speed = speed;
            System.out.println("Pedaling the bike at speed: " + this.speed);
        }
        else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class JavaInheritance
{
    public static void main(String[] args)
    {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.stop();
    }
}

