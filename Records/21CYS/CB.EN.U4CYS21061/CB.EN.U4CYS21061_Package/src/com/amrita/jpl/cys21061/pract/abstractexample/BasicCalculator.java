package com.amrita.jpl.cys21061.pract.abstractexample;
/**
 * @author Roshni-CYS21061
 */
/**
 * Represents an addition calculator.
 */
class AdditionCalculator extends Calculator {
    @Override
    double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

/**
 * Represents a subtraction calculator.
 */
class SubtractionCalculator extends Calculator {
    @Override
    double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

/**
 * Represents a multiplication calculator.
 */
class MultiplicationCalculator extends Calculator {
    @Override
    double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

/**
 * Represents a division calculator.
 */
class DivisionCalculator extends Calculator {
    @Override
    double calculate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
