package com.amrita.jpl.cys21010.practice.assigmentServerCli;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private FileTransferListener listener;
    private String saveDirectory;

    public FileTransferServer(FileTransferListener listener, String saveDirectory) {
        this.listener = listener;
        this.saveDirectory = saveDirectory;
    }

    public void sendFile(String filename) {
        // Server does not implement sending files
    }

    public void saveFile(byte[] fileData, String filename) {
        String filePath = saveDirectory + File.separator + filename; // Create the full file path
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            listener.onFileSaved(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Listening on port 1234...");

            clientSocket = serverSocket.accept();
            saveFileFromSocket(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFileFromSocket(Socket socket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String filename = dataInputStream.readUTF();
            long fileSize = dataInputStream.readLong();
            byte[] fileData = new byte[(int) fileSize];
            dataInputStream.readFully(fileData);

            saveFile(fileData, filename);

            dataInputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String saveDirectory = ".";
        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Not used in the server
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };

        FileTransferServer server = new FileTransferServer(listener, saveDirectory);
        server.start();
    }
}
