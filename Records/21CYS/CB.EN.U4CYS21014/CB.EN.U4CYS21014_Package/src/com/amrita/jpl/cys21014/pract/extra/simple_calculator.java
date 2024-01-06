package com.amrita.jpl.cys21014.pract.extra;
/**
 * @author Deepthi Jayanth
 */

import java.util.Scanner;

public class simple_calculator {
    public static void main(String[] args) {
        Scanner values = new Scanner(System.in);
        int opr = 0;
        while(true) {
            System.out.println("START");
            System.out.println("Enter '1' for adding two values.\nEnter '2' for subtracting two values.\nEnter '3' for multiplying two values.\nEnter '4' for dividing two values.\nEnter '5' to EXIT.\nChoose an operation: ");
            opr = values.nextInt();
            if(opr == 5)
            {
                System.out.println("EXIT.");
                break;
            }
            System.out.println("Enter the first value: ");
            float m = values.nextFloat();
            System.out.println("Enter the second value: ");
            float n = values.nextFloat();

            switch (opr) {
                case 1 -> System.out.println(m + " + " + n + " = " + (m + n));
                case 2 -> System.out.println(m + " - " + n + " = " + (m - n));
                case 3 -> System.out.println(m + " * " + n + " = " + (m * n));
                case 4 -> System.out.println(m + " / " + n + " = " + (m / n));
                default -> System.out.println("Invalid choice. Try again!");
            }
        }

    }
}