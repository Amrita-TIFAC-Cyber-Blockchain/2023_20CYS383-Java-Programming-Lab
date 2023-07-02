package com.amrita.jpl.cys21047.ex;

import java.util.Scanner;
    interface Calculator {
        double add(double a, double b);
        double subtract(double a, double b);
        double multiply(double a, double b);
        double divide(double a, double b) throws ArithmeticException;
    }


    class SimpleCalculator implements Calculator {
        @Override
        public double add(double a, double b) {
            return a + b;
        }

        @Override
        public double subtract(double a, double b) {
            return a - b;
        }

        @Override
        public double multiply(double a, double b) {
            return a * b;
        }

        @Override
        public double divide(double a, double b) throws ArithmeticException {
            if (b == 0) {
                throw new ArithmeticException("Division by zero error!");
            }
            return a / b;
        }
    }


    public class BasicCalculatorExample {
        public static void main(String[] args) {



            Calculator calculator = new SimpleCalculator();
            Scanner scanner = new Scanner(System.in);


            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();


            double addition = calculator.add(num1, num2);
            double subtraction = calculator.subtract(num1, num2);
            double multiplication = calculator.multiply(num1, num2);
            double division;
            try {
                division = calculator.divide(num1, num2);
                System.out.println("Addition: " + addition);
                System.out.println("Subtraction: " + subtraction);
                System.out.println("Multiplication: " + multiplication);
                System.out.println("Division: " + division);
            } catch (ArithmeticException e) {
                System.out.println("Addition: " + addition);
                System.out.println("Subtraction: " + subtraction);
                System.out.println("Multiplication: " + multiplication);
                System.out.println("Division by zero error!");
                System.out.println("Division: -1.0");
            }
        }
    }