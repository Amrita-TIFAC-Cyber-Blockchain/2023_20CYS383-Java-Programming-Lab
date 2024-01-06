package com.amrita.jpl.cys21045.practice.datstructures;
//package com.ramaguru.amrita.cys.jpl.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

/**
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
 * @author Dharmik S
 * @version 0.5
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
        ArrayList<Integer> u21cys = new ArrayList<Integer>();

        u21cys.add(26);
        u21cys.add(27);
        u21cys.add(28);
        u21cys.add(29);
        u21cys.add(30);

        // Get the iterator
        Iterator<Integer> it = u21cys.iterator();

        // Print the roll numbers using the iterator
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        int count = u21cys.size();
        System.out.println("Total number of roll numbers: " + count);

        // Calculate the sum of roll numbers
        int sum = 0;
        for (Integer rollNumber : u21cys) {
            sum += rollNumber;
        }
        System.out.println("Sum of roll numbers: " + sum);

        int x = 0;
        int y = 0;

        // Create a new iterator for calculating the average
        Iterator<Integer> avgIterator = u21cys.iterator();

        while (avgIterator.hasNext()) {
            int rollNumber = avgIterator.next();
            x += rollNumber;
            y++;
        }

        double average = (double) x / y;
        System.out.println("Average of roll numbers: " + average);

    }
}
