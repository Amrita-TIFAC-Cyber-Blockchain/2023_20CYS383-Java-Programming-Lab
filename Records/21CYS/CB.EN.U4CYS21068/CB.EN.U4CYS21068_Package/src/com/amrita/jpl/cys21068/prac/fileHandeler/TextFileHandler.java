package com.amrita.jpl.cys21068.prac.fileHandeler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileHandler implements FileHandler {
    public void uploadFile(String filePath) {
        // Implementation for uploading the file
        System.out.println("File uploaded: " + filePath);
    }

    public void readFile(String filePath) {
        // Implementation for reading the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
