package com.amrita.jpl.cys21007.pract.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
public class Main {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of ArrayList to store and iterate over a collection of student roll numbers.
     * CB.EN.U4CYS21007 ANU PRIYA P
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Make a collection
        ArrayList<String> u21cys = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> dob = new ArrayList<>();

        name.add("Anu");
        name.add("Amy");
        name.add("Amelia");
        name.add("Amour");
        name.add("Aryan");

        dob.add("april 22 04");
        dob.add("april 23 03");
        dob.add("april 12 03");
        dob.add("january 19 04");


        u21cys.add("CB.EN.U4CYS22026");
        u21cys.add("CB.EN.U4CYS22027");
        u21cys.add("CB.EN.U4CYS22028");
        u21cys.add("CB.EN.U4CYS22029");
        u21cys.add("CB.EN.U4CYS22030");
        // Get the iterator
        Iterator<String> it = u21cys.iterator();
        Iterator<String> it2 = name.iterator();
        Iterator<String> it3 = dob.iterator();
        // Print the cars using the iterator
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.next());

        System.out.println(it3.next());
        System.out.println(it3.next());
        System.out.println(it3.next());
        System.out.println(it3.next());
    }
}
