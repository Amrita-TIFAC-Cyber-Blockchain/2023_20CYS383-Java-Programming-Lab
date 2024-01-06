package com.amrita.jpl.cys21061.ex.filecreation;

import java.io.File;
import java.io.IOException;

/**
* @author Roshni-CYS21061
*/

public class Main {
    public static void main(String[] args) {
        /**
         * creates a file integers
         * @param myfile filename
         */
        try {
            File myFile = new File("20cys383.txt");

            if (myFile.createNewFile()) {
                System.out.println("[INFO] File Created.");
            } else {
                System.out.println("[INFO] File Already Exists.");
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
