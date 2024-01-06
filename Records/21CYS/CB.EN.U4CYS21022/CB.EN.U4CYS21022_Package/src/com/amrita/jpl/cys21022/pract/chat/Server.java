package com.amrita.jpl.cys21022.pract.chat;
import java.io.*;
import java.net.*;

abstract class FileTransfer {
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

interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

class FileTransferServer extends FileTransfer implements
        FileTransferListener {
    private ServerSocket serverSocket;

    public FileTransferServer(int serverPort) throws IOException {
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            throw new IOException("Failed to start the server.", e);
        }
    }

    void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            } catch (IOException e) {
                System.err.println("An error occurred while accepting a client connection: " + e.getMessage() );
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {
                DataInputStream dataInputStream = new
                        DataInputStream(clientSocket.getInputStream());
                String filename = dataInputStream.readUTF();
                int fileSize = dataInputStream.readInt();
                byte[] fileData = new byte[fileSize];
                dataInputStream.readFully(fileData);

                saveFile(fileData, filename);

                clientSocket.close();
            } catch (IOException e) {
                System.err.println("An error occurred while handling a client connection: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new
                    FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();
            onFileSaved(filename);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the file: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onFileSent(String filename) {
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File saved on the server: " + filename);
    }
}

public class Server {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            FileTransferServer server = new
                    FileTransferServer(SERVER_PORT);
            server.start();
        } catch (IOException e) {
            System.err.println("An error occurred while starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



