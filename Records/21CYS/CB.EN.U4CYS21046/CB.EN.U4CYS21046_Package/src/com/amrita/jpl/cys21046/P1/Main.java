package com.amrita.jpl.cys21046.P1;

import java.util.Scanner;
public class Main {
    /**
     * main function gets input from user
     * displays a menu to choose operations from
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1331;

        System.out.println("\n        Menu");
        System.out.println("1. Reverse of a number");
        System.out.println("2. Largest of three numbers");
        System.out.println("3. Perfect Square");
        System.out.println("4. Prime Test");

        System.out.print("\nEnter your choice: ");
        choice = scanner.nextInt();

        /**
         * switch case assigns function according to choise chosen from menu
         * @param choice - executes case according to choice
         */
        switch(choice) {
            case 1:
                System.out.print("Enter a number to reverse: ");
                int numToReverse = scanner.nextInt();
                int reversedNum = Functions.reverse_num(numToReverse);
                System.out.println("Reversed number = " + reversedNum);
                break;

            case 2:
                System.out.print("Enter three numbers (separated by space) : ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();
                int largestNum = Functions.large3num(num1, num2, num3);
                System.out.println("Largest number = " + largestNum);
                break;

            case 3:
                System.out.print("Enter number for perfect square check : ");
                int numToCheck = scanner.nextInt();
                boolean isPerfectSquare = Functions.perfect_square_check(numToCheck);
                if(isPerfectSquare) {
                    System.out.println(numToCheck + " is a perfect square.");
                } else {
                    System.out.println(numToCheck + " is not a perfect square.");
                }
                break;

            case 4:
                System.out.print("Enter a number for prime check: ");
                int numToTest = scanner.nextInt();
                boolean isPrime = Functions.prime_test(numToTest);
                if(isPrime) {
                    System.out.println(numToTest + " is prime.");
                } else {
                    System.out.println(numToTest + " is not prime.");
                }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

        scanner.close();
    }

    /**
     * class functions has 4 functions which is used by codes in menu
     */
    public static class Functions {

        /**
         * reverse_num function gets input and reverses it
         * @param num - number to be reversed
         * @return returns reversed number
         */
        public static int reverse_num(int num) {
            int reversedNum = 0;
            while(num != 0) {
                int digit = num % 10;
                reversedNum = reversedNum * 10 + digit;
                num /= 10;
            }
            return reversedNum;
        }

        /**
         * large3num function gets input and finds the largest among them
         * @param num1,num2,num3 - 3 numbers from user
         * @return returns largest of the 3 numbers
         */
        public static int large3num(int num1, int num2, int num3) {
            int largestNum = num1;
            if(num2 > largestNum) {
                largestNum = num2;
            }
            if(num3 > largestNum) {
                largestNum = num3;
            }
            return largestNum;
        }

        /**
         * perfect_square_check function gets input and checks if a number is perfect square or not
         * @param num - number to check for perfect square
         * @return returns boolean
         */
        public static boolean perfect_square_check(int num) {
            if(num < 0) {
                System.out.println("Error: Negative number.");
                return false;
            }
            int sqrt = (int) Math.sqrt(num);
            return sqrt * sqrt == num;
        }

        /**
         * perfect_square_check function gets input and checks if a number is prime or not
         * @param num - number to check for prime
         * @return returns boolean
         */
        public static boolean prime_test(int num) {
            if(num < 2) {
                System.out.println("Error: Number less than 2.");
                return false;
            }
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}