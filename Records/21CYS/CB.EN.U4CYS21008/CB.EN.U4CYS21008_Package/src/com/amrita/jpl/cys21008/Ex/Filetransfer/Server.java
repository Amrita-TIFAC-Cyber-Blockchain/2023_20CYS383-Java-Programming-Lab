package com.amrita.jpl.cys21008.Ex.Filetransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Abstract class for file transfer
/**
 * Abstract class for file transfer.
 * @author: Anuvarshini M K
 */
abstract class File_Server_Transfer {
    /**
     * Saves the file data with the specified filename.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    abstract void saveFile(byte[] fileData, String filename);

    /**
     * Sends the file with the specified filename.
     *
     * @param filename  the name of the file to be sent
     */
    abstract void sendFile(String filename);
}

/**
 * Interface for file transfer listener.
 */
interface FileTransferListener {
    /**
     * Called when a file is sent.
     *
     * @param filename  the name of the sent file
     */
    void onFileSent(String filename);

    /**
     * Called when a file is saved.
     *
     * @param filename  the name of the saved file
     */
    void onFileSaved(String filename);
}

/**
 * FileTransferServer class for receiving files from clients.
 */
class FileTransferServer extends File_Server_Transfer {
    private FileTransferListener listener;

    /**
     * Saves the file data with the specified filename.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Implement file saving logic
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            // Notify listener
            if (listener != null) {
                listener.onFileSaved(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends the file with the specified filename.
     *
     * @param filename  the name of the file to be sent
     */
    @Override
    void sendFile(String filename) {
        // Not implemented for the server
    }

    /**
     * Starts the file transfer server to listen for incoming file transfers.
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
     * Sets the file transfer listener.
     *
     * @param listener  the file transfer listener
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

    /**
     * Handles the client connection and file transfer.
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

                // Read the filename from the client
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String filename = dataInputStream.readUTF();

                // Create a new FileOutputStream with the filename
                FileOutputStream fileOutputStream = new FileOutputStream(filename);

                // Read the file data and save it
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                // Close the streams
                fileOutputStream.close();
                inputStream.close();

                // Notify the listener
                if (listener != null) {
                    listener.onFileSaved(filename);
                }

                // Close the socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Main program to start the file transfer server.
 */
public class Server {
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();

        // Implement FileTransferListener
        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Not implemented for the server
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };

        server.setListener(listener);

        // Start the server to listen for incoming file transfers
        server.start();
    }
}
