package com.amrita.jpl.cys21022.ex;

class Vehicle{
    String run_status;

    void start(){
        System.out.println("[Vehicle] started.");
    }

    void stop(){
        System.out.println("[Vehicle] stopped.");
    }
}

class car extends Vehicle{

    String Model_Name;
    int Year;
    int Num_of_Wheels;
    int gear_position;

    car(String Model_Name,int Year,int Num_of_Wheels){
        this.Model_Name = Model_Name;
        this.Year = Year;
        this.Num_of_Wheels = Num_of_Wheels;

        System.out.println("Car Instantiated with Parameter " + Model_Name + ", " + Year + ", " + Num_of_Wheels);
    }

    void drive(int gear_position){
        this.gear_position = gear_position;
        System.out.println("Driving the car in gear position: " + gear_position);
    }

}

class bike extends Vehicle{

    String Brand_Name;
    int Year;
    int Num_of_Gears;
    int pedal_speed;

    bike(String Brand_Name,int Year,int Num_of_Gears){
        this.Brand_Name = Brand_Name;
        this.Year = Year;
        this.Num_of_Gears = Num_of_Gears;

        System.out.println("Bike Instantiated with Parameter " + Brand_Name + ", " + Year + ", " + Num_of_Gears);

    }

    void pedal(int pedal_speed){
        this.pedal_speed = pedal_speed;
        System.out.println("Pedaling the bike at speed: " + pedal_speed);

    }

}

public class test{
    public static void main(String args[]){

        car c = new car("Jaguar XF", 2022, 4);
        Vehicle v = new Vehicle();
        v.start();
        c.drive(3);
        v.stop();
        bike b = new bike("Giant", 2021, 18);
        v.start();
        b.pedal(10);
        v.stop();



        System.out.println();
    }
}
