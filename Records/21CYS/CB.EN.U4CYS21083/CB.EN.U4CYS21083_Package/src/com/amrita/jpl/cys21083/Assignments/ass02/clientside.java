package com.amrita.jpl.cys21083.Assignments.ass02;

/**
 * @author Venkata Revan Nagireddy - CB.EN.U4CYS21083
 */

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

// Abstract class for file transfer
abstract class File_Client_Transfer {
    abstract void saveFile(byte[] fileData, String filename);
    abstract void sendFile(String filename);
}

// Interface for file transfer listener
interface File_Client_Transfer_Listener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

// FileTransferClient class
class FileTransferClient extends File_Client_Transfer {
    private FileTransferListener listener;

    /**
     * @param fileData The byte array containing the file data
     * @param filename The name of the file to save
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Not implemented for the client
    }

    /**
     * Sends the specified file.
     * @param filename The name of the file to send
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
     * @param listener The file transfer listener to set
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
}

public class clientside {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        String filename = "sent.txt";  // Provide the filename with extension
        String serverFilename = "received.txt";  // Provide the desired filename on the server

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
