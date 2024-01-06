package com.amrita.jpl.cys21085.pract;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program counts the number of words in a given sentence.
 * A word is defined as a sequence of non-space characters separated by spaces.
 */
import java.util.Scanner;
public class WordCount {

    /**
     * The main method allows the user to input a sentence and counts the number of words in it.
     * It splits the sentence into individual words using whitespace as the delimiter,
     * and then counts the number of resulting words.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Split the sentence into individual words using whitespace as the delimiter
        String[] words = sentence.trim().split("\\s+");

        // Count the number of words
        int wordCount = words.length;
        System.out.println("Number of words: " + wordCount);
    }
}
