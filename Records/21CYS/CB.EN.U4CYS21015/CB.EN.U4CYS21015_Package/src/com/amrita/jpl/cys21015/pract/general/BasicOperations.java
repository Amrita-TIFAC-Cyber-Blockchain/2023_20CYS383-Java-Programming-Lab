package com.amrita.jpl.cys21015.pract.general;

import java.util.*;
public class BasicOperations {

    /**
     * This class performs basic arithmetic operations on two numbers like addition, subtraction,, multiplication and division
     *
     * @author Dyanesh S [CB.EN.U4CYS21015]
     */

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner read = new Scanner(System.in);
        int x,y;
        System.out.print("Enter the first number: ");
        x = read.nextInt();
        System.out.print("Enter the second number: ");
        y = read.nextInt();
        read.close();
        System.out.println("The sum is "+(x+y));
        System.out.println("The difference is "+(x-y));
        System.out.println("The product is "+(x*y));
        System.out.println("The quotient is "+(x/y));
    }
}