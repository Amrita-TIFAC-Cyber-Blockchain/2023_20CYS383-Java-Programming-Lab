package com.amrita.jpl.cys21072.assisgment.assignment2;

/**
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Abstract class for file transfer
abstract class File_Server_Transfer {
    abstract void saveFile(byte[] fileData, String filename);
    abstract void sendFile(String filename);
}

// Interface for file transfer listener
interface FileTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

// FileTransferServer class
class FileTransferServer extends File_Server_Transfer {
    private FileTransferListener listener;

    /**
     * Saves the file data to the specified filename.
     * @param fileData The byte array containing the file data
     * @param filename The name of the file to save
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
     * Sends the specified file.
     *
     * @param filename The name of the file to send
     */
    @Override
    void sendFile(String filename) {
        // Not implemented for the server
    }

    void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(7272);
            System.out.println("Server started. Listening on port 7272...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param listener The file transfer listener to set
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

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

// Main program to start the server
public class serverSide {
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

