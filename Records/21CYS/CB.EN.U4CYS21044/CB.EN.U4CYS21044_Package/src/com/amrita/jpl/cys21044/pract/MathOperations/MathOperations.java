package com.amrita.jpl.cys21044.pract.MathOperations;
import java.util.Scanner;
/**
*@author ravi
*/

class MathOperations {
    MathOperations() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        int sum = a + b;
        int diff1 = a - b;
        int diff2 = b - a;
        int div = a / b;
        int mul = a * b;
        int square1 = a * a;
        int square2 = b * b;
        /**
        *@param a- first input number
        *@param b- second input number
        *@param diff1- difference when b substracted from a
        *@param diff2- difference when a substracted from b
        *@param div- result of a divided by b
        *@param mul -result of multiplication
        *@param square1- result of a square
        *@param square2-result of b square
        */
        System.out.println("Sum: " + sum);
        System.out.println("a-b: " + diff1);
        System.out.println("b-a: " + diff2);
        System.out.println("div: " + div);
        System.out.println("mul: " + mul);
        System.out.println("a^2: " + square1);
        System.out.println("b^2: " + square2);

        int largest;
        if (a > b) {
            largest = a;
        } else {
            largest = b;
        }

        System.out.println("The largest number is: " + largest);
    }
}

