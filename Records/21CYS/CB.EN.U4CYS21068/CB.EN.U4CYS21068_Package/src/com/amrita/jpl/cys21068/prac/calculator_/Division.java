package com.amrita.jpl.cys21068.prac.calculator_;

class Division extends Calculation {
    /**
     * Performs division of two numbers.
     */
    double calculate(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}