package com.amrita.jpl.cys21019.ex;

import java.io.*;
import java.net.*;

/**
 * This class implements a basic FTP client-server application.
 */
class Ftp {
    /**
     * The main method that starts the FTP application.
     *
     * @param args Command-line arguments (unused).
     */
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

    /**
     * Starts the FTP server that listens for client connections on the specified port.
     *
     * @param port The port number to listen on.
     * @throws IOException If an I/O error occurs while starting the server.
     */
    private static void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started. Listening on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    /**
     * Starts the FTP client and sends a file to the server.
     *
     * @param host The server hostname or IP address.
     * @param port The server port number.
     */
    private static void startClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server. Sending file...");

            String filePath = "D:/4th SEMESTER/Java/java_codes/jpl_package_19/src/com/amrita/jpl/cys21019/ex/clientFile.txt";
            sendFile(socket, filePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a file to the server over the specified socket.
     *
     * @param socket   The socket to send the file over.
     * @param filePath The path of the file to send.
     * @throws IOException If an I/O error occurs while sending the file.
     */
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

    /**
     * Represents a client handler that handles client requests in a separate thread.
     */
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        /**
         * Constructs a new instance of the client handler with the specified client socket.
         *
         * @param clientSocket The client socket to handle.
         */
        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        /**
         * The run method that is executed when the client handler thread starts.
         */
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

        /**
         * Receives a file from the client over the specified socket.
         *
         * @param socket          The socket to receive the file over.
         * @param dataInputStream The input stream to read data from the socket.
         * @throws IOException If an I/O error occurs while receiving the file.
         */
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

        /**
         * Reads and displays the contents of the received file.
         *
         * @param fileName The name of the file to view.
         */
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
