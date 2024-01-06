package com.amrita.jpl.cys21010.practice.assigmentServerCli;

import java.io.*;
import java.net.Socket;

interface FileTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

abstract class FileTransfer {
    public abstract void sendFile(String filename);
    public abstract void saveFile(byte[] fileData, String filename);
}

public class FileTransferClient extends FileTransfer {
    private Socket socket;
    private FileTransferListener listener;

    public FileTransferClient(FileTransferListener listener) {
        this.listener = listener;
    }

    @Override
    public void sendFile(String filename) {
        try {
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);

            socket = new Socket("localhost", 8080);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(file.getName());
            dataOutputStream.writeLong(fileData.length);
            dataOutputStream.write(fileData, 0, fileData.length);
            dataOutputStream.flush();

            listener.onFileSent(file.getName());

            dataOutputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveFile(byte[] fileData, String filename) {
        // Client does not implement saving file on the server
    }

    public static void main(String[] args) {
        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("File sent: " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                // Not used in the client
            }
        };

        FileTransferClient client = new FileTransferClient(listener);
        client.sendFile("/tmp/test.txt");
    }
}
