package Com.Amrita.Jpl.cys21082.Exe;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args) {
        // Make a collection
        ArrayList<String> u21cys = new ArrayList<>();

        u21cys.add("CB.EN.U4CYS22046");
        u21cys.add("CB.EN.U4CYS22012");
        u21cys.add("CB.EN.U4CYS22077");
        u21cys.add("CB.EN.U4CYS22054");
        u21cys.add("CB.EN.U4CYS21290");

        // Print the roll numbers using an enhanced for loop
        for (String rollNumber : u21cys) {
            System.out.println(rollNumber);
        }

        // Or, print the roll numbers using an Iterator
        Iterator<String> it = u21cys.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

