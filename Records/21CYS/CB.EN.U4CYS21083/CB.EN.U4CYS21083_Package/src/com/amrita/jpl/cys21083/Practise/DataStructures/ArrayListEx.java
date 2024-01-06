package com.amrita.jpl.cys21083.Practise.DataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx{
    public ArrayListEx() {
    }

    public static void main(String[] args) {
        ArrayList<String> u21cys = new ArrayList();
        u21cys.add("CB.EN.U4CYS22080");
        u21cys.add("CB.EN.U4CYS22081");
        u21cys.add("CB.EN.U4CYS22082");
        u21cys.add("CB.EN.U4CYS22083");
        u21cys.add("CB.EN.U4CYS22084");
        u21cys.add("CB.EN.U4CYS22085");
        u21cys.add("CB.EN.U4CYS22086");
        u21cys.add("CB.EN.U4CYS22087");
        u21cys.add("CB.EN.U4CYS22088");
        u21cys.add("CB.EN.U4CYS22089");
        Iterator<String> it = u21cys.iterator();
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());
        System.out.println((String)it.next());

        ArrayList<Integer> trail = new ArrayList();
        trail.add(1);
        trail.add(2);
        trail.add(3);
        trail.add(4);
        trail.add(5);

        Iterator<Integer> it1 = trail.iterator();
        System.out.println((Integer)trail.get(0));
        System.out.println((Integer)trail.get(1));
        System.out.println((Integer)trail.get(2));
        System.out.println((Integer)trail.get(3));
        System.out.println((Integer)trail.get(4));

        //modifying elements
        trail.set(3,0);
        System.out.println(trail);

        trail.remove(1);
        System.out.println("List after Removing 2nd Index: " + trail);

        System.out.println("Size of the Array List: " + trail.size());
    }
}

