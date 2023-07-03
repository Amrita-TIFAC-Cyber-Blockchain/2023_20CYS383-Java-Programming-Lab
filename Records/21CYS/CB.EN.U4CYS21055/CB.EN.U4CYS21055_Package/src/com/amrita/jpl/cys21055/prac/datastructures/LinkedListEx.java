package com.amrita.jpl.cys21055.prac.datastructures;

import java.util.LinkedList;

/**
 * The LinkedListExample class demonstrates the usage of LinkedList to store and retrieve elements.
 * It creates a LinkedList to store car names.
 * This class provides a basic example of working with LinkedList in Java.
 *
 * Usage:
 * - The program creates a LinkedList called cars to store Constructors.
 * - It adds elements to the LinkedList using the add() method.
 * - It prints the contents of the LinkedList.
 *
 * Note: This example uses a LinkedList of strings to represent Constructors.
 *
 * Dependencies:
 * - None
 *
 * @author Penugonda V S Ganasekhar
 * @version 0.5
 */
public class LinkedListEx {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of LinkedList to store and retrieve elements.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> Constructors = new LinkedList<String>();

        Constructors.add("Mercedes");
        Constructors.add("Mclaren");
        Constructors.add("Alpine");
        Constructors.add("Renault");
        Constructors.add("Red Bull");
        Constructors.add("Aston Martin");

        // Print the contents of the LinkedList
        System.out.println(Constructors);
    }
}
