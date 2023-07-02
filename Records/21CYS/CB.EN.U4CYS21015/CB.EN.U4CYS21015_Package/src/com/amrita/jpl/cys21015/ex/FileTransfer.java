package com.amrita.jpl.cys21015.ex;

public abstract class FileTransfer {
    public abstract void saveFile(byte[] fileData, String filename);

    public void sendFile(String filename) {
        System.out.println("Sending file: " + filename);
    }
}
