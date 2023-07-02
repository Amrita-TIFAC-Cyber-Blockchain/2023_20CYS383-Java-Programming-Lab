package com.amrita.jpl.cys21042.exercises;
//package com.ramaguru.amrita.cys.jpl.datastructures;

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
 * @author Mittul R
 * @version 1.0
 */
public class LinkedListExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of LinkedList to store and retrieve elements.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> u21cys = new LinkedList<String>();

        u21cys.add("CB.EN.U4CYS22031");
        u21cys.add("CB.EN.U4CYS22032");
        u21cys.add("CB.EN.U4CYS22033");
        u21cys.add("CB.EN.U4CYS22034");
        u21cys.add("CB.EN.U4CYS22035");

        // Print the contents of the LinkedList
        System.out.println(u21cys);

        String element = u21cys.get(2);
        System.out.println("Element at index 2: " + element);

        u21cys.add(1, "CB.EN.U4CYS22036");

        u21cys.remove("CB.EN.U4CYS22033");

        boolean containsElement = u21cys.contains("CB.EN.U4CYS22035");
        System.out.println("Contains 'CB.EN.U4CYS22035'? " + containsElement);

        int size = u21cys.size();
        System.out.println("Size of the LinkedList: " + size);

        for (String x : u21cys) {
            System.out.println("Element: " + x);
        }




    }
}
