package com.amrita.jpl.cys21002.p1;

import java.util.Scanner;

/**
 * The Main class is the entry point of the program. It provides a menu-driven interface to perform various calculations.
 */
public class Main {
    /**
     * The main method where the program starts execution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner obj1 = new Scanner(System.in);
        System.out.print("Enter the  choice you wish to choose as shown :(1. Factorial, 2. Fibonacci, 3. The sum of 'n' numbers, 4. Prime Test): ");
        int choice = obj1.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number for factorial: ");
                int num1 = obj1.nextInt();
                if(num1>0) {
                    System.out.println("Factorial of " + num1 + " is: " + factorial(num1));
                }
                else{
                    System.out.println("Enter a positive number");
                }
                break;
            case 2:
                System.out.print("Enter a number for the Fibonacci series to start: ");
                int num2 = obj1.nextInt();
                System.out.println("Fibonacci sequence for upto " + num2 + " is: ");
                for (int i = 1; i <= num2; i++) {
                    System.out.print(fibonacci(i) + " ");
                }
                System.out.println();
                break;
            case 3:
                System.out.print("Enter a number to calculate the sum of 'n' numbers: ");
                int num3 = obj1.nextInt();
                System.out.println("Sum of first " + num3 + " numbers is: " + sumOfNNumbers(num3));
                break;
            case 4:
                System.out.print("Enter a number for prime test: ");
                int num4 = obj1.nextInt();
                if (isPrime(num4)) {
                    System.out.println(num4 + " is a prime number.");
                } else {
                    System.out.println(num4 + " is not a prime number.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    /**
     * Calculates the factorial of a number.
     *
     * @param n the number for which to calculate the factorial
     * @return the factorial of the given number
     */

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Generates the Fibonacci sequence up to a given number.
     *
     * @param n the number specifying the length of the Fibonacci sequence
     * @return an array representing the Fibonacci sequence up to the given number
     */

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    /**
     * Calculates the sum of the first 'n' natural numbers.
     *
     * @param n the number specifying the count of natural numbers
     * @return the sum of the first 'n' natural numbers
     */
    public static int sumOfNNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


