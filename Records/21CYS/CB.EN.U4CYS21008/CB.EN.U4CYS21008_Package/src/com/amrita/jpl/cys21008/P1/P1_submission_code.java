package com.amrita.jpl.cys21008.P1;




import java.util.Scanner;

/**
 * The `P1_submission_code` class contains methods to perform various mathematical operations.
 * @Author:Anuvarshini M K
 */
public class P1_submission_code {

    /**
     * Calculates the factorial of a given number.
     *
     * @param num the number to calculate the factorial of
     */
    public static void fact(int num){
        if(num<0){
            System.out.println("Enter a valid number");
        }

        else {
            int i;
            int fact = 1;
            for (i = 1; i <= num; i++) {
                fact *= i;
            }
            System.out.println("The factorial of the number is: " + fact);
        }
    }

    /**
     * Generates the Fibonacci sequence up to a given number.
     *
     * @param num the number up to which the Fibonacci sequence is generated
     */
    public static void fibonacci(int num){
        if(num<0){
            System.out.println("Enter a valid number");
        }

        else {
            System.out.println("Fibonacci number for the given number is");
            int bef = 0;
            int next = 1;
            int fib;
            System.out.println(bef);
            System.out.println(next);
            for (int i = 3; i <= num; i++) {
                fib = bef + next;
                System.out.println(fib);
                bef = next;
                next = fib;
            }
        }
    }

    /**
     * Calculates the sum of the first n natural numbers.
     *
     * @param num the number of natural numbers to be summed
     */
    public static void sum_of_n_number(int num) {
        if (num < 0) {
            System.out.println("Enter a valid number");
        } else {
            int sum = 0;
            int i;
            for (i = 1; i <= num; i++) {
                sum += i;
            }
            System.out.println("The sum of the first " + num + " numbers is: " + sum);
        }
    }

    /**
     * Tests if a given number is prime.
     *
     * @param num the number to be tested
     */
    public static void prime_test(int num){
        if(num<0){
            System.out.println("Enter a valid number");
        }
        else {
            int flag = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    flag = 1;
                }
            }

            if (flag == 1) {
                System.out.println("It is not a prime number");
            } else {
                System.out.println("It is a prime number");
            }
        }
    }

    /**
     * The entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        int choice = 1;
        Scanner sc = new Scanner(System.in);

        while(choice<5){
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. Sum of n numbers");
            System.out.println("4. Prime test");
            System.out.println("5. Exit");
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

            if(choice==0){
                System.out.println("Invalid choice.");
            }
            else{
                switch (choice){
                    case 1:
                        System.out.print("Enter a number: ");
                        int num = sc.nextInt();
                        fact(num);
                        break;

                    case 2:
                        System.out.print("Enter a number: ");
                        int num1 = sc.nextInt();
                        fibonacci(num1);
                        break;

                    case 3:
                        System.out.print("Enter a number: ");
                        int num2 = sc.nextInt();
                        sum_of_n_number(num2);
                        break;

                    case 4:
                        System.out.print("Enter a number: ");
                        int num3 = sc.nextInt();
                         prime_test(num3);
                        break;

                    case 5:
                        choice = 6;

                    default:
                        System.out.println("Enter a valid choice");
                }
            }
        }
    }
}

