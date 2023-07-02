package com.amrita.jpl.cys21039.pract.file_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Manbendra Satpathy
 * @version 1.0
 */
/**
 * An abstract class for transferring files between a server and a client.
 */
abstract class File_Server_Transfer {
    /**
     * Saves the file with the given data and filename.
     *
     * @param fileData The byte array representing the file data.
     * @param filename The name of the file to be saved.
     */
    abstract void saveFile(byte[] fileData, String filename);
    /**
     * Sends the file with the given filename.
     *
     * @param filename The name of the file to be sent.
     */
    abstract void sendFile(String filename);
    /**
     * An interface for listening to file transfer events.
     */
}
interface FileTransferListener {
    /**
     * Called when a file is successfully sent.
     *
     * @param filename The name of the file that was sent.
     */
    void onFileSent(String filename);
    /**
     * Called when a file is successfully saved.
     *
     * @param filename The name of the file that was saved.
     */
    void onFileSaved(String filename);
}
/**
 * A class for transferring files from the server side.
 */
class FileTransferServer extends File_Server_Transfer {
    private FileTransferListener listener;
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
            e.printStackTrace();
        }
    }
    @Override
    void sendFile(String filename) {
    }
    /**
     * Starts the file transfer server.
     */
    void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Sets the listener for file transfer events.
     *
     * @param listener The listener to be set.
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
    /**
     * A private class that handles the client connections in separate threads.
     */
    private class ClientHandler implements Runnable {
        private Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();

                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String filename = dataInputStream.readUTF();

                FileOutputStream fileOutputStream = new FileOutputStream(filename);

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                fileOutputStream.close();
                inputStream.close();
                if (listener != null) {
                    listener.onFileSaved(filename);
                }
                socket.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * The main class for the server application.
 */
public class Server {
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();
        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
            }
            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };
        server.setListener(listener);
        server.start();
    }
}