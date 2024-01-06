package com.amrita.jpl.cys21063.p1;

import java.util.Scanner;

public class p1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice (1. Factorial, 2. Fibonacci, 3. Sum of 'n' numbers, 4. Prime Test): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                int num = scanner.nextInt();
                long factorial = factorial(num);
                System.out.println("Factorial of " + num + " is: " + factorial);
                break;
            case 2:
                System.out.print("Enter the number of terms: ");
                int n = scanner.nextInt();
                System.out.println("Fibonacci Series:");
                fibonacci(n);
                break;
            case 3:
                System.out.print("Enter the count of numbers: ");
                int count = scanner.nextInt();
                int sum = sumOfNumbers(count);
                System.out.println("Sum of " + count + " numbers is: " + sum);
                break;
            case 4:
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                boolean isPrime = isPrime(number);
                System.out.println(number + " is" + (isPrime ? "" : " not") + " a prime number");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }

        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void fibonacci(int n) {
        if (n <= 0) {
            System.out.println("Number of terms should be positive.");
            return;
        }

        int first = 0;
        int second = 1;

        System.out.print(first + " ");

        for (int i = 1; i < n; i++) {
            System.out.print(second + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static int sumOfNumbers(int count) {
        if (count <= 0) {
            System.out.println("Count of numbers should be positive.");
            return 0;
        }

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += scanner.nextInt();
        }

        return sum;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            System.out.println("Prime numbers are greater than 1.");
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}