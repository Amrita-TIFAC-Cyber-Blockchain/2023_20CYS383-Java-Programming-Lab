package com.amrita.jpl.cys21066.pract.gui;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferServer extends FileTransfer {
    private final int serverPort;

    public FileTransferServer(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();
            onFileSaved(filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void onFileSaved(String filename) {
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started. Listening on port " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();

                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, bytesRead);
                }

                String filename = "received_file.txt";
                saveFile(buffer.toByteArray(), filename);

                buffer.close();
                inputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer(8080);
        server.start();
    }
}
