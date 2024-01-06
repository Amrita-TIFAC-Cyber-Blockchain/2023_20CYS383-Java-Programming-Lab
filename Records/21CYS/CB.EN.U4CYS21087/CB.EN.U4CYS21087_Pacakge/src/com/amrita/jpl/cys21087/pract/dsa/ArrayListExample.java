package com.amrita.jpl.cys21087.pract.dsa;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * - This code has been modified which now has double and integer inputs, previously it had only string input.
 *
 * The ArrayListExample class demonstrates the usage of ArrayList to store and iterate over a collection of student roll numbers.
 * It creates an ArrayList of student roll numbers, adds student roll numbers to it, and uses an Iterator to traverse and print the student roll numbers.
 * This class provides a basic example of working with ArrayList in Java.
 *
 * Usage:
 * - The program creates an ArrayList of strings to represent student roll numbers.
 * - It adds student roll numbers to the ArrayList.
 * - It retrieves an Iterator from the ArrayList to iterate over its elements.
 * - It uses the Iterator to print the student roll numbers one by one.
 *
 * Note: This example uses a simple ArrayList of strings and manually retrieves and prints the elements.
 *
 * Dependencies:
 * - None
 *
 * @author Vishnu
 * @version 1.0
 */
public class ArrayListExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of ArrayList to store and iterate over a collection of student roll numbers.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Make a collection
        ArrayList<String> u21cys = new ArrayList<String>();
        ArrayList<Integer> u21cys2 = new ArrayList<Integer>();
        ArrayList<Double> u21cys3 = new ArrayList<Double>();


        u21cys.add("CB.EN.U4CYS22026");
        u21cys.add("CB.EN.U4CYS22027");
        u21cys.add("CB.EN.U4CYS22028");
        u21cys.add("CB.EN.U4CYS22029");
        u21cys.add("CB.EN.U4CYS22030");

        u21cys2.add(87);
        u21cys2.add(88);

        u21cys3.add(21.23);
        u21cys3.add(23.45);
        // Get the iterator
        Iterator<String> it = u21cys.iterator();

        Iterator<Integer> it2 = u21cys2.iterator();

        Iterator<Double> it3 = u21cys3.iterator();

        // Print the cars using the iterator
        ;
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println(it2.next());
        System.out.println(it2.next());

        System.out.println(it3.next());
        System.out.println(it3.next());

    }
}
