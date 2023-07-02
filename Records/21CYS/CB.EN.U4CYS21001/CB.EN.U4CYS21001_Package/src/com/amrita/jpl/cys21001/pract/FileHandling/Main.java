package com.amrita.jpl.cys21001.pract.FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter mywrite = new FileWriter("D:\\Clg\\Sem 4\\Java\\_18may\\20cys383.txt");
            mywrite.write("Just in");
            mywrite.close();
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
