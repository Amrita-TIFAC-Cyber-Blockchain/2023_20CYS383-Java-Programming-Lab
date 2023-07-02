package com.amrita.jpl.cys21040.pract.dsa;

import java.util.LinkedList;

/**
 * The LinkedListExample class demonstrates the usage of LinkedList to store and retrieve elements.
 * It creates a LinkedList to store car names.
 * This class provides a basic example of working with LinkedList in Java.
 *
 * Usage:
 * - The program creates a LinkedList called cars to store student roll numbers.
 * - It adds elements to the LinkedList using the add() method.
 * - It prints the contents of the LinkedList.
 *
 * Note: This example uses a LinkedList of strings to represent student roll numbers.
 *
 * Dependencies:
 * - None
 *
 * @author G Manomithran
 * @version 0.5
 */
public class LinkedListExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of LinkedList to store and retrieve elements.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Float> u21cys = new LinkedList<Float>();

        u21cys.add(31F);
        u21cys.add(36F);
        u21cys.add(50F);
        u21cys.add(31F);
        u21cys.add(300.3F);

        // Print the contents of the LinkedList
        System.out.println(u21cys);
    }
}
