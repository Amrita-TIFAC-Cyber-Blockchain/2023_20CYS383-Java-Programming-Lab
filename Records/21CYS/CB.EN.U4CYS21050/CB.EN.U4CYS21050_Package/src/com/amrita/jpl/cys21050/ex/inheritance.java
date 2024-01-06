class Vehicle {
    public  boolean run_status;

    public void start() {
        run_status = false;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    String modelName;
    int year;
    int numberofWheels;

    public Car(String modelName, int year, int numberofWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numberofWheels = numberofWheels;
        System.out.println("Car Instantiated with Parameter "+modelName+", "+year+", "+numberofWheels);
    }
    public void drive(int gearPosition){
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first");
        }
    }
}

class Bike extends Vehicle {
    String brandName;
    int year;
    int numGears;
    public Bike(String brandName, int year,int numGears){
        this.brandName = brandName;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter "+brandName+", "+year+", "+numGears);
    }
    public void pedal(int pedalSp){
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSp);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}
/**
 * @author nishanth
 */
public class inheritance {
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