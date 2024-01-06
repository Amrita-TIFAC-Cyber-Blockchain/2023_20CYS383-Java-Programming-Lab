package Com.Amrita.Jpl.cys21082.Exe;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler

import java.util.Scanner;

class Calculator {
    Calculator() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an operator: 1:Addition, 2:Substraction, 3:Multiplication, or 4:Division");
        char operator = input.next().charAt(0);
        System.out.println("Enter first number");
        Double number1 = input.nextDouble();
        System.out.println("Enter second number");
        Double number2 = input.nextDouble();
        Double result;
        switch (operator) {
            case '1':
                result = number1 + number2;
                System.out.println("" + number1 + " + " + number2 + " = " + result);
                break;
            case '2':
                result = number1 - number2;
                System.out.println("" + number1 + " - " + number2 + " = " + result);
                break;
            case '3':
                result = number1 * number2;
                System.out.println("" + number1 + " * " + number2 + " = " + result);
                break;
            case '4':
                result = number1 / number2;
                System.out.println("" + number1 + " / " + number2 + " = " + result);
                break;
            default:
                System.out.println("Invalid operator!");
        }

        input.close();
    }
}
