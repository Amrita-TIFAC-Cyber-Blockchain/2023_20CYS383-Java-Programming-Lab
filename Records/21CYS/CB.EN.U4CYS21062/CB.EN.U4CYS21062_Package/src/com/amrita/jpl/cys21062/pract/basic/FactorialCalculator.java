package com.amrita.jpl.cys21062.pract.basic;

public class FactorialCalculator {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        int number = 30;
        int factorial = calculator.calculateFactorial(number);
        System.out.println("Factorial of " + number + ": " + factorial);
    }

    public int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
