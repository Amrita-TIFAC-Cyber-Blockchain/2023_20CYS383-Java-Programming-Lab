package com.amrita.jpl.cys21013.pract.net.Filetransfer;

import java.io.*;
import java.net.Socket;

/**
 * @author rohith
 * @version 1.0
 * An abstract class representing file transfer operations for the client.
 */
abstract class File_Client_Transfer {
    /**
     * Saves the file data to a specified filename.
     * @param fileData The byte array containing the file data.
     * @param filename The name of the file to save.
     */
    abstract void saveFile(byte[] fileData, String filename);

    /**
     * Sends the specified file.
     * @param filename The name of the file to send.
     */
    abstract void sendFile(String filename);
}

/**
 * A listener interface for file transfer events in the client.
 */
interface File_Client_Transfer_Listener {
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
 * A client for file transfer operations.
 */
class FileTransferClient extends File_Client_Transfer {
    private File_Client_Transfer_Listener listener;

    @Override
    void saveFile(byte[] fileData, String filename) {
        // Method implementation for saving files can be added here
    }

    @Override
    void sendFile(String filename) {
        try {
            Socket socket = new Socket("localhost", 6060);
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
     * Sets the file transfer listener for the client.
     * @param listener The file transfer listener to set.
     */
    public void setListener(File_Client_Transfer_Listener listener) {
        this.listener = listener;
    }
}

/**
 * The Client class for sending files to the server.
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 6060;

    public static void main(String[] args) {
        String filename = "src/com/amrita/jpl/cys21013/pract/net/Filetransfer/abc21013.txt";
        String serverFilename = "src/com/amrita/jpl/cys21013/pract/net/Filetransfer/reddy21013.txt";

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
