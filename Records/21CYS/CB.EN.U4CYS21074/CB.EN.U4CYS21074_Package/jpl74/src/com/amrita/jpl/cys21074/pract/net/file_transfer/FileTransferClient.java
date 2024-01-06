package com.amrita.jpl.cys21074.pract.net.file_transfer;

import java.io.*;
import java.net.Socket;

public class FileTransferClient extends FileTransfer {
    private final String serverAddress;
    private final int serverPort;
    private final FileTransferListener listener;

    public FileTransferClient(String serverAddress, int serverPort, FileTransferListener listener) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.listener = listener;
    }

    @Override
    public void sendFile(String filename) {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            bufferedInputStream.read(fileData, 0, fileData.length);

            OutputStream outputStream = socket.getOutputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(getFileNameFromPath(filename)); // Send the filename before file data
            dataOutputStream.flush();

            outputStream.write(fileData, 0, fileData.length);
            outputStream.flush();

            listener.onFileSent(getFileNameFromPath(filename));

            bufferedInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveFile(byte[] fileData, String filename) {
        // Client-side does not save files
    }
}

