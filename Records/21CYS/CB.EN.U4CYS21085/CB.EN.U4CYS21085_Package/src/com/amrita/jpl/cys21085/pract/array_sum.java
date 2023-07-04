package com.amrita.jpl.cys21085.pract;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * A program to calculate the sum of elements in an array.
 */
class arraySum {
    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};
        int sum = 0;

        // Calculate the sum of elements in the array
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Sum: " + sum);
    }
}
