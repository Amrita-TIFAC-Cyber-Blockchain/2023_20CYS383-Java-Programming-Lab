package com.amrita.jpl.cys21083.Practise.AbstractClass;
import java.util.Scanner;

/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

// operation class is the base class
abstract class operation {
    protected double num1;
    protected double num2;

    /**
     * Constructor for the operation class.
     * @param num1 The first number of the operation.
     * @param num2 The second number of the operation.
     */
    public operation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Performs the calculation based on the specific operation.
     * @return The result of the calculation.
     */
    public abstract double calculate();
}

//addition class inheritated the operation class i.e, sub class
class addition extends operation {
    /**
     * Constructor for the addition class.
     * @param num1 The first number of the addition operation.
     * @param num2 The second number of the addition operation.
     */
    public addition(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 + num2;
    }
}

//subtraction class inheritated the operation class i.e, sub class
class subtraction extends operation {
    /**
     * Constructor for the subtraction class.
     * @param num1 The first number of the subtraction operation.
     * @param num2 The second number of the subtraction operation.
     */
    public subtraction(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 - num2;
    }
}

//Multiplication class inheritated the operation class i.e, sub class
class multiplication extends operation {
    /**
     * Constructor for the multiplication class.
     * @param num1 The first number of the multiplication operation.
     * @param num2 The second number of the multiplication operation.
     */
    public multiplication(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 * num2;
    }
}

//division class inheritated the operation class i.e, sub class
class division extends operation {
    /**
     * Constructor for the division class.
     * @param num1 The first number of the division operation.
     * @param num2 The second number of the division operation.
     */
    public division(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * Divides two numbers.
     * @return The quotient of the division.
     * @throws ArithmeticException if the second number is zero.
     */
    public double calculate() {
        if (num2 == 0){
            System.out.println("A Number Cannot be Divided by Zero");
        }
        return num1 / num2;
    }
}

// MAin Class
public class AbstractClass{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        double num1 = input.nextDouble();
        System.out.println("Enter Second Number: ");
        double num2 = input.nextDouble();
        System.out.println("Enter Operation: ( +, -, *, / )");
        char operator = input.next().charAt(0);
        switch (operator) {
            case '+':
                operation addition = new addition(num1, num2);
                System.out.println("\nAddition:");
                System.out.println("Sum of " + num1 + " & " + num2 + " is " + addition.calculate());
                break;

            case '-':
                operation subtraction = new subtraction(num1, num2);
                System.out.println("\nSubtraction:");
                System.out.println("Subtraction of " + num1 + " & " + num2 + " is " + subtraction.calculate());
                break;

            case '*':
                operation multiplication = new multiplication(num1, num2);
                System.out.println("\nMultiplication:");
                System.out.println("Multiplication of " + num1 + " & " + num2 + " is " + multiplication.calculate());
                break;

            case '/':
                operation division = new division(num1, num2);
                System.out.println("\nDivision:");
                System.out.println("Division of " + num1 + " & " + num2 + " is " + division.calculate());
                break;

            default:
                System.out.println("Choose One of 4 Operators");
                break;
        }
    }
}

