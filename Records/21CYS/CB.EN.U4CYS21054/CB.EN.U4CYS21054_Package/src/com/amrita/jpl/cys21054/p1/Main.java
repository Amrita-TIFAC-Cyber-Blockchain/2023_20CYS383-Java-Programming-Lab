/**
 * This class contains methods for calculating factorial, Fibonacci series,
 * sum of n numbers, and primality test for a given number.
 * The user is prompted to input the value of n for each method.
 * The class has a main method that displays a menu for the user to select which method to run.
 *
 * @author Jivan Prasadd
 * @version 1.0
 * @since 24-04-23
 */
package com.amrita.jpl.cys21054.p1;
import java.util.Scanner;


public class Main {

    /**
     * This method calculates the factorial of a given number n.
     *
     * @return the factorial of n
     */
    int Factorial() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = obj.nextInt();
        int fact = 1;
        if (n < 0) {
            System.out.println("Invalid value");
            fact = 0;
        } else if (n == 0 || n == 1) {
            fact = 1;
        } else if (n > 1) {
            while (n > 1) {
                fact = fact * n;
                n = n - 1;
            }
        }
        return fact;
    }

    /**
     * This method calculates the sum of n Fibonacci numbers.
     *
     * @return sum of n Fibonacci numbers
     */
    int Fibonacci() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = obj.nextInt();
        int a1=0;
        int a2=1;
        int a3=0;
        int sum=0;
        for(int i=0;i<n;i++) {
            sum=sum+a1;
            a3=a2+a1;
            a1=a2;
            a2=a3;
        }
        System.out.println("Sum of Fibonacci numbers is");
        System.out.println(sum);
        return 0;
    }

    /**
     * This method calculates the sum of n natural numbers.
     *
     * @return the sum of n natural numbers
     */
    int Sum_n_no() {
        Scanner obj = new Scanner(System.in);
        int sum=0;
        System.out.println("Enter the value of n:");
        int n = obj.nextInt();
        for(int i=1;i<=n;i++) {
            sum=sum+i;
        }
        return sum;
    }

    /**
     * This method checks whether a given number is prime or not.
     *
     * @return true if the number is prime, false otherwise
     */
    boolean Primetest() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = obj.nextInt();
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }

    /**
     * This is the main method that displays a menu for the user to select which method to run.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner obj= new Scanner(System.in);
        Main myobj=new Main();
        System.out.println("1. Factorial(fact)");
        System.out.println("2. Fibonacci(fibo)");
        System.out.println("3. The sum of n numbers(sum_n_no)");
        System.out.println("4. Prime Test(prime_test)");
        System.out.println("Enter your choice:");
        int choice= obj.nextInt();
        switch(choice) {
            case 1:
                int c=myobj.Factorial();
                System.out.println(c);
                break;
            case 2:
                myobj.Fibonacci();
                break;
            case 3:
                int e=myobj.Sum_n_no();
                System.out.println(e);
                break;
            case 4:
                boolean f=myobj.Primetest();
                System.out.println(f);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}
