package com.amrita.jpl.cys21016.ex;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

abstract class FileTransfer {
    abstract void saveFile(byte[] fileData, String filename);

    void sendFile(String filename) {
        System.out.println("Sending file: " + filename);
    }
}

interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

class FileTransferClient extends FileTransfer implements FileTransferListener {
    private String serverAddress;
    private int serverPort;

    FileTransferClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        System.out.println("Saving file on the client-side: " + filename);
    }

    @Override
    void sendFile(String filename) {
        try (Socket socket = new Socket(serverAddress, serverPort)) {

            byte[] fileData = Files.readAllBytes(new File(filename).toPath());

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(fileData);

            onFileSent(filename); // Notify listener

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("File sent to the server: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File saved on the server: " + filename);
    }
}

class FileTransferServer extends FileTransfer implements FileTransferListener{
    private int serverPort;

    FileTransferServer(int serverPort) {
        this.serverPort = serverPort;
    }


    @Override
    public void onFileSent(String filename) {
        //no use in server side.
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File "+filename+" is saved on the server disk.");
    }

    @Override
    void saveFile(byte[] fileData, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(fileData);
            fos.flush();
            onFileSaved(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start() {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Server started. Listening for incoming file transfers on port " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected"+clientSocket.getInetAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (InputStream inputStream = clientSocket.getInputStream()) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }

            byte[] fileData = buffer.toByteArray();

            String filename = "received_file.txt";

            saveFile(fileData, filename);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class simpleFileTransfer extends Thread{
    @Override
    public void run() {
        FileTransferServer server = new FileTransferServer(1234);
        server.start();
    }
    public static void main(String[] args) {
        simpleFileTransfer thread1 = new simpleFileTransfer();
        thread1.start();
        FileTransferClient client = new FileTransferClient("localhost", 1234);
        client.sendFile("1.txt");
    }
}
