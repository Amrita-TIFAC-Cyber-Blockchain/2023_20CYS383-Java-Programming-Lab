package com.amrita.jpl.cys21083.Practise.zBasicCalculations;

import java.util.Scanner; //for getting input from users

public class Input_Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial Program");
        Scanner input = new Scanner(System.in); //scanner object is created

        int num;
        System.out.println("Enter NUmber to find the Factorial: ");
        num = input.nextInt(); //input

        int i;
        int fact = 1;
        for(i=1;i<=num;i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of "+ num + " is "+ fact);

    }

}
