package com.amrita.jpl.cys21068.prac;

import java.util.Iterator;

public class ArrayList {

    public static void main(String[] args) {
        // Make a collection
        java.util.ArrayList<String> u21cys = new java.util.ArrayList<String>();

        u21cys.add("saran");
        u21cys.add("sara");
        u21cys.add("sana");
        u21cys.add("rushil");
        u21cys.add("tanmay");
        // Get the iterator
        Iterator<String> it = u21cys.iterator();

        // Print the cars using the iterator
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
