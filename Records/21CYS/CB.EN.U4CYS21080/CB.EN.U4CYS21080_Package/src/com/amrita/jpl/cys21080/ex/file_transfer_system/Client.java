package com.amrita.jpl.cys21080.ex.file_transfer_system;

import java.io.*;
import java.net.Socket;

/**
 * An abstract class representing a file transfer client.
 * @author T Pavan Kumar Reddy
 * @version 1.0
 * */
abstract class File_Client_Transfer {
    /**
     * Saves the file data to the local file system.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    abstract void saveFile(byte[] fileData, String filename);

    /**
     * Sends the specified file to the server.
     *
     * @param filename  the name of the file to be sent
     */
    abstract void sendFile(String filename);
}

/**
 * An interface for receiving file transfer events.
 */
interface File_Client_Transfer_Listener {
    /**
     * Called when a file is successfully sent to the server.
     *
     * @param filename  the name of the sent file
     */
    void onFileSent(String filename);

    /**
     * Called when a file is successfully saved to the local file system.
     *
     * @param filename  the name of the saved file
     */
    void onFileSaved(String filename);
}

/**
 * A class representing a file transfer client that sends files to the server.
 */
class FileTransferClient extends File_Client_Transfer {
    private FileTransferListener listener;

    /**
     * Saves the file data to the local file system.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Implementation for saving file data
    }

    /**
     * Sends the specified file to the server.
     *
     * @param filename  the name of the file to be sent
     */
    @Override
    void sendFile(String filename) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream outputStream = socket.getOutputStream();
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            fileInputStream.close();
            outputStream.close();
            socket.close();

            // Notify listener
            if (listener != null) {
                listener.onFileSent(filename);
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
}

/**
 * A class representing a file transfer client application.
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        String filename = "pavan80.txt";
        String serverFilename = "received80.txt";

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(serverFilename);

            FileInputStream fileInputStream = new FileInputStream(filename);
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            fileInputStream.close();
            socket.close();

            System.out.println("File sent successfully: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
