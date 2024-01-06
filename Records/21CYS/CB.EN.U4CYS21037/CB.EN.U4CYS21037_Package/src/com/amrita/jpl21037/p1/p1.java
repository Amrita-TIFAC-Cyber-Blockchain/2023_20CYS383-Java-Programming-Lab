package com.amrita.jpl.cys21001.p1;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number to find its factorial: ");
                int numFactorial = scanner.nextInt();
                long factorialResult = factorial(numFactorial);
                System.out.println("Factorial of " + numFactorial + " is: " + factorialResult);
                break;
            case 2:
                System.out.print("Enter the number of terms in the Fibonacci sequence: ");
                int numFibonacci = scanner.nextInt();
                System.out.println("Fibonacci sequence:");
                fibonacci(numFibonacci);
                break;
            case 3:
                System.out.print("Enter the value of 'n' for sum of 'n' numbers: ");
                int n = scanner.nextInt();
                int sum = sumOfNumbers(n);
                System.out.println("Sum of first " + n + " numbers is: " + sum);
                break;
            case 4:
                System.out.print("Enter a number to test if it's prime: ");
                int numPrime = scanner.nextInt();
                boolean isPrime = isPrime(numPrime);
                if (isPrime)
                    System.out.println(numPrime + " is a prime number.");
                else
                    System.out.println(numPrime + " is not a prime number.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number from the menu.");
                break;
        }

        scanner.close();
    }

    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Invalid input. Factorial is not defined for negative numbers.");
            return -1;
        }

        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void fibonacci(int num) {
        if (num <= 0) {
            System.out.println("Invalid input. Fibonacci sequence is not defined for non-positive numbers.");
            return;
        }

        int prev = 0, curr = 1;
        System.out.print(prev + " " + curr);

        for (int i = 3; i <= num; i++) {
            int next = prev + curr;
            System.out.print(" " + next);
            prev = curr;
            curr = next;
        }

        System.out.println();
    }

    public static int sumOfNumbers(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. Sum of 'n' numbers is not defined for non-positive values of 'n'.");
            return -1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
