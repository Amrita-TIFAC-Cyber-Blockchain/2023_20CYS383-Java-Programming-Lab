package com.amrita.jpl.cys21027.practice.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * The HashMapExample class demonstrates the usage of HashMap to store and retrieve roll numbers and names.
 * It creates a HashMap to associate roll numbers with corresponding names.
 * This class provides a basic example of working with HashMap in Java.
 *
 * Usage:
 * - The program creates a HashMap called CarModelPrice to store car models and their prices.
 * - It adds key-value pairs (car models and prices) to the HashMap using the put() method.
 * - It retrieves the value (price) associated with a specific key (car model) using the get() method.
 * - It prints the retrieved price.
 * - It also prints the entire HashMap.
 *
 * Note: This example uses a HashMap of strings (car models) and integers (prices).
 *
 * Dependencies:
 * - None
 *
 * @author K Sri Sai Nitin
 * @version 0.5
 */
public class HashMapExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of HashMap to store and retrieve car models and prices.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a HashMap object called CarModelPrice
        HashMap<String, Integer> CarModelPrice = new HashMap<String, Integer>();

        // Add keys and values (car models and prices) to the HashMap
        CarModelPrice.put("Lamborghini GT", 6000450);
        CarModelPrice.put("Ferrari GT Sport", 3848450);
        CarModelPrice.put("Honda Civic Sport", 9832450);
        CarModelPrice.put("Skyline GT Nissan", 3400450);
        CarModelPrice.put("Bugatti Veyron", 9342450);

        // Print the entire HashMap
        System.out.println(CarModelPrice.toString());

        // Print the value associated with the key "Skyline GT Nissan"
        System.out.println("Price of Skyline GT Nissan: " + CarModelPrice.get("Skyline GT Nissan"));

    }
}
