package com.amrita.jpl.cys21035.ex;

import java.io.*;
import java.net.*;

class FileTransferClient extends FileTransfer implements FileTransferListener {

    private static final int PORT = 4424;
    private static final int BUFFER_SIZE = 1024;
    @Override
    void saveFile(byte[] fileData, String filename) {
        System.out.println("Saving file: " + filename);
        onFileSaved(filename);
    }

    @Override
    void sendFile(String filename) {
        super.sendFile(filename);
        try (Socket socket = new Socket("localhost", PORT);
             OutputStream outputStream = socket.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent: " + filename);
            onFileSent(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("File sent: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File saved: " + filename);
    }

    public static void main(String[] args) {
        FileTransferClient client = new FileTransferClient();
        client.sendFile("D:\\Java\\cbenu4cys21035_jpl_final\\summa.txt");
    }
}
