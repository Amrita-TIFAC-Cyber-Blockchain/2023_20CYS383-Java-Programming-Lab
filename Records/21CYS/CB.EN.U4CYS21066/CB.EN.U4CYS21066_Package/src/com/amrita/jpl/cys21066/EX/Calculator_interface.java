package com.amrita.jpl.cys21066.EX;

import java.util.Scanner;

public class Calculator_interface implements Operation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c = 0;
        int operation;

        // Get input for variable A
        System.out.println("Enter A : ");
        a = getInput(sc);

        // Get input for variable B
        System.out.println("Enter B : ");
        b = getInput(sc);

        // Display the available operations
        System.out.println("Enter the operation");
        System.out.println("1.Add");
        System.out.println("2.Subtract");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");

        // Get the operation choice from the user
        operation = (int) getInput(sc);

        // Close the scanner
        sc.close();

        // Perform the selected operation based on the user's choice
        switch (operation) {
            case 1:
                c = Operation.add(a, b);
                break;
            case 2:
                c = Operation.subtract(a, b);
                break;
            case 3:
                c = Operation.multiply(a, b);
                break;
            case 4:
                c = Operation.divide(a, b);
                break;
        }

        // Print the result
        System.out.println("ANSWER IS : " + c);
    }

    // Helper method to get input from the user
    static double getInput(Scanner sc) {
        return sc.nextDouble();
    }
}
