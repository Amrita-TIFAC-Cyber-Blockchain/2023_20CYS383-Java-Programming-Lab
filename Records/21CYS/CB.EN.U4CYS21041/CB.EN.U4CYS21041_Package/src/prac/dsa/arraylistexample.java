package com.amrita.jpl.cys21041.prac.dsa;

import java.util.ArrayList;
import java.util.Iterator;


public class arraylistexample {

    public static void main(String[] args) {
        // Make a collection
        ArrayList<Integer> u21cys = new ArrayList<Integer>();

        u21cys.add(22026);
        u21cys.add(22027);
        u21cys.add(22028);
        u21cys.add(22029);
        u21cys.add(22030);
        // Get the iterator
        Iterator<Integer> it = u21cys.iterator();

        // Print the roll numbers using the iterator
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}

