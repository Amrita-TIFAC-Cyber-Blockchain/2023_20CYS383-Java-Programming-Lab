/**
 * The SimpleCalculator class provides a basic calculator functionality.
 * It allows the user to perform addition, subtraction, multiplication, and division operations.
 * The user can enter the desired operation and input numbers to perform the calculation.
 * The result is displayed to the console.
 * The user can exit the calculator by entering "E".
 *
 * @author Yaswanth Gadamsetti
 */
package com.amrita.jpl.cys21089.pract;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        float a, b, c;
        Scanner myObj = new Scanner(System.in);
        String operation = "";

        while (true) {
            System.out.println("+ -> Addition\n- -> Subtraction\n* -> Multiplication\n/ -> Division\nE -> Exit");
            System.out.println("Enter the operation: ");
            operation = myObj.nextLine();
            if(operation.equals("E")) {
                break;
            }
            System.out.println("Enter the first number: ");
            a = myObj.nextFloat();
            System.out.println("Enter the second number: ");
            b = myObj.nextFloat();
            myObj.nextLine();

            switch (operation) {
                case "+":
                    c = a + b;
                    System.out.println("The sum of the inputs is " + c);
                    break;
                case "-":
                    c = a - b;
                    System.out.println("The difference of the inputs is " + c);
                    break;
                case "*":
                    c = a * b;
                    System.out.println("The product of the inputs is " + c);
                    break;
                case "/":
                    if (b != 0) {
                        c = a / b;
                        System.out.println("The division of the inputs is " + c);
                    } else {
                        System.out.println("Cannot divide by zero");
                    }
                    break;
                default:
                    System.out.println("Invalid option\n");
                    break;
            }
        }
    }
}
