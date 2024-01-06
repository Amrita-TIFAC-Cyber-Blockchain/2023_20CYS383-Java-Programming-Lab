package com.amrita.jpl.cys21015.ex;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class FileTransferServer extends FileTransfer implements FileTransferListener {

    public byte[] start()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started and listening on port 12345...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            byte[] buffer = new byte[1024];
            int bytesRead;
            InputStream inputStream = clientSocket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();

            return new byte[0];
        }
    }

    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();
        byte[] fileData = server.start();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Save as filename: ");
        String filename = scanner.next();
        server.saveFile(fileData,filename);
    }

    @Override
    public void saveFile(byte[] fileData, String filename) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        onFileSaved(filename);
    }

    @Override
    public void onFileSent(String filename) {
        // not applicable for server
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File saved: " + filename);
    }
}