package com.amrita.jpl.cys21047.pract.basic;

import java.util.Scanner;

public class ArmstrongChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = countDigits(number);

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static int countDigits(int number) {
        int count = 0;

        while (number != 0) {
            number /= 10;
            count++;
        }

        return count;
    }
}

