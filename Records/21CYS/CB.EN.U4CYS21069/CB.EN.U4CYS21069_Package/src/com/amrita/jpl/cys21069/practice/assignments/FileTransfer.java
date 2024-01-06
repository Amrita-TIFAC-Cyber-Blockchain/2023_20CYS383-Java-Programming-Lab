package com.amrita.jpl.cys21069.practice.assignments;

import java.io.*;
import java.net.*;

class FTP {
    public static void main(String[] args) {
        int port = 1234;
        String host = "localhost";

        try {
            // Start the server in a separate thread
            Thread serverThread = new Thread(() -> {
                try {
                    startServer(port);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverThread.start();

            // Wait for the server to start
            Thread.sleep(1000);

            // Start the client
            startClient(host, port);

            // Wait for the server thread to finish
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started. Listening on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    private static void startClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server. Sending file...");

            String filePath = "C:/Users/Seran/Desktop/example.txt"; // Replace with the actual file path
            sendFile(socket, filePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket socket, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("SEND");
        dataOutputStream.writeUTF(file.getName());

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        dataOutputStream.close();

        System.out.println("File sent: " + file.getName());
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {
                String command = dataInputStream.readUTF();
                if (command.equals("SEND")) {
                    receiveFile(clientSocket, dataInputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void receiveFile(Socket socket, DataInputStream dataInputStream) throws IOException {
            String fileName = dataInputStream.readUTF();
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dataInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            dataInputStream.close();

            System.out.println("File received: " + fileName);
            viewFile(fileName);
        }

        private void viewFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                System.out.println("Contents of the received file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}