package com.amrita.jpl.cys21030.practice;

abstract class abstractclasscalculator {
    abstractclasscalculator() {
    }

    public double calculate(double num1, double num2, String operator) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0.0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
        }

        return result;
    }
}
