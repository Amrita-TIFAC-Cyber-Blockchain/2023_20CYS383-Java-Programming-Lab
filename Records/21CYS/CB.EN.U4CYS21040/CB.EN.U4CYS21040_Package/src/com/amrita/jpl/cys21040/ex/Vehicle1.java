package com.amrita.jpl.cys21040.ex;

/**
 * The class Vehicle contains the main class
 * It has the functions start and stop
 * Start and stop are responsible for modifying
 * the value of run_status*/
public class Vehicle1 {
    public boolean run_status;

    public void start(){
        run_status = true;
        System.out.println("[Vehicle] started");

    }
    public  void stop(){
        run_status = false;
        System.out.println("[Vehicle] stopped");
    }
    public static void main(String[] args) {
        Vehicle1 V = new Vehicle1();

        Car C = new Car("Jaguar XF", 2022, 4 );
        V.start();


        if(V.run_status == true){
            C.drive(3);
        }
        V.stop();
        Bike B = new Bike("Giant", 2021, 18);
        V.start();


        if(V.run_status == true){
            C.drive(10);
        }
        V.stop();
    }

}

/**
 *The following class is the inherited class
 * Car is inherited from Vehicle
 * The Car class has a constructor and a function drive
 * The function drive shows the gear of the car
 * */
class Car extends Vehicle1 {
    Car(String m,int y,int w){
        String Model_name = m;
        int Year = y ;
        int no_of_wheels = w;
        System.out.println("Car Instantiated with Parameter " + Model_name + ", " + Year + ", " + no_of_wheels);
    }
    public void drive(int j){
        int k=j;
        if(run_status == true) {
            System.out.println("Driving the car in gear position: " + k);
        }
    }
}
/**
 *The following class is the inherited class
 * Bike is inherited from Vehicle
 * The Bike class has a constructor and a function pedal
 * The function pedal shows the speed of the bike
 * */
class Bike extends Vehicle1 {
    Bike(String b,int y,int g){
        String Brand_name = b;
        int Year = y;
        int num_of_gears = g;
        System.out.println("Bike Instantiated with Parameter " + Brand_name + ", " + Year + ", " + num_of_gears);
    }
    public void pedal(int k){
        int j = k;

        if(run_status == true) {
            System.out.println("Pedaling the bike at speed: "+j);
        }
    }
}




