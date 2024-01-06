package com.amrita.jpl.cys21055.prac.datastructures;

import java.util.HashMap;

/**
 * The HashMapExample class demonstrates the usage of HashMap to store and retrieve Drivers and Constructors.
 * It creates a HashMap to associate Drivers with corresponding Constructors.
 * This class provides a basic example of working with HashMap in Java.
 *
 * Usage:
 * - The program creates a HashMap called DriCon to store Drivers and Constructors.
 * - It adds key-value pairs (roll numbers and names) to the HashMap using the put() method.
 * - It retrieves the value (name) associated with a specific key (roll number) using the get() method.
 * - It prints the retrieved name.
 *
 * Note: This example uses a HashMap of strings to represent Drivers and Constructors.
 *
 * Dependencies:
 * - None
 *
 * @author Penugonda V S Ganasekhar
 * @version 0.5
 */
public class HashMapEx {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of HashMap to store and retrieve Drivers and Constructors.
     * It demonstrates the usage of HashMap to store and retrieve Drivers and Constructors.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a HashMap object called DriCon
        HashMap<String, String> DriCon = new HashMap<String, String>();

        // Add keys and values (roll numbers and names) to the HashMap
        DriCon.put("Hamilton", "Mercedes");
        DriCon.put("Max", "Red Bull");
        DriCon.put("Lando", "Mclaren");
        DriCon.put("Ocon", "Renault");
        DriCon.put("Gasly", "Alphine");
        DriCon.put("Sainz", "Ferrari");

        // Retrieve and print the name associated with a specific Driver
        System.out.println(DriCon.get("Ocon"));
    }
}
