package com.amrita.jpl.cys21057.prac.AbsCalc;

/**
 * This a Basic Calculator Program using Abstract class
 *
 * Author - Pushpanth
 * Version - 0.1
 */

abstract class Totaliser {
    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b);


}


class Ab extends Totaliser {

    public double add (double a, double b) {
        return a + b;
    }

    public   double subtract(double a, double b) {
        return a - b;
    }


    public double multiply(double a, double b) {
        return a * b;
    }


    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Can't divide by zero");
        }
        return a / b;
    }
}

// Usage
public class Abs {
    public static void main(String[] args) {
        Ab obj = new Ab();

        System.out.println("Result: " + obj.add(1, 2));

        System.out.println("Subtraction: " + obj.subtract(1, 2));

        System.out.println("Multiplication: " + obj.multiply(1, 2));

        System.out.println("Division: " + obj.divide(1, 2));

    }
}
