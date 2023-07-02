package com.amrita.jpl.cys21019.pract.basic;

/**
*
* @author Gokulachselvan C D
*
*/

/**
 * This class checks whether a number is an Armstrong number or not.
 */
public class AmstrongNumberChecker {

    /**
     * Checks whether a given number is an Armstrong number.
     *
     * @param number The number to check.
     * @return true if the number is an Armstrong number, false otherwise.
     */
    public boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }

        return originalNumber == sum;
    }

    /**
     * Main method to test the ArmstrongNumberChecker class.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        AmstrongNumberChecker checker = new AmstrongNumberChecker();
        int number = 153;

        if (checker.isArmstrongNumber(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
