package com.amrita.jpl.cys21089.ex;

public class negativeinheritance {
    
    public static void main(String[] args){
        Car myCar = new Car("Jaguar XF", 2022, 4);
        myCar.drive(3);
        myCar.stop();
        Bike myBike = new Bike("Giant", 2021, 18);
        myBike.pedal(10);
        myBike.stop();
    }
}