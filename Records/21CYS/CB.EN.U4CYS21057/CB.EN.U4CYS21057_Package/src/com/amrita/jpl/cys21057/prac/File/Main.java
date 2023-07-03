package com.amrita.jpl.cys21057.prac.File;

import java.io.*;
import java.util.Scanner;

/**
 * This is a program for reading and writing a file.
 *
 * Author: Pushpanth
 * Version: 0.1
 */
public class Main {
    public static void main(String[] args) {
        try {
            File myFile = new File("C:\\Users\\pushp\\OneDrive\\Desktop\\cys21057.txt");
            FileWriter obj = new FileWriter(myFile);

            Scanner sc = new Scanner(myFile);

            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }

            while (sc.hasNextLine()) {
                String text = sc.nextLine();
                System.out.println(text);
            }
            sc.close();

            obj.write("The file is created");
            obj.close();
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
