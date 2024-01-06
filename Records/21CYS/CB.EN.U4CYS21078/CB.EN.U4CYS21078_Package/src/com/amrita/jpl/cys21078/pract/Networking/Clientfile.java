package com.amrita.jpl.cys21078.pract.Networking;

import java.io.*;
import java.net.Socket;

// Abstract class for file transfer
abstract class FileClientTransfer {
    abstract void sendFile(String filename);
    abstract void saveFile(byte[] fileData, String filename);

}

// Interface for file transfer listener
interface FileClientTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

// FileTransferClient class
class FileTransferClient extends FileClientTransfer {
    private FileClientTransferListener listener;

    @Override
    void saveFile(byte[] fileData, String filename) {
        // Not implemented for the client
    }


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

    public void setListener(FileClientTransferListener listener) {
        this.listener = listener;
    }
}

// Main program to send a file to the server
public class Clientfile {
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