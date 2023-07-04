package Com.Amrita.Jpl.cys21082.Exe;

import java.util.Arrays;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {
        List<String> u21cys = Arrays.asList(
                "BLR.C3.J4ECE4056",
                "BLR.C3.J4ECE4023",
                "BLR.C3.J4ECE4092",
                "BLR.C3.J4ECE4084",
                "BLR.C3.J4ECE4075"
        );

        // Print the contents of the List using a for loop
        for (int i = 0; i < u21cys.size(); i++) {
            System.out.println(u21cys.get(i));
        }
    }
}
