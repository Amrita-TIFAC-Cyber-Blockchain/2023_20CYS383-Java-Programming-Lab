package com.amrita.jpl.cys21019.pract.basic;


/**
*
* @author Gokulachselvan C D
*
*/
/**
 * This class calculates the Fibonacci sequence.
 */
public class FibonacciCalculator {
    
    /**
     * Calculates the Fibonacci sequence up to a specified number of terms.
     *
     * @param numTerms The number of terms in the Fibonacci sequence to calculate.
     * @return An array containing the Fibonacci sequence up to the specified number of terms.
     */
    public int[] calculateFibonacciSequence(int numTerms) {
        int[] sequence = new int[numTerms];
        
        if (numTerms >= 1) {
            sequence[0] = 0;
        }
        if (numTerms >= 2) {
            sequence[1] = 1;
        }
        
        for (int i = 2; i < numTerms; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        
        return sequence;
    }
    
    /**
     * Prints the Fibonacci sequence.
     *
     * @param sequence The Fibonacci sequence to print.
     */
    public void printFibonacciSequence(int[] sequence) {
        System.out.println("Fibonacci Sequence:");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method to test the FibonacciCalculator class.
     */
    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int numTerms = 10;
        int[] sequence = calculator.calculateFibonacciSequence(numTerms);
        calculator.printFibonacciSequence(sequence);
    }
}
