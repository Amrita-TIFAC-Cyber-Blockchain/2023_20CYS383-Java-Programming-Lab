package com.amrita.jpl.cys21061.p1;
/**
 * @author Roshni-CYS21061
 */

import java.util.Scanner;

public class Main {
    /**
     * taking input integer
     *
     * @param a input integer
     * @return factorial of the input integer
     */
    public static int fact(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the sum of n numbers
     *
     * @param n the number of terms
     * @return the sum of n numbers
     */
    public static int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Checks if a number is prime or not
     *
     * @param num the number to be checked
     * @return 1 if the number is not prime, 0 if the number is prime
     */
    public static int prime_test(int num) {
        if (num <= 1) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Prints the Fibonacci series up to the given number of terms
     *
     * @param n the number of terms
     */
    public static void fibo(int n) {
        int prev = 0;
        int current = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(prev + " ");

            int temp = prev + current;
            prev = current;
            current = temp;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Menu:");
        System.out.println("1. Factorial (fact)");
        System.out.println("2. Fibonacci (fibo)");
        System.out.println("3. The sum of n numbers (sum_n_no)");
        System.out.println("4. Prime Test (prime_test)");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        switch (choice) {
            case 1:
                int factorial = fact(num);
                System.out.println("Factorial: " + factorial);
                break;
            case 2:
                fibo(num);
                break;
            case 3:
                int sum = sum_n_no(num);
                System.out.println("Sum of n numbers: " + sum);
                break;
            case 4:
                int isPrime = prime_test(num);
                if (isPrime == 0) {
                    System.out.println(num + " is a prime number.");
                } else {
                    System.out.println(num + " is not a prime number.");
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}

