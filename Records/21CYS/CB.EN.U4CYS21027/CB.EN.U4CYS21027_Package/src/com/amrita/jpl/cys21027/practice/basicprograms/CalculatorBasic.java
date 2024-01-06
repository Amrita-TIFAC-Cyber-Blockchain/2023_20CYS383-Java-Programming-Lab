/**

 * The CalculatorBasic class is a simple calculator program that performs basic arithmetic operations on two numbers.
 * @author K Sri Sai Nitin
 * @version 0.5

 */
package com.amrita.jpl.cys21027.practice.basicprograms;
import java.util.Scanner;

public class CalculatorBasic {
    /**
     * The main method allows users to input two numbers and an arithmetic operator, and performs the corresponding operation.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Simple Calculator\n");

        System.out.print("Enter the 1st number: ");
        int a = scanner.nextInt();

        System.out.print("Enter the 2nd number: ");
        int b = scanner.nextInt();

        System.out.println("Select operation to perform: ");
        char op = scanner.next().charAt(0);

        int res;

        switch(op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Division by 0 not possible !! Please enter valid b value.");
                    return;
                }
                res = a / b;
                break;
            default:
                System.out.println("Error! Please enter the correct operator!!");
                return;
        }

        System.out.println(a + " " + op + " " + b + " = " + res);
    }
}