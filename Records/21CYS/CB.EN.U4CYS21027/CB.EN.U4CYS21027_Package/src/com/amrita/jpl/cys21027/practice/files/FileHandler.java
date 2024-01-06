package com.amrita.jpl.cys21027.practice.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The `FileHandler` class demonstrates how to create and manipulate files in Java.
 * It provides methods to create a file, check its properties, and write content to the file.
 * This class serves as a basic example for file handling operations.
 *
 * Usage:
 * - The program creates a new file with a specified name.
 * - It checks if the file already exists and displays a corresponding message.
 * - It provides information about the file's absolute path, write/read permissions, size, and hash code.
 * - It writes content to the file using the `FileWriter` class.
 * - The commented section shows an example of reading a file using the `Scanner` class.
 *
 * Note: This example assumes that the file can be created in the specified location and that file permissions are granted.
 *
 * Dependencies:
 * - None
 *
 * Author: K Sri Sai Nitin
 * Version: 0.5
 */
public class FileHandler {
    public static void main(String[] args) {
        /**
         * The main method is the entry point of the program.
         * It demonstrates how to create and manipulate files in Java.
         *
         * @param args The command line arguments (not used).
         */

        try {
            File myFile = new File("20cys383.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }

            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writable: " + myFile.canWrite());
            System.out.println("Readable: " + myFile.canRead());
            System.out.println("File size in bytes: " + myFile.length());
            System.out.println("Hash Code: " + myFile.hashCode());

            FileWriter myWriter = new FileWriter("20cys383.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();

            // Uncomment the section below to see an example of reading a file using the `Scanner` class.
            /*
            File myFile = new File("example.txt");
            Scanner myScan = new Scanner(myFile);
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                System.out.println(line);
            }
            myScan.close();
            */
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
