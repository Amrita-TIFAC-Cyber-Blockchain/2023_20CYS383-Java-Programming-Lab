package com.amrita.jpl.cys21062.pract.basic;

public class FibonacciCalculator {
    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int numTerms = 16;

        int[] sequence = calculator.calculateFibonacciSequence(numTerms);
        calculator.printFibonacciSequence(sequence);
    }

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

    public void printFibonacciSequence(int[] sequence) {
        System.out.println("Fibonacci Sequence:");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
