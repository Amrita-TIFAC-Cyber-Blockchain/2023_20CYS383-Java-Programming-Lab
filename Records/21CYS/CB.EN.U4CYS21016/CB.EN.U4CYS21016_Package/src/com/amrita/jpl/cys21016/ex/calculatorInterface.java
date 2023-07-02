package com.amrita.jpl.cys21016.ex;
/**
 * An interface based program to implement a calculator.
 * @author Hem Sagar
 * @version 1.0
 * */
import java.util.Scanner;

interface Calculator{
    /*
    * Interface named Calculator that has function add,subtract,multiply,divide*/
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}
class BasicCalculator implements Calculator {
    /**
     * BasicCalculator class that implements the functions with it's logic from the interface Calculator*/
    @Override
    public double add(double a, double b) {
        /**
         * It adds two given numbers
         * @param a -> operand1
         * @param b -> operand2
         * @return a+b -> sum of a and b*/
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        /**
         * It subtracts two given numbers
         * @param a -> operand1
         * @param b -> operand2
         * @return a-b -> difference of a and b*/
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        /**
         * It multiplies two given numbers
         * @param a -> operand1
         * @param b -> operand2
         * @return a*b -> product of a and b*/
        return a * b;
    }

    @Override
    public double divide(double a, double b){
        /**
         * It divides two given numbers if the given denominator is not 0 else prints error.
         * @param a -> operand1
         * @param b -> operand2
         * @return a/b -> quotient of a divided by b*/
        if (b == 0) {
            System.out.println("Division by zero error!");
            return -1;
        }
        return a / b;
    }
}
public class calculatorInterface {
    public static void main(String[] args) {
        /**
        * main function that instantiates and performs the add,subtract,multiply,divide functions for provided numbers..
        * @param args -> commandline arguments*/

        Scanner input = new Scanner(System.in);
        BasicCalculator calculator = new BasicCalculator();
        double num1  = input.nextDouble();
        double num2  = input.nextDouble();

        double sum = calculator.add(num1, num2);
        System.out.println("Addition: " + sum);

        double difference = calculator.subtract(num1, num2);
        System.out.println("Subtraction: " + difference);

        double product = calculator.multiply(num1, num2);
        System.out.println("Multiplication: " + product);

        double quotient = calculator.divide(num1, num2);
        System.out.println("Division: " + quotient);
    }
}
