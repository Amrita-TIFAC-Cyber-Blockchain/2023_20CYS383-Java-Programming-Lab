package com.amrita.jpl.cys21075.p1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for their choice
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        // Prompt the user for their choice
        switch (choice) {
            case 1:
                // Reverse a number
                System.out.print("Enter a number: ");
                int num = scanner.nextInt();
                int reverseNum = reverse_num(num);
                System.out.println("Reverse of " + num + " is " + reverseNum);
                break;

            case 2:
                // Find the largest of three numbers
                System.out.print("Enter three numbers: ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();
                int largest = large3num(num1, num2, num3);
                System.out.println("Largest of " + num1 + ", " + num2 + ", and " + num3 + " is " + largest);
                break;

            case 3:
                // Check if a number is a perfect square
                System.out.print("Enter a number: ");
                int numToCheck = scanner.nextInt();
                boolean isPerfectSquare = perfect_square_check(numToCheck);
                if (isPerfectSquare) {
                    System.out.println(numToCheck + " is a perfect square.");
                } else {
                    System.out.println(numToCheck + " is not a perfect square.");
                }
                break;

            case 4:
                // Check if a number is prime
                System.out.print("Enter a number: ");
                int numToTest = scanner.nextInt();
                boolean isPrime = prime_test(numToTest);
                if (isPrime) {
                    System.out.println(numToTest + " is a prime number.");
                } else {
                    System.out.println(numToTest + " is not a prime number.");
                }
                break;

            default:
                // Invalid choice
                System.out.println("Invalid choice!");
        }
    }
    // Reverse a number
    private static int reverse_num(int num) {
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }

    // Find the largest of three numbers
    private static int large3num(int num1, int num2, int num3) {
        int largest = num1;
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        return largest;
    }

    // Check if a number is a perfect square
    private static boolean perfect_square_check(int num) {
        if (num < 0) {
            // Negative number entered
            System.out.println("You have entered a negative number.");
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    // Check if a number is prime
    private static boolean prime_test(int num) {
        if (num < 2) {
            // Invalid number entered
            System.out.println("You must enter a number that is greater than or equal to 2.");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}