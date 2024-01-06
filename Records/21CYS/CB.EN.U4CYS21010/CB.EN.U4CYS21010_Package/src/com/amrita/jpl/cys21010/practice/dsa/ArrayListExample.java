package com.amrita.jpl.cys21010.practice.dsa;

import java.util.ArrayList;


public class ArrayListExample {
    /**
     * add numbers to a Array
     * @param args
     */
    public static void main(String[] args) {
        // Make a collection
        ArrayList<Integer> u21cys = new ArrayList();

        u21cys.add(8);
        u21cys.add(5);
        // Get the iterator
//        Iterator<String> it = u21cys.iterator();

        // Print the cars using the iterator
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
        for (int i=0;i<2;i++){
            System.out.println(u21cys.get(i));
        }
        System.out.println(u21cys);

    }
}
