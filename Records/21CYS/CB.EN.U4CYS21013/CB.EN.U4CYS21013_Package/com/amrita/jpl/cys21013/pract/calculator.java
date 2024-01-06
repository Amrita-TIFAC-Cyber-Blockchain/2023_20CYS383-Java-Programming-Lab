import java.util.Scanner;
/**
 * A simple calculator program with the operations of addition, subtraction, multiplication, division.
 * @author rohit
 * @version 1.0
 */

/**
 * The Calc interface defines basic arithmetic operations.
 */
interface Calc {
    void add(int a, int b);
    void subtract(int a, int b);
    void multiply(int a, int b);
    void divide(int a, int b);
}

/**
 * The BasicCalc class implements the Calc interface.
 * It provides the implementation for basic arithmetic operations.
 */
class BasicCalc implements Calc {
    @Override
    public void add(int a, int b) {
        int result = a + b;
        System.out.println("Sum: " + result);
    }

    @Override
    public void subtract(int a, int b) {
        int result = a - b;
        System.out.println("Difference: " + result);
    }

    @Override
    public void multiply(int a, int b) {
        int result = a * b;
        System.out.println("Product: " + result);
    }

    @Override
    public void divide(int a, int b) {
        if (b != 0) {
            int result = a / b;
            System.out.println("Quotient: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

/**
 * The Main class is the entry point of the program.
 * It takes user input for two numbers and performs arithmetic operations using the BasicCalc.
 */
public class calculator {
    /**
     * The main method is the entry point of the program.
     * It takes user input for two numbers and performs arithmetic operations based on the user's choice.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for two numbers
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();

        // Create an instance of BasicCalc
        Calc calculator = new BasicCalc();

        // Display menu options
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        // Perform the selected arithmetic operation
        switch (choice) {
            case 1:
                calculator.add(a, b);
                break;
            case 2:
                calculator.subtract(a, b);
                break;
            case 3:
                calculator.multiply(a, b);
                break;
            case 4:
                calculator.divide(a, b);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
