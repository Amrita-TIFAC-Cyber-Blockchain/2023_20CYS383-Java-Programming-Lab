package com.amrita.jpl.cys21054.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A program to demonstrate file handling operations.
 */
public class filehandling {
    /**
     * Creates a file, writes content to it, and performs various file operations.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File myFile = new File("20CYS383.txt");
            FileWriter mywrite = new FileWriter("20CYS383.txt");

            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }

            mywrite.write("Just in");
            mywrite.close();

            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writeable: " + myFile.canWrite());
            System.out.println("Readable: " + myFile.canRead());
            System.out.println("File size in bytes: " + myFile.length());
            System.out.println("Hash Code: " + myFile.hashCode());
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
