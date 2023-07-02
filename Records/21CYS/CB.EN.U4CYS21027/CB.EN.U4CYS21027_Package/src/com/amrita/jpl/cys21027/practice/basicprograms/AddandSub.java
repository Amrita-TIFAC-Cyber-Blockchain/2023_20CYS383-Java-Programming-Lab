/**
 * The AddandSub class performs addition and subtraction of two numbers.
 * @author K Sri Sai Nitin
 * @version 0.5
 */

package com.amrita.jpl.cys21027.practice.basicprograms;
import java.util.Scanner;

public class AddandSub {
    /**
     * The main method allows users to input two numbers and performs addition and subtraction.
     * @param args the command-line arguments
     */
    public static void main(String args[]) {
        int a, b, add, sub;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Number : ");
        a = scanner.nextInt();
        System.out.print("Enter Second Number : ");
        b = scanner.nextInt();

        add = a + b;
        sub = a - b;

        System.out.println("Sum of " + a + " and " + b + " = " + add);
        System.out.println("Difference of " + a + " and " + b + " = " + sub);
    }
}