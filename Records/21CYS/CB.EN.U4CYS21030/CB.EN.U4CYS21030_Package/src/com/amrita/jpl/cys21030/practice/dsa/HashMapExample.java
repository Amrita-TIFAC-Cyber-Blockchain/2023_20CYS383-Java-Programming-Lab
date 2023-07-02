package com.amrita.jpl.cys21030.practice.dsa;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap to store faculty names and their corresponding IDs
        HashMap<String, Integer> facultyIDs = new HashMap<>();

        // Add faculty names and IDs to the HashMap
        facultyIDs.put("Amrita mam", 101);
        facultyIDs.put("Ramaguru sir ", 102);
        facultyIDs.put("SethuMadhava Sir", 103);
        facultyIDs.put("Aanand sir", 104);
        facultyIDs.put("Amith sir", 105);

        // Display the faculty names and IDs
        System.out.println("Faculty IDs:");
        for (Map.Entry<String, Integer> entry : facultyIDs.entrySet()) {
            String facultyName = entry.getKey();
            int facultyID = entry.getValue();
            System.out.println(facultyName + ": " + facultyID);
        }

        // Check if a specific faculty exists in the HashMap
        String targetFaculty = "Jane Smith";
        if (facultyIDs.containsKey(targetFaculty)) {
            int facultyID = facultyIDs.get(targetFaculty);
            System.out.println(targetFaculty + "'s ID is " + facultyID);
        } else {
            System.out.println(targetFaculty + " is not found in the HashMap.");
        }

        // Remove a faculty from the HashMap
        String facultyToRemove = "Amrita mam";
        facultyIDs.remove(facultyToRemove);

        // Display the updated faculty names and IDs
        System.out.println("\nUpdated Faculty IDs:");
        for (Map.Entry<String, Integer> entry : facultyIDs.entrySet()) {
            String facultyName = entry.getKey();
            int facultyID = entry.getValue();
            System.out.println(facultyName + ": " + facultyID);
        }

        // Get the size of the HashMap
        int size = facultyIDs.size();
        System.out.println("\nTotal number of faculty: " + size);
    }
}
