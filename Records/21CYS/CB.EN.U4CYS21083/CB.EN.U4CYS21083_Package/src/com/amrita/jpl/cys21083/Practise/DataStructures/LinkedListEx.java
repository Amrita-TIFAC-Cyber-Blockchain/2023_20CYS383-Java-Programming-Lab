package com.amrita.jpl.cys21083.Practise.DataStructures;

import java.util.LinkedList;
public class LinkedListEx {
    public LinkedListEx() {
    }

    public static void main(String[] args) {
        LinkedList<String> u21cys = new LinkedList();
        u21cys.add("CB.EN.U4CYS22031");
        u21cys.add("CB.EN.U4CYS22032");
        u21cys.add("CB.EN.U4CYS22033");
        u21cys.add("CB.EN.U4CYS22034");
        u21cys.add("CB.EN.U4CYS22035");
        System.out.println(u21cys);

        u21cys.set(1,"CB.EN.U4CYS21083");
        System.out.println("Modified List: " + u21cys);
        System.out.println("List Size: " + u21cys.size());

    }
}
