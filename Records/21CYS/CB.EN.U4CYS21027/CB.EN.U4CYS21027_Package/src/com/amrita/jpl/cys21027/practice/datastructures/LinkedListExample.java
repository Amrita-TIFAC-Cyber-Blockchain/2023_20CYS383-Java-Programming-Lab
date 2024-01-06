package com.amrita.jpl.cys21027.practice.datastructures;

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
 * @author K Sri Sai Nitin
 * @version 0.5
 */
public class LinkedListExample{
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of LinkedList to store and retrieve elements.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> GradeMarks = new LinkedList<>();


        GradeMarks.add(56);
        GradeMarks.add(89);
        GradeMarks.add(96);
        GradeMarks.add(74);
        GradeMarks.add(45);


        System.out.println("The Marks given to the student are: ");
        System.out.println(GradeMarks);
    }
}