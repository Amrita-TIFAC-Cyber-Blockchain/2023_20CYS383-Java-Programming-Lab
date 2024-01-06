package com.amrita.jpl.cys21072.periodical1;
import java.util.*;
/**
 *  The periodical1 class contains methods for factorial, fibonacci, sum of numbers, and prime test.
 * You can provide the parameters for each method in the main method.
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */
public class periodical1 {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int choice;
            do {
                System.out.println("Enter your choice:");
                System.out.println("1. Factorial");
                System.out.println("2. Fibonacci");
                System.out.println("3. The sum of \"n\" numbers");
                System.out.println("4. Prime Test");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the number to find its factorial:");
                        int n1 = sc.nextInt();
                        if (n1 < 0) {
                            System.out.println("Factorial of a negative number is undefined.");
                        } else {
                            System.out.println("Factorial of " + n1 + " is " + factorial(n1));
                        }
                        break;
                    case 2:
                        System.out.println("Enter the number of terms to generate fibonacci sequence:");
                        int n2 = sc.nextInt();
                        if (n2 <= 0) {
                            System.out.println("Number of terms should be a positive integer.");
                        } else {
                            System.out.print("Fibonacci sequence of " + n2 + " terms: ");
                            fibonacci(n2);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the number to find its sum:");
                        int n3 = sc.nextInt();
                        if (n3 < 0) {
                            System.out.println("Enter an positive integer.");
                        } else {
                            System.out.println("Sum of first " + n3 + " numbers is " + sumOfN(n3));
                        }
                        break;
                    case 4:
                        System.out.println("Enter the number to test if it is prime:");
                        int n4 = sc.nextInt();
                        if (n4 <= 1) {
                            System.out.println("" + n4 + " is neither prime nor composite.");
                        } else if (isPrime(n4)) {
                            System.out.println("" + n4 + " is a prime number.");
                        } else {
                            System.out.println("" + n4 + " is not a prime number.");
                        }
                        break;
                    default:
                        System.out.println("Enter a valid choice");
                }
            } while(choice != 0);

            sc.close();
        }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n the number for which factorial is to be calculated
     * @return the factorial of the given number
     */
    public static int factorial(int n) {
            if (n == 0) {
                return 1;
            } else {
                int fact = 1;

                for(int i = 1; i <= n; ++i) {
                    fact *= i;
                }

                return fact;
            }
        }
    /**
     * Generates the Fibonacci sequence up to a given number of terms.
     *
     * @param n the number of terms to generate in the Fibonacci sequence
     */
        public static void fibonacci(int n) {
            int a = 0;
            int b = 1;

            for(int i = 1; i <= n; ++i) {
                System.out.print("" + a + " ");
                int sum = a + b;
                a = b;
                b = sum;
            }

            System.out.println();
        }
    /**
     * Calculates the sum of the first 'n' natural numbers.
     *
     * @param n the number up to which sum is to be calculated
     * @return the sum of the first 'n' natural numbers
     */
        public static int sumOfN(int n) {
            int sum = 0;

            for(int i = 1; i <= n; ++i) {
                sum += i;
            }

            return sum;
        }
    /**
     * Checks if a given number is prime.
     *
     * @param n the number to be checked for primality
     * @return true if the number is prime, false otherwise
     */
        public static boolean isPrime(int n) {
            if (n != 0 && n != 1) {
                for(int i = 2; i <= n / 2; ++i) {
                    if (n % i == 0) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        }
    }


