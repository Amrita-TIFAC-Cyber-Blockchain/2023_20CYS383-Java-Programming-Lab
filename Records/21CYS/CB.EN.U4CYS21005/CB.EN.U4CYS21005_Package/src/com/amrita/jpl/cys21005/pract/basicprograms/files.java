package com.amrita.jpl.cys21005.pract.basicprograms; /**
 * @author Alagu Soundarya G
 * @version 1.0
 * A Java program to print student grade
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class files {
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("[INFO] File Exists.");
            }

            System.out.println("Static contents are added to the file.");
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("Writeable: " + myFile.canWrite());
            System.out.println("Readable " + myFile.canRead());
            System.out.println("File size in bytes " + myFile.length());
            System.out.println("Hash Code" + myFile.hashCode());

        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
        try {
            FileWriter myWrite = new FileWriter("20cys383.txt");
            myWrite.write("Hello Soundarya");
            myWrite.close();
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
        try {
            File myFile = new File("20cys383.txt");
            Scanner myScan = new Scanner(myFile); //usually System.in will be given instead of myFile
            while (myScan.hasNextLine()) {
                String data = myScan.nextLine();
                System.out.println("File content: " + data);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }

    }
}