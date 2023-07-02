package com.amrita.jpl.cys21045.practice.files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The File1 class demonstrates file operations in Java.
 */
public class File1 {

    /**
     * The main method creates a file, performs file operations, and displays information about the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        try {
            File myFile = new File("dharmik.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }
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