package com.amrita.jpl.cys21085.pract;

import java.util.Random;

/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program generates a random password of a specified length.
 * The password can contain a combination of uppercase letters, lowercase letters,
 * digits, and special characters.
 */
public class RandomPasswordGenerator {

    /**
     * The main method generates a random password of a specified length and displays it.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int length = 10; // Set the desired password length
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    /**
     * Generates a random password of the specified length.
     * The password is created using a set of allowed characters.
     *
     * @param length The length of the password to be generated.
     * @return The randomly generated password.
     */
    private static String generatePassword(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        StringBuilder password = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }

    /**
     * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
     * A program to find the maximum number in an array of integers.
     */
    public static class array_max {
        /**
         * The main method is the entry point of the program.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            int[] numbers = {12, 35, 23, 67, 9};
            int max = numbers[0];

            // Find the maximum number
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }

            // Print the maximum number
            System.out.println("Maximum number: " + max);
        }
    }
}
