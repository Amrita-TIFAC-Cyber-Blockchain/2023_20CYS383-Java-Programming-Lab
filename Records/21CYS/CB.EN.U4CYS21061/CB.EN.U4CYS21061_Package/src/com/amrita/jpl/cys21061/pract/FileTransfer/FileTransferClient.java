package com.amrita.jpl.cys21061.pract.FileTransfer;
import java.io.*;
import java.net.Socket;

public class FileTransferClient extends FileTransfer {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    @Override
    protected byte[] readFromFile(String filename) {
        try {
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
            fileInputStream.close();

            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void saveFile(byte[] fileData, String filename) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            outputStream.writeObject(filename);
            outputStream.writeObject(fileData);

            boolean success = (boolean) inputStream.readObject();
            if (success) {
                notifyFileSent(filename);
            } else {
                System.out.println("Failed to send file: " + filename);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
