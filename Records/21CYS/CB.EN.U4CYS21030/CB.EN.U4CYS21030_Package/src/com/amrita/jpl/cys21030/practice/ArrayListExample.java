package com.amrita.jpl

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Accessing elements in the ArrayList
        System.out.println("Elements in the ArrayList:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // Removing an element from the ArrayList
        numbers.remove(2); // Removes the element at index 2

        // Updating an element in the ArrayList
        numbers.set(1, 25); // Replaces the element at index 1 with 25

        // Checking if an element exists in the ArrayList
        boolean contains = numbers.contains(40);
        System.out.println("ArrayList contains 40: " + contains);

        // Getting the size of the ArrayList
        int size = numbers.size();
        System.out.println("Size of the ArrayList: " + size);

        // Clearing the ArrayList
        numbers.clear();
        System.out.println("Elements in the ArrayList after clearing:");
        System.out.println(numbers);
    }
}
