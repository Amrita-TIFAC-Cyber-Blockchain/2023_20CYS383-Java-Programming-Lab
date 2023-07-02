package com.amrita.jpl.cys21008.Ex.Filetransfer;

import java.io.*;
import java.net.Socket;


// Abstract class for file transfer
/**
 * Abstract class for file transfer on the client side.
 * @author: Anuvarshini M K
 */
abstract class File_Client_Transfer {
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
 * Interface for file transfer listener on the client side.
 */
interface File_Client_Transfer_Listener {
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
 * FileTransferClient class for sending files to the server.
 */
class FileTransferClient extends File_Client_Transfer {
    private FileTransferListener listener;

    /**
     * Saves the file data with the specified filename.
     *
     * @param fileData  the byte array containing the file data
     * @param filename  the name of the file to be saved
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Not implemented for the client
    }

    /**
     * Sends the file with the specified filename to the server.
     *
     * @param filename  the name of the file to be sent
     */
    @Override
    void sendFile(String filename) {
        // Implement file sending using socket programming
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
     * Sets the file transfer listener.
     *
     * @param listener  the file transfer listener
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
}

/**
 * Main program to send a file to the server.
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    /**
     * Sends a file to the server.
     *
     * @param args  command line arguments (not used)
     */
    public static void main(String[] args) {
        String filename = "/Users/anutheboss/Desktop/sent.txt";
        String serverFilename = "/Users/anutheboss/Desktop/received.txt";

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            // Send the filename to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(serverFilename);

            // Read the file and send its data to the server
            FileInputStream fileInputStream = new FileInputStream(filename);
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the streams and socket
            outputStream.close();
            fileInputStream.close();
            socket.close();

            System.out.println("File sent successfully: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
