package com.amrita.jpl.cys21064.ex;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
abstract class FileTransfer
{
    abstract void sendFile(String filename);

    abstract void saveFile(byte[] fileData, String filename);
}

interface FileTransferListener
{
    void onFileSent(String filename);
    void onFileSaved(String filename);

}

class FileTransferServer extends FileTransfer
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private FileTransferListener listener;
    private String saveDirectory;

    public FileTransferServer(FileTransferListener listener, String saveDirectory) {
        this.listener = listener;
        this.saveDirectory = saveDirectory;
    }
    void start() {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080...");

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


    void sendFile(String filename)
    {

    }

    void saveFile(byte[] fileData, String filename)
    {
        String filePath = saveDirectory + File.separator + filename;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            listener.onFileSaved(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ftserver {
    public static void main(String[] args) {
        String saveDirectory = "/Users/rajendraprasad/Desktop/sem4/java"; // Specify the desired save directory
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
