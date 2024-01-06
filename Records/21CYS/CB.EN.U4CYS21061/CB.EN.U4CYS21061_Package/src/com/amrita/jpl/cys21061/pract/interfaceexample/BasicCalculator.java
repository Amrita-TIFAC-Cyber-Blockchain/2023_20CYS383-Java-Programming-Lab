package com.amrita.jpl.cys21061.pract.interfaceexample;
/**
 * @author Roshni-CYS21061
 */

// Implement the calculator interface
class BasicCalculator implements Calculator {
    BasicCalculator() {
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        } else {
            return num1 / num2;
        }
    }
}