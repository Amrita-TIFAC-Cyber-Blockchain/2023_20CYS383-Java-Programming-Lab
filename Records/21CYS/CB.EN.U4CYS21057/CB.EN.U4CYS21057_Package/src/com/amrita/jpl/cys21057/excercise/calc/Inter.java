package com.amrita.jpl.cys21057.excercise.calc;

/**
 * This a Basic Calculator Program using Interface
 *
 * Author - Pushpanth
 * Version - 0.1
*/
interface Calculator{
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class BasicCalculator implements Calculator{

    public double add(double a, double b) {
        return a + b;
    }


    public   double subtract(double a, double b) {
        return a - b;
    }


    public double multiply(double a, double b) {
        return a * b;
    }


    public double divide(double a, double b) {

        if(b == 0){
            System.out.println("Division by zero error!");
            return -1;
        }else
            return a / b;
    }
}


public class Inter {
    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();


        System.out.println("Addition: " + obj.add(86.0, 72.0));

        System.out.println("Subtraction: " + obj.subtract(86.0, 72.0));

        System.out.println("Multiplication: " + obj.multiply(86.0, 72.0));

        System.out.println("Division: " + obj.divide(86.0, 72.0));

    }
}