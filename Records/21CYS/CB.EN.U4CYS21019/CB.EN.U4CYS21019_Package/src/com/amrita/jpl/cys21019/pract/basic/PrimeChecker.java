package com.amrita.jpl.cys21019.pract.basic;

/**
*
* @author Gokulachselvan C D
*
*/

/**
 * This class checks whether a number is prime or not.
 */
public class PrimeChecker {

    /**
     * Checks whether a given number is prime.
     *
     * @param number The number to check for primality.
     * @return true if the number is prime, false otherwise.
     */
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method to test the PrimeChecker class.
     */
    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();
        int number = 17;
        if (checker.isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
