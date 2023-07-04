package com.amrita.jpl.cys21089.ex;

public class Vehicle {
    boolean run_status = false;
    public void start(){
        System.out.println("[Vehicle] started.");
        run_status = true;
    }

    public void stop() {
        System.out.println("[Vehicle] stopped.");
        run_status = false;
    }
}