package com.amrita.jpl.cys21064.pract.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class demonstrates reading from a file in Java.
 * It reads the contents of a file and prints them to the console.
 * The file name is hardcoded as "20cys383.txt".
 *
 * @author Rajendraprasad S
 */
public class fileread {
    /**
     * The main method of the fileread class.
     * It reads the contents of a file and prints them to the console.
     * The file name is hardcoded as "20cys383.txt".
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            Scanner read = new Scanner(myFile);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
