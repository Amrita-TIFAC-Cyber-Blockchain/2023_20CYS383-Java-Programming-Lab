package com.amrita.jpl.cys21089.ex;

import java.util.Scanner;

interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

class BasicCalculator implements Calculator {

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
        if(num2 == 0){
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        }
        else {
            System.out.println("Division: "+ num1/num2);
        }
        return num1 / num2;
    }
}

public class BasicCalculatorExample {

 public static void main(String[] args){
    Scanner myObj = new Scanner(System.in);
    Calculator calObj = new BasicCalculator();
    double a,b,value;
    a = myObj.nextDouble();
    b = myObj.nextDouble();
    
    value = calObj.add(a,b);
    System.out.println("Addition: " + value);
    value = calObj.subtract(a,b);
    System.out.println("Subtraction: "+ value);
    value = calObj.multiply(a,b);
    System.out.println("Multiplication: "+ value);
    calObj.divide(a,b);
 }
    
}