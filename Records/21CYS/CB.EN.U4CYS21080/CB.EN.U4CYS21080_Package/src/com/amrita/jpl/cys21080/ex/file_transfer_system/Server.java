package com.amrita.jpl.cys21080.ex.file_transfer_system;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * An abstract class representing a file transfer server.
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
abstract class File_Server_Transfer {
    /**
     * Saves the file data to the local file system.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    abstract void saveFile(byte[] fileData, String filename);

    /**
     * Sends the specified file.
     *
     * @param filename  the name of the file to be sent
     */
    abstract void sendFile(String filename);
}

/**
 * An interface for receiving file transfer events.
 */
interface FileTransferListener {
    /**
     * Called when a file is successfully sent.
     *
     * @param filename  the name of the sent file
     */
    void onFileSent(String filename);

    /**
     * Called when a file is successfully saved.
     *
     * @param filename  the name of the saved file
     */
    void onFileSaved(String filename);
}

/**
 * A class representing a file transfer server that receives files from clients.
 */
class FileTransferServer extends File_Server_Transfer {
    private FileTransferListener listener;

    /**
     * Saves the file data to the local file system.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
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

    /**
     * Sends the specified file (not implemented in this class).
     *
     * @param filename  the name of the file to be sent
     */
    @Override
    void sendFile(String filename) {
        // Implementation for sending files (if needed)
    }

    /**
     * Starts the file transfer server and listens for incoming connections.
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
     * @param listener  the listener to be set
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

    /**
     * A private inner class that handles client connections in separate threads.
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * The main class representing the file transfer server application.
 */
public class Server {
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();

        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Implementation for handling file sent event (if needed)
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
