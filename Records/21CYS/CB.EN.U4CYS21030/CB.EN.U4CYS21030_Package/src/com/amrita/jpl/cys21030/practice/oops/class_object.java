package com.amrita.jpl.cys21030.practice.oops;
class Car {
    String brand;
    String color;

    void drive() {
        System.out.println("Driving the " + color + " " + brand + " car.");
    }
}

public class class_object {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "Toyota";
        myCar.color = "Red";
        myCar.drive();
    }
}
