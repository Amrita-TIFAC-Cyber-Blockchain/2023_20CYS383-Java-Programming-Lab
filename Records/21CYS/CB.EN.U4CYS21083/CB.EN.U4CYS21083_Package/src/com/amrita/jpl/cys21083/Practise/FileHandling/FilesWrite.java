package com.amrita.jpl.cys21083.Practise.FileHandling;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

public class FilesWrite {
    public static void main(String[] args) {
        try {
            FileWriter write = new FileWriter("20cys383.txt");
            write.write("Writing First file in java hurray!..");
            write.close();
            System.out.println("Successfull");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}