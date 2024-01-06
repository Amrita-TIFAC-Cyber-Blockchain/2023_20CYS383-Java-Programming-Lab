package com.amrita.jpl.cys21075.ex;

public class Car_Inheritance {
    static class Vehicle {
        boolean running_status;

        public void start() {
            this.running_status = true;
            System.out.println("[Vehicle] started.");
        }

        public void stop() {
            this.running_status = false;
            System.out.println("[Vehicle] stopped.");
        }
    }

    static class Car extends Vehicle {
        String Model;
        int Year;
        int Num;

        Car(String x, int y, int z) {
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Car Instantiated with Parameter " + x + ", " + y + ", " + z);
            start();
        }

        public void gears(int g) {
            System.out.println("Driving the car in gear position: " + g);
            stop();
        }
    }

    static class Bike extends Vehicle {
        String Model;
        int Year;
        int Num;

        Bike(String x, int y, int z) {
            this.Model = x;
            this.Year = y;
            this.Num = z;
            System.out.println("Bike Instantiated with Parameter " + x + ", " + y + ", " + z);
            start();
        }

        public void pedal(int p) {
            System.out.println("Pedaling the bike at speed: " + p);
            stop();
        }
    }

    public static void main(String args[]) {
        Car x = new Car("Jaguar XF", 2022, 4);
        x.gears(3);
        Bike y = new Bike("Giant", 2021, 18);
        y.pedal(10);

    }
}
