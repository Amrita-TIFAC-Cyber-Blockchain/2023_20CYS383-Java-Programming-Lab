package com.amrita.jpl.cys21067.practice.datstructures;
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
 * @author Dharmik S
 * @version 0.5
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
        rollName.put("CB.EN.U4CYS21011", "A S Deepan");
        rollName.put("CB.EN.U4CYS21021", "Gundala Kushal Bhavani Reddy");
        rollName.put("CB.EN.U4CYS21031", "Kishanth K");
        rollName.put("CB.EN.U4CYS21041", "Middivari Charan Kumar Reddy");
        rollName.put("CB.EN.U4CYS21051", "Nithin S");
        rollName.put("CB.EN.U4CYS21061", "Roshni V");
        rollName.put("CB.EN.U4CYS21071", "Sourabh Sasikanthan");
        rollName.put("CB.EN.U4CYS21081", "Koti Venkatadinesh Reddy");

        // Retrieve and print the name associated with a specific roll number
        System.out.println(rollName.get("CB.EN.U4CYS21011"));

        rollName.put("CB.EN.U4CYS21091", "Scoob");

        rollName.remove("CB.EN.U4CYS21061");

        boolean containsRollNumber = rollName.containsKey("CB.EN.U4CYS21041");
        System.out.println("Contains roll number: " + containsRollNumber);

        boolean containsName = rollName.containsValue("Nithin S");
        System.out.println("Contains name: " + containsName);

        rollName.put("CB.EN.U4CYS21031", "Shaggy");

        Iterator<Map.Entry<String, String>> iterator = rollName.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String rollNumber = entry.getKey();
            String name = entry.getValue();
            System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
        }



    }
}
