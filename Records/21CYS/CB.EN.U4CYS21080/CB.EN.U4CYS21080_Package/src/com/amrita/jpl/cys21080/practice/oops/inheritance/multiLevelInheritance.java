package com.amrita.jpl.cys21080.practice.oops.inheritance;

import java.util.Scanner;

/**
 * This class represents a simple calculator with four basic arithmetic operations.
 * @author pavan_9999
 */
class simpleCalc {

    /**
     * Adds two integers and returns the result.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of the two integers
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first integer and returns the result.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the difference between the two integers
     */
    public int sub(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers and returns the result.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the product of the two integers
     */
    public int mul(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second integer and returns the result.
     *
     * @param a the first integer (dividend)
     * @param b the second integer (divisor)
     * @return the quotient of the division
     */
    public int div(int a, int b) {
        return a / b;
    }
}

/**
 * This class extends the 'simpleCalc' class and adds additional advanced mathematical operations.
 */
class advanceCalc extends simpleCalc {

    /**
     * Calculates the power of an integer raised to another integer and returns the result.
     *
     * @param a the base integer
     * @param b the exponent integer
     * @return the result of raising 'a' to the power of 'b'
     */
    public int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }

    /**
     * Calculates the square root of an integer and returns the result.
     *
     * @param a the integer to calculate the square root of
     * @return the square root of 'a'
     */
    public int sqrt(int a) {
        return (int) Math.sqrt(a);
    }
}

/**
 * This class extends the 'advanceCalc' class and adds a factorial calculation method.
 */
class veryAdvCalc extends advanceCalc {

    /**
     * Calculates the factorial of an integer and returns the result.
     *
     * @param a the integer to calculate the factorial of
     * @return the factorial of 'a'
     */
    public int Factorial(int a) {
        int i = 1;
        int fact = 1;
        while (i <= a) {
            fact = fact * i;
            i++;
        }
        return fact;
    }
}

/**
 * This class demonstrates multi-level inheritance by using the 'veryAdvCalc' class.
 */
public class multiLevelInheritance {
    public static void main(String[] args) {

        veryAdvCalc obj = new veryAdvCalc();

        Scanner a = new Scanner(System.in);
        System.out.print("Enter First Number : ");

        int x = a.nextInt();
        System.out.print("Enter Second Number : ");
        int y = a.nextInt();

        // Perform arithmetic operations and advanced calculations using the 'advCalc' object
        System.out.println(obj.add(x,y));
        System.out.println(obj.sub(x, y));
        System.out.println(obj.mul(x, y));
        System.out.println(obj.div(x, y));
        System.out.println(obj.pow(x, y));
        System.out.print("Enter a value to get square root : ");
        int z = a.nextInt();

        System.out.println(obj.sqrt(z));
        System.out.print("Enter a value to get Factorial : ");
        int f = a.nextInt();
        System.out.println(obj.Factorial(f));

    }
}
