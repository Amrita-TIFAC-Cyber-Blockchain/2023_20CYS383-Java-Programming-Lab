package Com.Amrita.Jpl.cys21082.Exe;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        String[] rollNumbers = {
                "CB.EN.U4CYS22044",
                "CB.EN.U4CYS22065",
                "CB.EN.U4CYS22012",
                "CB.EN.U4CYS2287",
                "CB.EN.U4CYS22065"
        };

        // Print roll numbers using Arrays.toString()
        System.out.println(Arrays.toString(rollNumbers));

        // Or, print roll numbers using a for-each loop
        for (String rollNumber : rollNumbers) {
            System.out.println(rollNumber);
        }
    }
}
