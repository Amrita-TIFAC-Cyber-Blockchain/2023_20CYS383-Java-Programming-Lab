package com.amrita.jpl.cys21064.pract.general;
/**
 * @author Rajendraprasad S
 * @version 0.5
 */
abstract class Vehicle
{
    /**
     * Parent class for the classes Car and Bike
     */
    boolean run_status;

    public void start()
    {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop()
    {
        System.out.println("[Vehicle] stopped.");
        run_status = false;
    }
}

class Car extends Vehicle
{
    /**
     * Child class that inherits from class Vehicle
     */
    Car(String model, int date, int wheels){
        System.out.println("Car Instantiated with Parameter "+model+", " + date+ ", "+wheels);
    }

    public void drive(int pos)
    {
        if(run_status) {
            System.out.println("Driving the car in gear position: " + pos);
        }
        else{
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle
{
    /**
     * Child class that inherits from class Vehicle
     */
    Bike(String brand, int year, int gears){
        System.out.println("Bike Instantiated with Parameter "+brand+", " + year+ ", "+gears);
    }

    public void pedal(int speed)
    {
        if(run_status) {
            System.out.println("Pedaling the bike at speed: " + speed);
        }
        else{
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}
public class hpoj2 {
    public static void main(String[] args) {


        Car cobj2 = new Car("Jaguar XF", 2022, 4 );
        cobj2.start();
        cobj2.drive(3);
        cobj2.stop();
        Bike bobj2 = new Bike("Giant", 2021, 18);
        bobj2.start();
        bobj2.pedal(10);
        bobj2.stop();

        Car cobj = new Car("Jaguar XF", 2022, 4 );

        cobj.drive(3);

        cobj.stop();
        Bike bobj = new Bike("Giant", 2021, 18);

        bobj.pedal(10);
        bobj.stop();
    }
}
