package com.amrita.jpl.cys21010.practice.dsa;

import java.util.HashMap;

public class HashMapExample {
    /**
     * creates  a hashmap and add values and keys to it
     * and updates value of a key
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a HashMap object called rollName
        HashMap<String, Integer> rollName = new HashMap();


        // Retrieve and print the name associated with a specific roll number
        System.out.println(rollName.get(rollName));
        rollName.put("arjun",10);
        rollName.put("madhave",38);
        System.out.println(rollName);
        rollName.put("test",null);
        System.out.println(rollName.get("test"));
        rollName.put("arjun",45);
        System.out.println(rollName);
    }
}
