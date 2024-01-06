package com.amrita.jpl.cys21031.practice.simple;

import java.util.Scanner;

/**
 * @author Kishanth K
 * @version 1.0
 * Basic Factorial Program
 */


public class Factorial {
    public static void main(String args[]){
        int i,fact=1;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();//It is the number to calculate factorial
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
        input.close();
    }
}
