package com.amrita.jpl.cys21027.practice.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Main class demonstrates reading and printing the contents of a file.
 * It uses BufferedReader and FileReader to read the file line by line.
 * This class provides a basic example of file handling in Java.
 *
 * Usage:
 * - The program specifies the file path in the filePath variable.
 * - It creates a BufferedReader and FileReader to read the file.
 * - It reads the file line by line using a while loop.
 * - It prints each line to the console.
 *
 * Note: This example assumes the file exists and is accessible at the specified path.
 *
 * Dependencies:
 * - None
 *
 * Author: K Nitin
 * Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\kssni\\20CYS283\\JPL_21027_FINAL_SUBMISSION\\src\\com\\amrita\\jpl\\cys21027\\practice\\files\\abc.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("The Contents of the file are being printed below.....");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
