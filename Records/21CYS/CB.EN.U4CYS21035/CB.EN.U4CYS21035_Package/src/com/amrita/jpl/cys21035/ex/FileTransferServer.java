package com.amrita.jpl.cys21035.ex;

import java.io.*;
import java.net.*;



class FileTransferServer extends FileTransfer implements FileTransferListener {

    private static final int PORT = 4424;
    private static final int BUFFER_SIZE = 1024;
    @Override
    void saveFile(byte[] fileData, String filename) {
        System.out.println("Saving file: " + filename);
        onFileSaved(filename);
    }

    void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket socket = serverSocket.accept();
                new FileReceiver(socket).start();
            }
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

    private class FileReceiver extends Thread {
        private Socket socket;

        FileReceiver(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = socket.getInputStream();
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] fileData = outputStream.toByteArray();
                String filename = "summa.txt";
                saveFile(fileData, filename);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();
        server.start();
    }
}

