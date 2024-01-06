package com.amrita.jpl.cys21064.pract.general;
import java.util.*;

/**
 * @author Rajendraprasad S
 */
public class basics {
    /**
     * Adds two numbers.
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter first number:");
        int a = read.nextInt();
        System.out.print("Enter second number:");
        int b = read.nextInt();
        System.out.println("Sum is "+(a+b));
    }
}
