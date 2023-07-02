package com.amrita.jpl.cys21022.pract.chat;

import java.io.*;
import java.net.*;

abstract class Filetransfer {
    void sendFile(String filename) throws IOException {
        byte[] fileData = readFileData(filename);
        saveFile(fileData, filename);
    }

    abstract void saveFile(byte[] fileData, String filename);

    private byte[] readFileData(String filename) throws IOException {
        try {
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
            fileInputStream.close();
            return fileData;
        } catch (IOException e) {
            throw new IOException("Failed to read file: " + filename, e);
        }
    }
}

interface ClientFileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

class FileTransferClient extends Filetransfer implements
        FileTransferListener {
    private Socket socket;

    public FileTransferClient(String serverAddress, int serverPort) throws
            IOException {
        try {
            socket = new Socket(serverAddress, serverPort);
        } catch (IOException e) {
            throw new IOException("Failed to connect to the server.", e);
        }
    }

    @Override
    void sendFile(String filename) throws IOException {
        super.sendFile(filename);
        onFileSent(filename);
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("File sent to the server: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
    }
}

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            FileTransferClient client = new FileTransferClient(SERVER_IP,
                    SERVER_PORT);
            client.sendFile("file.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while sending the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



