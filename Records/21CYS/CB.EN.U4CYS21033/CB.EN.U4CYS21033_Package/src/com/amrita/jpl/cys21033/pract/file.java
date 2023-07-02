package com.amrita.jpl.cys21033.pract;
/**
 * @author Suhitha K
 * @param Files in java
 * @return
 * @version 0.5
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class file {
    public static void main(String[] args) {
        try {
            File myFile = new File("20cys383.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
                FileWriter mywrite=new FileWriter("C:/Users/Suhitha/javalab/20cys383.txt");
                mywrite.write("Suhitha");
                mywrite.close();
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

