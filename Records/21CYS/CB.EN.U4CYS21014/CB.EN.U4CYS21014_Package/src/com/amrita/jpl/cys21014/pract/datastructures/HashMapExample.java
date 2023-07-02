package com.amrita.jpl.cys21014.pract.datastructures;

import java.util.HashMap;

/**
 * The HashMapExample class demonstrates the usage of HashMap to store and retrieve roll numbers and names.
 * It creates a HashMap to associate roll numbers with corresponding names.
 * This class provides a basic example of working with HashMap in Java.
 *
 * Usage:
 * - The program creates a HashMap called rollName to store roll numbers and names.
 * - It adds key-value pairs (roll numbers and names) to the HashMap using the put() method.
 * - It retrieves the value (name) associated with a specific key (roll number) using the get() method.
 * - It prints the retrieved name.
 *
 * Note: This example uses a HashMap of strings to represent roll numbers and names.
 *
 * Dependencies:
 * - None
 *
 * @author Deepthi J
 * @version 1.0
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
        HashMap<String, String> rollName = new HashMap<String, String>();

        // Add keys and values (roll numbers and names) to the HashMap
        rollName.put("CB.EN.U4CYS21001", "Abinesh G");
        rollName.put("CB.EN.U4CYS21014", "Deepthi J");
        rollName.put("CB.EN.U4CYS21021", "Gundala Kushal Bhavani Reddy");
        rollName.put("CB.EN.U4CYS21031", "Kishanth K");
        rollName.put("CB.EN.U4CYS21041", "Middivari Charan Kumar Reddy");


        // Retrieve and print the name associated with a specific roll number
        System.out.println("Roll No: CB.EN.U4CYS21014");

        System.out.println("Name: "+rollName.get("CB.EN.U4CYS21014"));



        HashMap<String, Double> rollName_mark = new HashMap<String, Double>();

        // Add keys and values (roll numbers and names) to the HashMap
        rollName_mark.put("CB.EN.U4CYS21001", 5.0);
        rollName_mark.put("CB.EN.U4CYS21014", 8.63);
        rollName_mark.put("CB.EN.U4CYS21021", 7.0);
        rollName_mark.put("CB.EN.U4CYS21031", 8.0);
        rollName_mark.put("CB.EN.U4CYS21041", 9.0);

        // Retrieve and print the name associated with a specific roll number
        System.out.println("CGPA: "+rollName_mark.get("CB.EN.U4CYS21014"));

        // Create a HashMap object called rollName
        HashMap<String, String> tabletsheet = new HashMap<String, String>();

        // Add keys and values (tabletsheet hash numbers and manufactured date) to the HashMap
        tabletsheet.put("CB.EN.U4CYS21014", "12-12-2003" );
        tabletsheet.put("iuewiucinjnjs", "13-12-2003");
        tabletsheet.put("eikjcniasuksh", "14-12-2003" );
        tabletsheet.put("eisdjcdoijowo", "15-12-2003");
        tabletsheet.put("qpwoxcozioeiw", "16-12-2003");


        // Retrieve and print the name associated with a specific roll number
        System.out.println("DOB: "+ tabletsheet.get("CB.EN.U4CYS21014"));
    }
}
