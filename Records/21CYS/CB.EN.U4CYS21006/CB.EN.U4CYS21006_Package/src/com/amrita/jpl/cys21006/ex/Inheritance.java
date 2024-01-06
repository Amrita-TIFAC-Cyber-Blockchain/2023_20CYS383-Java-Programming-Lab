
class Vehicle {
    protected boolean run_status;

    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    private String model;
    private int year;
    private int numWheels;

    public Car(String model, int year, int numWheels) {
        this.model = model;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

class Bike extends Vehicle {
    private String brand;
    private int year;
    private int numGears;

    public Bike(String brand, int year, int numGears) {
        this.brand = brand;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

public class Inheritance {
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
