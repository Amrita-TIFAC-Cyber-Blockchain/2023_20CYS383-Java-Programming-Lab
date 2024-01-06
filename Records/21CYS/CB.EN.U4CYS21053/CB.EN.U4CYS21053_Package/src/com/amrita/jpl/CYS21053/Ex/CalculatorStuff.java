/**
 * @author Nived Dineshan
 */

package com.amrita.jpl.CYS21053.Ex;

import java.util.Scanner;


interface Calculator{
    public double add(double a,double b);
    public double subtract(double a,double b);
    public double multiply(double a,double b);
    public double divide(double a,double b);
}

class BasicCalculator implements Calculator{

    /**
     * add function
     * @param double a, double b-> numbers to add
     * @return a+b-> the sum of the two numbers is returned
     */
    public double add(double a,double b){
        return a+b;
    }
    /**
     * subtract function
     * @param double a, double b-> numbers to subtract
     * @return a-b-> the difference of the two numbers is returned
     */
    public double subtract(double a,double b){
        return a-b;
    }
    /**
     * multiply function
     * @param double a, double b-> numbers to multiply
     * @return a*b-> the product of the two numbers is returned
     */
    public double multiply(double a,double b){
        return a*b;
    }
    /**
     * divide function
     * @param double a, double b-> numbers to divide
     * @return a/b-> the quotient of the two numbers is returned.Error message is printed if b=0 and -1 is returned
     */
    public double divide(double a,double b){
        if(b!=0){
            return a/b;
        }

        else{
            System.out.println("Division by zero error!");
            return -1.0;
        }
    }

}

/**
 * main function
 */
public class CalculatorStuff{
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        double num1 = obj.nextDouble();
        double num2 = obj.nextDouble();

        BasicCalculator Obj1= new BasicCalculator();

        double result1 = Obj1.add(num1, num2);
        System.out.println("Addition: " + result1);

        double result2 = Obj1.subtract(num1, num2);
        System.out.println("Subtraction: " + result2);

        double result3 = Obj1.multiply(num1, num2);
        System.out.println("Multiplication: " + result3);

        double result4 = Obj1.divide(num1, num2);
        System.out.println("Division: " + result4);
    }
}