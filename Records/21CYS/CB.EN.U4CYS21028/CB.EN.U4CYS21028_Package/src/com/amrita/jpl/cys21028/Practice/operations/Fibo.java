package com.amrita.jpl.cys21028.Practice.operations;
class FibonacciExample1 {

    /**

     The main method is the entry point of the program.

     @param args the command-line arguments
     */
    public static void main(String args[]) {
        int n1 = 0, n2 = 1, n3, i, count = 10;

// Print the initial Fibonacci numbers
        System.out.print(n1 + " " + n2);
        for (i = 2; i < count; ++i) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}