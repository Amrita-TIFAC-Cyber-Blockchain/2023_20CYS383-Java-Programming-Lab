package com.amrita.jpl.cys21040.filetransfer;

import java.io.*;
import java.net.Socket;


abstract class FileTransferListener {
    abstract void saveFile(String filename);

    abstract void sendFile(String filename);

    public abstract void onFileSent(String filename);

    public abstract void onFileSaved(String filename);
}
interface File_Client_Transfer_Listener {
    void onFileSent(String filename);
    void onFileSaved(String filename);

    void saveFile(byte[] fileData, String filename);

    void sendFile(String filename);
}
abstract class FileTransferClient implements File_Client_Transfer_Listener {
    private FileTransferListener listener;

    @Override
    public void saveFile(byte[] fileData, String filename) {
    }

    @Override
    public void sendFile(String filename) {
        try {
            Socket socket = new Socket("localhost", 8082);
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
                listener.sendFile(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
}

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        String filename = "/home/oxalate/Documents/Java Final Project/src/com/amrita/jpl/cys21040/filetransfer/cosmicbyte.txt";
        String serverFilename = "/home/oxalate/Documents/Java Final Project/src/com/amrita/jpl/cys21040/filetransfer/cimple.txt";

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