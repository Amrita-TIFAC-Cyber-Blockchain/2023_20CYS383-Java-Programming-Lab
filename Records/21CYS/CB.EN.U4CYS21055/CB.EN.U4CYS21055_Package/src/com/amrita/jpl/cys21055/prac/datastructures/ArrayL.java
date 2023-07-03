package com.amrita.jpl.cys21055.prac.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The ArrayListExample class demonstrates the usage of ArrayList to store and iterate over a collection of student names.
 * It creates an ArrayList of names, adds names to it, and uses an Iterator to traverse and print the student names.
 * This class provides a basic example of working with ArrayList in Java.
 *
 * Usage:
 * - The program creates an ArrayList of strings to represent student names.
 * - It adds student names to the ArrayList.
 * - It retrieves an Iterator from the ArrayList to iterate over its elements.
 * - It uses the Iterator to print the student names one by one.
 *
 * Note: This example uses a simple ArrayList of strings and manually retrieves and prints the elements.
 *
 * Dependencies:
 * - None
 *
 * @author Penugonda V S Ganasekhar
 * @version 0.5
 */
public class ArrayL {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of ArrayList to store and iterate over a collection of student names.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Make a collection
        ArrayList<String> Names = new ArrayList<String>();

        Names.add("Max");
        Names.add("Leclerc");
        Names.add("Sainz");
        Names.add("Ocon");
        Names.add("Lando");
        // Get the iterator
        Iterator<String> it = Names.iterator();

        // Print the cars using the iterator
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}

