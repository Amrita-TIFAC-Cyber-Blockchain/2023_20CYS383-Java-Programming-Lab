/**
 * The FileHandling class demonstrates file creation, writing, reading, and file properties retrieval.
 * It creates a file, writes content into it, reads the file, and retrieves various properties of the file.
 * The file name used is "20cys383.txt".
 *
 * Note: Uncomment the code block for writing into the file before running.
 *       Also, make sure to provide appropriate file permissions for read and write operations.
 *       The file should be in the same directory as the program.
 *       The file path can be adjusted accordingly if needed.
 *
 * @author Yaswanth Gadamsetti
 */
package com.amrita.jpl.cys21089.pract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File exists.");
            }

            // Reading the file.
            try {
                File myFileRead = new File("20cys383.txt");
                Scanner myScan = new Scanner(myFileRead);
                System.out.println("Contents of the file:");
                while (myScan.hasNextLine()) {
                    String data = myScan.nextLine();
                    System.out.println(data);
                }
                myScan.close();
            } catch (IOException e) {
                System.out.println("[ERROR] Input Output Exception");
                e.printStackTrace();
            }

            // Retrieving file properties.
            System.out.println("File properties:");
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writable: " + myFile.canWrite());
            System.out.println("Readable: " + myFile.canRead());
            System.out.println("File size in bytes: " + myFile.length());
            System.out.println("Hash Code: " + myFile.hashCode());
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}
