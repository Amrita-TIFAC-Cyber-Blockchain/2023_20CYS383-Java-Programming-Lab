package com.amrita.jpl.cys21064.pract.filehandling;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class demonstrates writing to a file in Java.
 * It creates a file named "20cys383.txt" and writes the text "Just in" to it.
 * If the file already exists, its contents will be overwritten.
 * The FileWriter is used to perform the writing operation.
 *
 *
 * @author Rajendraprasad S
 */
public class filewrite {
    /**
     * The main method of the filewrite class.
     * It creates a file and writes the text "Just in" to it.
     * If the file already exists, its contents will be overwritten.
     * The FileWriter is used to perform the writing operation.
     */
    public static void main(String[] args) {
        try {
            FileWriter myFile = new FileWriter("20cys383.txt");
            myFile.write("Content to be written in the file");
            myFile.close();
            System.out.println("The file `20cys383.txt` has been updated successfully.");
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
