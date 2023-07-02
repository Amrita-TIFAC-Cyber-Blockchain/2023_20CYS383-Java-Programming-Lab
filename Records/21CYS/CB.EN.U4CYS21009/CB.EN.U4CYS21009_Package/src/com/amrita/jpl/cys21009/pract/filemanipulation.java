package com.amrita.jpl.cys21009.pract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File manipulation
 *
 * @author Aravind
 * @version 1
 */

public class filemanipulation {
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            FileWriter mywrite= new FileWriter("20cys83.txt");
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
            System.out.println("File size in bytes " + myFile.length());
            System.out.println("Hash Code" + myFile.hashCode());
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }

        /**
         * @param myFile object which points to file
         * @param args command line arguments
         */
    }
}
