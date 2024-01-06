package com.amrita.jpl.cys21028.exercise;
/**
* @author Hitesh manjunath
*
* */
interface Caluculator {
    double add(double a, double b);
    double sub(double a, double b);
    double mul(double a, double b);
    double div(double a, double b);
}

public class BasicCalculator implements Caluculator {
    public double add(double a, double b) {
        return a+b;
    }


    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
         return a * b;
    }

    public double div(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Division by zero is not true");
            return 0;
        }
    }
}


class BasicCalculatorExample {
    public static void main(String[] args) {
        /**
        * @param args Gives arguements
        * */
        BasicCalculator calculator = new BasicCalculator();

        double res1 = calculator.add(15.1, 13.2);
        System.out.println("Addition: " + res1);

        double res2 = calculator.sub(12.9, 3.3);
        System.out.println("Subtraction: " + res2);

        double res3 = calculator.mul(6.2, 2.5);
        System.out.println("Multiplication: " + res3);

        double res4 = calculator.div(10.0, 3.0);
        if (res4 != 0.0) {
            System.out.println("Division: " + res4);
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        double res5 = calculator.div(10.0, 0.0);
        if (res5!= 0.0) {
            System.out.println("Division: " + res5);
        } else {
            System.out.println("Division by zero .");
        }
    }
}