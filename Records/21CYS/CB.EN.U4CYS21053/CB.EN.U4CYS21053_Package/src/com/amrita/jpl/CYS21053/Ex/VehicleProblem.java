/**
 * @author Nived Dineshan
 */


package com.amrita.jpl.CYS21053.Ex;

class Vehicle{

        int run_status=0;
        /**
         * start function
         * prints the vehicle started
         */
        public void start(){
            run_status=1;
            System.out.println("[Vehicle] started.");
        }
        /**
         * stop function
         * prints the vehicle stopped
         */
        public void stop(){
            run_status=0;
            System.out.println("[Vehicle] stopped.");
        }

    }


    class Car extends Vehicle{
        /**
         * Car constructor
         * @param String model_name,int Year,int no_of_wheels->info related to the car
         */

        public Car(String model_name,int Year,int no_of_wheels){
            System.out.println("Car Instantiated with Parameter "+model_name+", "+ Year+", " +no_of_wheels);
        }

        /**
         * drive function
         * @param int gear_position
         */

        public void drive(int gear_position){
            if (run_status==0){
                System.out.println("Cannot drive. Start the car first.");
            }
            else{
                System.out.println("Driving the car in gear position: "+gear_position);
            }
        }
    }

    class Bike extends Vehicle{
        /**
         * Bike constructor
         * @param String brand_name,int Year,int no_of_gears
         */

        public Bike(String brand_name,int Year,int no_of_gears){
            System.out.println("Bike  Instantiated with Parameter "+brand_name+", "+ Year+", " +no_of_gears);
        }

        /**
         * pedal function
         * @param int pedal_speed
         */
        public void pedal(int pedal_speed){
            if (run_status==0){
                System.out.println("Cannot pedal. Start the bike first.");
            }
            else{
                System.out.println("Pedaling the bike at speed: "+pedal_speed);
            }
        }

    }

    public class VehicleProblem{
        public static void main(String[] args) {
            Car newCar= new Car("Jaguar XF", 2022, 4);
            newCar.drive(3);
            newCar.stop();
            Bike newBike= new Bike("Giant", 2021, 18);
            newBike.pedal(10);
            newBike.stop();

        }
    }