package com.amrita.jpl.cys21070.ex;

public class Vehicle_Inheritance {
    static class Vehicle{
        boolean running_status;

        public void start(){ //Changes the variable running_status to true
            this.running_status = true;
        }

        public void stop(){ // Changes the variable running_status to false
            this.running_status = false;
            System.out.println("[Vehicle] stopped.");
        }
    }

    static class Car extends Vehicle{
        String Model;
        int Year;
        int Num;

        Car(String x , int y , int z){ // Constructor which also storing the information like Model , Year and number of wheel
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Car Instantiated with Parameter "+x+", "+y+", "+z);
            System.out.println("Cannot drive. Start the car first.");
            start();
        }

        public void gears(int g){ //This function shows the gear number, car is at.
            System.out.println("Driving the car in gear position: "+g);
            stop();
        }
    }

    static class Bike extends Vehicle{
        String Model;
        int Year;
        int Num;
        Bike(String x , int y , int z){ //Constructor which also stores the Model , Year and Number of Gear
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Bike Instantiated with Parameter "+x+", "+y+", "+z);
            System.out.println("Cannot pedal. Start the bike first.");
            start();
        }

        public void pedal(int p){// This function shows no of Pedal bike is at
            System.out.println("Pedaling the bike at speed: "+p);
            stop();
        }
    }

    public static void main(String args[]){
        Car x = new Car("Jaguar XF", 2022, 4);
        //x.gears(3);
        Bike y = new Bike("Giant", 2021, 18);
        //y.pedal(10);

    }
}
