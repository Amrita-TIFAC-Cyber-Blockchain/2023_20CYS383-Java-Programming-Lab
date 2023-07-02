package com.amrita.jpl.cys21016.pract.filehandling;
/***
 * File handling in JAVA.
 * @author Hem Sagar
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class filehandling {
    public static void main(String[] args) {
        /**
         * @param args -> commandline Arguments*/

        try {
            FileWriter filein = new FileWriter("20cys283.txt");
            filein.write("Hello World! \nThis is Hem Sagar!.");
            filein.close();
        }catch(IOException e){
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
       
    }
}