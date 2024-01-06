package com.amrita.jpl.cys21034.p1;

import java.util.Scanner;

public class p1 {
    /**
     * Main function
     * @param args default parameter to main function
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        do {
            System.out.println("Select an option:");
            System.out.println("1. Reverse of a number (reverse num)");
            System.out.println("2. Largest of three numbers (large3num)");
            System.out.println("3. Perfect Square (perfect square check)");
            System.out.println("4. Prime Test (prime test)");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int reversed = reverse_num(num);
                    System.out.println("The reversed number is: " + reversed);
                    break;
                case 2:
                    System.out.print("Enter two more numbers: ");
                    int num2 = scanner.nextInt();
                    int num3 = scanner.nextInt();
                    int largest = large3num(num, num2, num3);
                    System.out.println("The largest number is: " + largest);
                    break;
                case 3:
                    Perfect_Square_check(num);
                    break;
                case 4:
                    prime_test(num);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        } while (choice < 1 || choice > 4);
    }
    /**
     * reversing the number
     * @param num number that is to be reversed
     */
    public static int reverse_num(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
    /**
     * finding the largest of three numbers
     * @param num1,num2,num3 numbers that are to be checked
     */
    public static int large3num(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
    /**
     * checking whether the number is perfect square
     * @param num number that is to be checked
     */
    public static void Perfect_Square_check(int num) {
        if (num < 0) {
            System.out.println("Error: negative number.");
        }
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num){
            System.out.println(num+" is a perfect square ");
        }
        else {
            System.out.println(num + " is not a perfect square");
        }
    }
    /**
     * checking whether the number is prime or not
     * @param num number that is to be checked
     */
    public static void prime_test(int num) {
        if (num < 2) {
            System.out.println("Error: number must be greater than or equal to 2.");
        }
        int c=0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                c=c+1;
            }
        }
        if (c==0){
            System.out.println(num + " is a prime number");
        }
        else {
            System.out.println(num + " is not a prime number");
        }
    }
}