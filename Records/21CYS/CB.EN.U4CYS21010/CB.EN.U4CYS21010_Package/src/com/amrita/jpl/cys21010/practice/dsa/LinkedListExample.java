package com.amrita.jpl.cys21010.practice.dsa;

import java.util.LinkedList;

public class LinkedListExample {
    /**
     *crates a linked list and add values to it
     * and print out the liked list
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> u21cys = new LinkedList();

        for (int i =0;i<10;i++){
            u21cys.add(i);
        }
        // Print the contents of the LinkedList
        System.out.println(u21cys.get(0));
        System.out.println(u21cys);
    }
}
