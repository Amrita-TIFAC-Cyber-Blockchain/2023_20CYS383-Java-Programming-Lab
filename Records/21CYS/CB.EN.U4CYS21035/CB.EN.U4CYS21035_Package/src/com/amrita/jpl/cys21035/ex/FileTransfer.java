package com.amrita.jpl.cys21035.ex;

abstract class FileTransfer {
    abstract void saveFile(byte[] fileData, String filename);

    void sendFile(String filename) {
        System.out.println("Sending file: " + filename);
    }
}