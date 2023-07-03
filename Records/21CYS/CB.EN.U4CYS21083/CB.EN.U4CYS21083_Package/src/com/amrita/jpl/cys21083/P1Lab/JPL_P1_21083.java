package com.amrita.jpl.cys21083.P1Lab;

/**
 * @author Revan Nagireddy-CB.EN.U4CYS21083
 */

import java.util.Scanner;

public class JPL_P1_21083 {
    /**
     * FUnction for Factorial
     * @param num number to get the factorial
     * @return fact returns the value of the variable fact
     */
    public static int fact(int num) {
        System.out.println("Factorial of " + num);
        if (num < 0) {
            System.out.println("Error: " + num + " is not a valid input");
        }
        int i;
        int fact = 1;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * Function for Fibonacci
     * @param num number to get the fibonacci
     */

    public static void fibo(int num){
        int n1 = 0, n2 = 1;
        if (num < 0) {
            System.out.println("Error: " + num + " is not a valid input");
        }
        System.out.println("Fibonacci of the " + num +" is:");
        for (int i = 1; i <= num; ++i) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
        }
    }

    /**
     * Function for Sum of numbers
     * @param num number to get the sum of numbers
     * @return sum returns the sum of numbers sum is a variable that add the n numbers
     */

    public static int sum_n_no(int num){
        if (num <= 0) {
            System.out.println("Error: " + num + " is not a valid input");
        }
        int sum = 0;
        int i;
        for(i = 1; i <= num; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * FUnction for testing Prime or number
     * @param num number to know prime or not
     * @return factors returns the no.of factors of the number given
     */

    public static int prime_test(int num){
        int i;
        if (num < 2) {
            System.out.println("Error: " + num + " is not a valid input");
        }
        int factors=0;
        for(i=2; i<num ;i++) {
            if (num % i == 0) {
                factors++;
            }

        }
        return factors;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice;
        int number;
        System.out.println("Enter Number: ");
        number = input.nextInt();

        System.out.println("1. Factorial");
        System.out.println("2. Fibonacci");
        System.out.println("3. Sum of Numbers");
        System.out.println("4. Prime Test");

        System.out.println("Enter you number Choice: ");
        choice = input.nextInt();

        switch(choice){
            case 1:
                int fact = fact(number);
                System.out.println("Factorial of "+ number + " is "+ fact);
                break;

            case 2:
                fibo(number);
                break;

            case 3:
                int sum = sum_n_no(number);
                System.out.println("Sum of numbers for " + number + " is: " + sum);
                break;

            case 4:
                int factors = prime_test(number);
                if(factors!=0) {
                    System.out.println( number + " is not a prime number");
                }
                else {
                    System.out.println( number + " is a Prime number");
                }
                break;
        }
    }
}
