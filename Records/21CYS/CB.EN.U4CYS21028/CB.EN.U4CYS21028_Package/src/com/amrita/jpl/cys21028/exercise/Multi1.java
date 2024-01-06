package com.amrita.jpl.cys21028.exercise;

class Vehicle12 {
    protected String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
    }
}

class Car12 extends Vehicle12 {
    private int numberOfDoors;

    public void setNumberOfDoors(int doors) {
        numberOfDoors = doors;
    }

    public void displayCar12Info() {
        displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

class Sedan extends Car12 {
    private int seatingCapacity;

    public void setSeatingCapacity(int capacity) {
        seatingCapacity = capacity;
    }

    public void displaySedanInfo() {
        displayCar12Info();
        System.out.println("Seating capacity: " + seatingCapacity);
    }
}

public class Multi1 {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.setBrand("Toyota");
        sedan.setNumberOfDoors(4);
        sedan.setSeatingCapacity(5);
        sedan.displaySedanInfo();
    }
}
