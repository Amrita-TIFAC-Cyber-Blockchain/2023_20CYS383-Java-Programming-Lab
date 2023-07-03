package com.amrita.jpl.cys21074.ex;
/**
 * @author Sudhir.R.T
 */
class Vehicle{
    /**
     * Vehicle Main class
     */
    protected boolean run_status;
    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }
    public void stop(){
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }

}
class Car extends Vehicle{
    private String modelName;
    private int year;
    private int numOfWheels;

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numOfWheels);
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        }
    }
}

class Bike extends Vehicle{
    private String BrandName;
    private int year;
    private int numOfGears;

    public Bike(String BrandName, int year, int numOfGears) {
        this.BrandName = BrandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + BrandName + ", " + year + ", " + numOfGears);
    }
    public void pedal(int pedalSpeed){
        if(run_status){
            System.out.println("Pedaling the bike at speed: "+ pedalSpeed);
        }
    }
}

public class Inherit_vehicle{
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();
        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}