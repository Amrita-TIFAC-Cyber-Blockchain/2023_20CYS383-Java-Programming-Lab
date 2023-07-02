package com.amrita.jpl.cys21001.p1;

import java.util.Scanner;

/**
 * This program consists of factorial, fibonacci, and sum of n numbers.
 *
 * @author Abi G
 * @param args command line arguments
 */

/**main function with switch case
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//created an object for input


        System.out.print("Enter a number: ");
        int choice = input.nextInt();//getting input

        switch (choice) {
            case 1:
                System.out.print("Enter a number to find factorial: ");
                int num1 = input.nextInt();
                int factorial = fact(num1);
                System.out.println("Factorial of " + num1 + " is " + factorial + ".");
                break;
            case 2:
                System.out.print("Enter a number to print Fibonacci sequence: ");
                int num2 = input.nextInt();
                fib(num2);
                break;
            case 3:
                System.out.print("Enter an integer to find the sum of n numbers: ");
                int num3 = input.nextInt();
                int Sum = sum(num3);
                System.out.println("The sum of first " + num3 + " natural numbers is " + Sum + ".");
                break;
            default:
                System.out.println("Enter a valid choice.");

        }
    }


    /**function for factorial
     */
    public static int fact(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /**function for fibonacci
     */
    public static void fib(int n){
        int a = 0;
        int b = 1;
        int c;
        System.out.print("Fibonacci of " + n + " is: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /**function for sum of n numbers
     */
    public static int sum ( int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
