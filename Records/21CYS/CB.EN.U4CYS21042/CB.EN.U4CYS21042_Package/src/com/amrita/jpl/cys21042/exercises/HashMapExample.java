package com.amrita.jpl.cys21042.exercises;
//package com.ramaguru.amrita.cys.jpl.datastructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
 * @author Mittul R
 * @version 1.1
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
        rollName.put("CB.EN.U4CYS21041", "Charan");
        rollName.put("CB.EN.U4CYS21043", "Jasir");
        rollName.put("CB.EN.U4CYS21045", "Monish T");
        rollName.put("CB.EN.U4CYS21049", "Nishant V");
        rollName.put("CB.EN.U4CYS21050", "Nishanth S");
        rollName.put("CB.EN.U4CYS21051", "Nithin S");
        rollName.put("CB.EN.U4CYS21058", "Siddharth Krishna");
        rollName.put("CB.EN.U4CYS21060", "Ram Surya");
        rollName.put("CB.EN.U4CYS21063", "Adwaith S");

        // Retrieve and print the name associated with a specific roll number
        System.out.println(rollName.get("CB.EN.U4CYS21045"));

        rollName.put("CB.EN.U4CYS21032", "Kishore");

        rollName.remove("CB.EN.U4CYS21058");

        boolean containsRollNumber = rollName.containsKey("CB.EN.U4CYS21051");
        System.out.println("Contains roll number: " + containsRollNumber);

        boolean containsName = rollName.containsValue("Nithin S");
        System.out.println("Contains name: " + containsName);

        rollName.put("CB.EN.U4CYS21049", "Nish");

        Iterator<Map.Entry<String, String>> iterator = rollName.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String rollNumber = entry.getKey();
            String name = entry.getValue();
            System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
        }



    }
}
