package com.amrita.jpl.cys21039.pract.file_net;

import java.io.*;
import java.net.Socket;
/**
 * @author Manbendra Satpathy
 * @version 1.0
 */

/**
 * An abstract class for transferring files between a client and a server.
 */
abstract class File_Client_Transfer {
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
}
/**
 * An interface for listening to file transfer events.
 */
interface File_Client_Transfer_Listener {
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
 * A class for transferring files from the client side.
 */
class FileTransferClient extends File_Client_Transfer {
    private FileTransferListener listener;

    @Override
    void saveFile(byte[] fileData, String filename) {
        // Implementation of saving the file goes here
    }
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
     * @param listener The listener to be set.
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
}
/**
 * The main class for the client application.
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;
    /**
     * The entry point of the client application.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        String filename = "sent.txt";
        String serverFilename = "received.txt";
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