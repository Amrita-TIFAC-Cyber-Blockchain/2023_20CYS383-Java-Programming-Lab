package com.amrita.jpl.cys21055.prac.addsubtract;
import java.util.Scanner;


/**
 * @author ganasekhar
 */
public class addsub_55 {
    /**
     *@param args this function is the sum and difference giving function
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2;
        int difference = num1 - num2;

        System.out.println("The sum is: " + sum);
        System.out.println("The difference is: " + difference);
    }
}



