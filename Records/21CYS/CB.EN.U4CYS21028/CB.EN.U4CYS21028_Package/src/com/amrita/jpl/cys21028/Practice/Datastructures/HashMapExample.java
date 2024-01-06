package com.amrita.jpl.cys21028.Practice.Datastructures;

import java.util.HashMap;

/**
 * The HashMapExample class demonstrates the usage of HashMap to store and retrieve roll numbers and names.
 * It creates a HashMap to associate roll numbers with corresponding names.
 * This class provides a basic example of working with HashMap in Java.
 * @author Hitesh
 */
public class HashMapExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of HashMap to store and retrieve roll numbers and names.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a HashMap object called rollName
        HashMap<Integer, Integer> Add = new HashMap<Integer, Integer>();

        Add.put(1, 10);
        Add.put(2, 20);
        Add.put(3, 30);
        Add.put(4, 40);
        Add.put(5, 50);

        // Print the HashMap
        System.out.println("HashMap: " + Add);

        // Add a new key-value pair
        Add.put(6, 60);
        System.out.println("Updated HashMap: " + Add);
    }
}
