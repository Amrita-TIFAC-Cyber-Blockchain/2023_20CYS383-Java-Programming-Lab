
class Vehicle {
    boolean run_status = false;

    void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    String model_name;
    int year;
    int num_wheels;

    Car(String model_name, int year, int num_wheels) {
        this.model_name = model_name;
        this.year = year;
        this.num_wheels = num_wheels;
        System.out.println("Car Instantiated with Parameter " + model_name + ", " + year + ", " + num_wheels);
    }

    void drive(int gear_position) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gear_position);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle {
    String brand_name;
    int year;
    int num_gears;

    Bike(String brand_name, int year, int num_gears) {
        this.brand_name = brand_name;
        this.year = year;
        this.num_gears = num_gears;
        System.out.println("Bike Instantiated with Parameter " + brand_name + ", " + year + ", " + num_gears);
    }

    void pedal(int pedal_speed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedal_speed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class Vehicle2 {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.drive(3);
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.pedal(10);
        bike.stop();
    }
}