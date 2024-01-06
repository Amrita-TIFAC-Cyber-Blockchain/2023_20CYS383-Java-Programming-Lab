package com.amrita.jpl.cys21062.p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu options
        System.out.println("Menu options:");
        System.out.println("1. Reverse a number");
        System.out.println("2. Find the largest among three numbers");
        System.out.println("3. Check if a number is a perfect square");
        System.out.println("4. Test if a number is prime");

        // Prompt the user to enter their choice
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Prompt the user to enter a number
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();

                // Display the reversed number
                int reversedNumber = reverseNumber(number);
                System.out.println("Reversed number: " + reversedNumber);
                break;
            case 2:
                // Prompt the user to enter three numbers
                System.out.print("Enter three numbers (separated by spaces): ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();

                // Display the largest number among them
                int largestNumber = findLargestNumber(num1, num2, num3);
                System.out.println("Largest number: " + largestNumber);
                break;
            case 3:
                // Prompt the user to enter a number
                System.out.print("Enter a number: ");
                int inputNumber = scanner.nextInt();

                // Display whether it is a perfect square or not
                boolean isPerfectSquare = isPerfectSquare(inputNumber);
                System.out.println("Is perfect square: " + isPerfectSquare);
                break;
            case 4:
                // Prompt the user to enter a number
                System.out.print("Enter a number: ");
                int testNumber = scanner.nextInt();

                // Display whether it is prime or not
                boolean isPrime = isPrime(testNumber);
                System.out.println("Is prime: " + isPrime);
                break;
            default:
                // Display an error message for invalid choice
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    // Method to reverse a number
    public static int reverseNumber(int number) {
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return reversedNumber;
    }

    // Method to find the largest number among three numbers
    public static int findLargestNumber(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    // Method to check if a number is a perfect square
    public static boolean isPerfectSquare(int number) {
        double squareRoot = Math.sqrt(number);
        return squareRoot == (int) squareRoot;
    }

    // Method to test if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
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

