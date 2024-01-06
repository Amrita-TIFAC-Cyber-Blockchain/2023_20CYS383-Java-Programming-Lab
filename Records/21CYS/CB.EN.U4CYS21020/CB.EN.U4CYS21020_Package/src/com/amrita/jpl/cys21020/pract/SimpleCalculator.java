import java.util.*;

/**
 * @author Hemesh sai
 * @version 1.0
 * The SimpleCalculator class implements a basic calculator functionality for performing arithmetic operations.
 */

public class SimpleCalculator {
    /**
     * The main method of the SimpleCalculator class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the first number
        System.out.println("Please enter the first number: ");
        int a = sc.nextInt();

        // Input the second number
        System.out.println("Please enter the second number: ");
        int b = sc.nextInt();

        // Input the operation to be executed
        System.out.println("Please enter the operation you want to execute: ");
        char ch = sc.next().charAt(0);

        // Perform the selected operation
        switch(ch) {
            case '+' :
                System.out.println(a + b);
                break;
            case '-' :
                System.out.println(a - b);
                break;
            case '*' :
                System.out.println(a * b);
                break;
            case '/' :
                System.out.println(a / b);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
