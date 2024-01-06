package com.amrita.jpl.cys21030.practice.dsa;
import java.util.ArrayList;

public class EngineeringBranchesExample {
    public static void main(String[] args) {
        // Create an ArrayList to store engineering branch names
        ArrayList<String> engineeringBranches = new ArrayList<>();

        // Add branch names to the ArrayList
        engineeringBranches.add("Civil Engineering");
        engineeringBranches.add("Mechanical Engineering");
        engineeringBranches.add("Electrical Engineering");
        engineeringBranches.add("Computer Science Engineering");
        engineeringBranches.add("Chemical Engineering");

        // Display the engineering branch names
        System.out.println("Engineering Branches:");
        for (String branch : engineeringBranches) {
            System.out.println(branch);
        }

        // Check if a specific branch exists in the ArrayList
        String targetBranch = "Mechanical Engineering";
        if (engineeringBranches.contains(targetBranch)) {
            System.out.println(targetBranch + " is found in the list.");
        } else {
            System.out.println(targetBranch + " is not found in the list.");
        }

        // Remove a branch from the ArrayList
        String branchToRemove = "Chemical Engineering";
        engineeringBranches.remove(branchToRemove);

        // Display the updated engineering branch names
        System.out.println("\nUpdated Engineering Branches:");
        for (String branch : engineeringBranches) {
            System.out.println(branch);
        }

        // Get the size of the ArrayList
        int size = engineeringBranches.size();
        System.out.println("\nTotal number of branches: " + size);
    }
}
