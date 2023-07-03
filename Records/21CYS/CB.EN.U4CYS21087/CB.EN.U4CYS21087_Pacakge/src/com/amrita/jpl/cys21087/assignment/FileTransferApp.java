package com.amrita.jpl.cys21087.assignment;

import java.io.*;
import java.net.*;

abstract class FileTransfer {
    public void sendFile(String filename) {
        File file = new File(filename);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("error: invalid file");
            return;
        }

        try {
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
            fileInputStream.close();

            saveFile(fileData, filename);
        } catch (IOException e) {
            System.out.println("error: failed to send file");
        }
    }

    abstract void saveFile(byte[] fileData, String filename);
}

interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

class FileTransferClient extends FileTransfer implements FileTransferListener {
    private Socket clientSocket;
    private DataOutputStream dataOutputStream;

    public FileTransferClient() {
        try {
            clientSocket = new Socket("localhost", 8886);
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("error: failed to connect to the server");
        }
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            dataOutputStream.writeUTF(filename);
            dataOutputStream.writeInt(fileData.length);
            dataOutputStream.write(fileData);
            dataOutputStream.flush();

            onFileSent(filename);

            clientSocket.close();
            dataOutputStream.close();
        } catch (IOException e) {
            System.out.println("error: failed to send file");
        }
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("file sent: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
    }
}

class FileTransferServer extends FileTransfer implements FileTransferListener {
    private ServerSocket serverSocket;

    public FileTransferServer() {
        try {
            serverSocket = new ServerSocket(8886);
        } catch (IOException e) {
            System.out.println("error: failed to start the server");
        }
    }

    public void start() {
        try {
            Socket clientSocket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

            String filename = dataInputStream.readUTF();
            int fileSize = dataInputStream.readInt();
            byte[] fileData = new byte[fileSize];
            dataInputStream.readFully(fileData);

            saveFile(fileData, filename);

            clientSocket.close();
            dataInputStream.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("error: failed to receive file");
        }
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            onFileSaved(filename);
        } catch (IOException e) {
            System.out.println("error: failed to save file");
        }
    }

    @Override
    public void onFileSent(String filename) {
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("file saved: " + filename);
    }
}

public class FileTransferApp {
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();
        Thread serverThread = new Thread(() -> {
            server.start();
        });
        serverThread.start();

        try {
            Thread.sleep(1000); // Delay to ensure server is up and running
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Server started.");

        FileTransferClient client = new FileTransferClient();
        String filePath = "/home/vexecute/chaos.txt"; // Modify the file path accordingly
        client.sendFile(filePath);

        System.out.println("Client connected.");
    }
}



