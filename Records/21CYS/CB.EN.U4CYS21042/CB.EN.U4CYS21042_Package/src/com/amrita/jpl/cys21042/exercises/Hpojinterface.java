import java.util.Scanner;

/**
 * @Author : Mittul R
 * @RollNO : CB.EN.U4CYS21042
 */

interface Calculator {
    void add(double num1, double num2);
    void subtract(double num1, double num2);
    void multiply(double num1, double num2);
    void divide(double num1, double num2);
}
class BasicCalculator implements Calculator {
    public void add(double num1, double num2) {
        double result = num1 + num2;
        System.out.println("Addition: " + result);
    }
    public void subtract(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("Subtraction: " + result);
    }
    public void multiply(double num1, double num2) {
        double result = num1 * num2;
        System.out.println("Multiplication: " + result);
    }
    public void divide(double num1, double num2) {
        double result=0;
        result = num1 / num2;
        if(num2==0){
            System.out.println("Division by zero error!");
            result= -1;
        }
        System.out.println("Division: " + result);
    }
}

public class Hpojinterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        Calculator calculator = new BasicCalculator();
        calculator.add(num1, num2);
        calculator.subtract(num1, num2);
        calculator.multiply(num1, num2);
        calculator.divide(num1,num2);
    }
}

