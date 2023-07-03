package com.amrita.jpl.cys21063.pract;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Abstract class representing the file transfer functionality
abstract class FileTransfer {
    public FileTransferListener listener;

    // Set the file transfer listener
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

    // Send a file to the server
    public void sendFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }

        try {
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedInputStream.read(fileData, 0, fileData.length);
            bufferedInputStream.close();

            saveFile(fileData, file.getName());

            if (listener != null) {
                listener.onFileSent(file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error sending file: " + e.getMessage());
        }
    }

    // Abstract method to save the file data on the server
    abstract void saveFile(byte[] fileData, String filename);
}

// Interface for file transfer listeners
interface FileTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

// FileTransferClient class implementing the client-side functionality
class FileTransferClient extends FileTransfer {
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Not implemented for the client-side
    }
}

// FileTransferServer class implementing the server-side functionality
class FileTransferServer extends FileTransfer {
    private int port;

    public FileTransferServer(int port) {
        this.port = port;
    }

    // Start the server and listen for incoming file transfers
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    // Save the received file data on the server's disk
    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            if (listener != null) {
                listener.onFileSaved(filename);
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Thread for handling client connections
    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String filename = dataInputStream.readUTF();
                int fileSize = dataInputStream.readInt();
                byte[] fileData = new byte[fileSize];
                dataInputStream.readFully(fileData, 0, fileSize);

                saveFile(fileData, filename);

                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }
}

public class FileTransfer1 {
    public static void main(String[] args) {
        FileTransferClient client = new FileTransferClient();
        FileTransferServer server = new FileTransferServer(1234);

        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("File sent: " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };

        client.setListener(listener);
        server.setListener(listener);

        // Send a file from the client to the server
        client.sendFile("path/to/file.txt");

        // Start the server to receive file transfers
        server.start();
    }
}
