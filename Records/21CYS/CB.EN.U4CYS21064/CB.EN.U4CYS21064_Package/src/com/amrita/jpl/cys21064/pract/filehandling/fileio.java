package com.amrita.jpl.cys21064.pract.filehandling;

import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates file input/output operations in Java.
 * It creates a file, checks its properties, and prints information about it.
 *
 * @author Rajendraprasad S
 */
public class fileio {
    /**
     * The main method of the fileio class.
     * It creates a file, checks its properties, and prints information about it.
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writeable: " + myFile.canWrite());
            System.out.println("Readable " + myFile.canRead());
            System.out.println("File size in bytes " + myFile.length());
            System.out.println("Hash Code" + myFile.hashCode());
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
