package com.amrita.jpl.cys21066.pract.gui;

import java.io.File;

public abstract class FileTransfer {
    public void sendFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Sending file: " + filename);
            byte[] fileData = readFileData(file);
            saveFile(fileData, filename);
        } else {
            System.out.println("File not found: " + filename);
        }
    }

    private byte[] readFileData(File file) {
        // Code to read file data and return as byte array
        return null;
    }

    abstract void saveFile(byte[] fileData, String filename);
}
