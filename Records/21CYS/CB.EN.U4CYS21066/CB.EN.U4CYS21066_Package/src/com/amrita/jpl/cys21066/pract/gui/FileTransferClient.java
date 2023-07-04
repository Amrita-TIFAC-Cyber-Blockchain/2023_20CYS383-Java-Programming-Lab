package com.amrita.jpl.cys21066.pract.gui;

import java.io.*;
import java.net.Socket;

public class FileTransferClient extends FileTransfer {
    private final String serverAddress;
    private final int serverPort;

    public FileTransferClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        // Client doesn't save the file, only sends it to the server
    }

    public void sendFile(String filename) {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(filename);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            fileInputStream.close();
            outputStream.close();
            socket.close();

            onFileSent(filename);
        } catch (IOException e) {
            System.out.println("Error sending file: " + e.getMessage());
        }
    }

    private void onFileSent(String filename) {
    }

    public static void main(String[] args) {
        FileTransferClient client = new FileTransferClient("localhost", 8080);
        client.sendFile("file.txt");
    }
}
