package com.amrita.jpl.cys21007.p1;
import java.util.Scanner;
/* class p1 created
 */
public class p1 {
    public static void main(String[] args) {
        Scanner val = new Scanner(System.in);
        int choice;

        System.out.println("Enter your choice:");
        System.out.println("1. Factorial (fact)");
        System.out.println("2. Fibonacci (fibo)");
        System.out.println("3. The sum of ’n’ numbers (sum n no)");
        System.out.println("4. Prime Test (prime test)");

        choice = val.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a positive integer: ");
                int num = val.nextInt();
                if (num < 0) {
                    System.out.println("Error: Please enter a valid positive integer");
                } else {
                    long result = factorial(num);
                    System.out.println("Factorial of " + num + " is: " + result);
                }
                break;

            case 2:
                System.out.print("Enter the number of terms required: ");
                int n = val.nextInt();
                if (n <= 0) {
                    System.out.println("Error: Please enter a valid positive integer");
                } else {
                    System.out.println("Fibonacci series of " + n + " terms:");
                    fibonacci(n);
                }
                break;

            case 3:
                System.out.print("Enter the required n value: ");
                int val1 = val.nextInt();
                if (val1 <= 0) {
                    System.out.println("Error: Please enter a valid positive integer");
                } else {
                    int sum = sumOfNumbers(val1);
                    System.out.println("The sum of " + val1 + " numbers is: " + sum);
                }
                break;

            case 4:
                System.out.print("Enter the required num: ");
                int numToTest = val.nextInt();
                if (numToTest <= 0) {
                    System.out.println("Error: Please enter a valid positive integer");
                } else {
                    boolean isPrime = isPrime(numToTest);
                    if (isPrime) {
                        System.out.println(numToTest + " is a prime number");
                    } else {
                        System.out.println(numToTest + " is not a prime number");
                    }
                }
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
    /* func fact

     */
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    /* func fibo
     */
    public static void fibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.println();
    }
    /* func sum of no

     */
    public static int sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    /* func isprime

     */

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
