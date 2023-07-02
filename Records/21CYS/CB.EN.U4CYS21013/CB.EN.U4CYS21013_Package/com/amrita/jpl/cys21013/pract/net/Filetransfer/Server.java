package com.amrita.jpl.cys21013.pract.net.Filetransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Basi Reddy Rohith Reddy.
 * @version 1.0
 * An abstract class representing file transfer operations.
 */
abstract class File_Server_Transfer {
    /**
     * Saves the file data to a specified filename.
     *
     * @param fileData The byte array containing the file data.
     * @param filename The name of the file to save.
     */
    abstract void saveFile(byte[] fileData, String filename);

    /**
     * Sends the specified file.
     *
     * @param filename The name of the file to send.
     */
    abstract void sendFile(String filename);
}

/**
 * A listener interface for file transfer events.
 */
interface FileTransferListener {
    /**
     * Called when a file is successfully sent.
     * @param filename The name of the sent file.
     */
    void onFileSent(String filename);

    /**
     * Called when a file is successfully saved.
     * @param filename The name of the saved file.
     */
    void onFileSaved(String filename);
}

/**
 * A server for file transfer operations.
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
        // Method implementation for sending files can be added here
    }

    /**
     * Starts the file transfer server.
     */
    void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(6060);
            System.out.println("Server started. Listening on port 6060...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param listener The file transfer listener to set.
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

    /**
     * A client handler for processing incoming file transfers.
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
 * The Server class for starting the file transfer server.
 */
public class Server {
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();

        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Implementation for handling file sent event can be added here
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
