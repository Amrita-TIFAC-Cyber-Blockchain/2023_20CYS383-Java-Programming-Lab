package com.amrita.jpl.cys21074.pract.net.file_transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferServer extends FileTransfer {
    private final int serverPort;
    private final FileTransferListener listener;

    public FileTransferServer(int serverPort, FileTransferListener listener) {
        this.serverPort = serverPort;
        this.listener = listener;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started and listening on port " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendFile(String filename) {
        // Server-side does not send files
    }

    @Override
    public void saveFile(byte[] fileData, String filename) {
        // Change the saved file name
        String savedFilename = "file_saved.txt"; // Provide your desired file name here

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\rtsud\\OneDrive\\Desktop\\College\\java\\jpl74\\src\\com\\amrita\\jpl\\cys21074\\pract\\net\\file_transfer\\" + savedFilename);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(fileData, 0, fileData.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            listener.onFileSaved(savedFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class ClientHandler extends Thread {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                byte[] fileData = new byte[4096];
                InputStream inputStream = socket.getInputStream();

                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String filename = dataInputStream.readUTF();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);

                int bytesRead;
                while ((bytesRead = inputStream.read(fileData)) != -1) {
                    bufferedOutputStream.write(fileData, 0, bytesRead);
                }

                bufferedOutputStream.flush();
                bufferedOutputStream.close();

                saveFile(byteArrayOutputStream.toByteArray(), filename);

                dataInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

