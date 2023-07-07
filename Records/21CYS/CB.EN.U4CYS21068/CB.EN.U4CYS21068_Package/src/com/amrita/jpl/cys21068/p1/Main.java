package com.amrita.jpl.cys21068.p1;
import java.util.Scanner;
/**
 * This program provides various operations based on user's choice.
 */
public class Main {
    /**
     * Reverses a given number.
     * returns the reversed number
     */
    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    /**
     * Finds the largest among three numbers.
     * returns the largest number
     */
    public static int findLargest(int num1, int num2, int num3) {
        int largest = num1;
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        return largest;
    }

    /**
     * Checks if a number is a perfect square.
     */
    public static void checkPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        if (sqrt * sqrt == number) {
            System.out.println(number + " is a perfect square.");
        } else {
            System.out.println(number + " is not a perfect square.");
        }
    }

    /**
     * Checks if a number is prime.
     */
    public static void checkPrime(int number) {
        boolean isPrime = true;
        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    /**
     * Reads user input, performs the selected operation, and displays the result.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Reverse of a number (reverse num)\n" +
                "2. Largest of three numbers (large3num)\n" +
                "3. Perfect Square (perfect square check)\n" +
                "4. Prime Test (prime test)\n" +
                "Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                int numberToReverse = scanner.nextInt();
                int reversedNumber = reverseNumber(numberToReverse);
                System.out.println("Reversed number: " + reversedNumber);
                break;
            case 2:
                System.out.print("Enter three numbers (separated by spaces): ");
                int firstNumber = scanner.nextInt();
                int secondNumber = scanner.nextInt();
                int thirdNumber = scanner.nextInt();
                int largestNumber = findLargest(firstNumber, secondNumber, thirdNumber);
                System.out.println("Largest number: " + largestNumber);
                break;
            case 3:
                System.out.print("Enter a number: ");
                int numberToCheckSquare = scanner.nextInt();
                checkPerfectSquare(numberToCheckSquare);
                break;
            case 4:
                System.out.print("Enter a number: ");
                int numberToCheckPrime = scanner.nextInt();
                checkPrime(numberToCheckPrime);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
