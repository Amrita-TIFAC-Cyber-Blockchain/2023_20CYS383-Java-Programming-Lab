package com.ramaguru.amrita.cys.jpl.multithread;

public class MultiThreadSimple extends Thread {

    public void run() {
        try {
            // Code to be executed in the thread
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) {
        // Create two thread objects
        MultiThreadSimple thread1 = new MultiThreadSimple();
        MultiThreadSimple thread2 = new MultiThreadSimple();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
