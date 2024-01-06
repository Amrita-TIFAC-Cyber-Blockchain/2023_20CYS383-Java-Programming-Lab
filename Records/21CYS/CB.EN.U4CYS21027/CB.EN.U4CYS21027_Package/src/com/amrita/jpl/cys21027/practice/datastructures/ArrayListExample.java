package com.amrita.jpl.cys21027.practice.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


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
 * @author Karaka Sri Sai Nitin
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
        ArrayList<String> Rollno = new ArrayList<>();

        Rollno.add("Welcome");
        Rollno.add("CB.EN.U4CYS21027");
        Rollno.add("CB.EN.U4CYS21098");
        Rollno.add("CB.EN.U4CYS21099");
        Rollno.add("CB.EN.U4CYS21088");


        Iterator<String> iterator = Rollno.iterator();
        System.out.println("The output of ArrayList: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
