package com.amrita.jpl.cys21034.ex;

import java.io.*;
import java.net.*;

/**
 * The FTP class demonstrates a simple file transfer protocol using client-server communication.
 */
class FTP {
    /**
     * The main method starts the FTP server in a separate thread, waits for it to start,
     * starts the FTP client, and waits for the server thread to finish.
     *
     * @param args command-line arguments (not used in this program)
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
     * @param port the port number to listen on
     * @throws IOException if an I/O error occurs when opening the server socket
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
     * Starts the FTP client and sends a file to the specified host and port.
     *
     * @param host the host name or IP address of the server
     * @param port the port number of the server
     */
    private static void startClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server. Sending file...");

            String filePath = "C:/Users/lakan/Downloads/Desktop/a.txt"; // Replace with the actual file path
            sendFile(socket, filePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a file to the specified socket.
     *
     * @param socket   the socket connected to the server
     * @param filePath the path of the file to send
     * @throws IOException if an I/O error occurs while reading or writing the file
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
     * The ClientHandler class represents a separate thread that handles a client connection.
     */
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        /**
         * Constructs a ClientHandler object with the specified client socket.
         *
         * @param clientSocket the socket representing the client connection
         */
        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        /**
         * Runs the client handler thread, receiving commands from the client and performing actions accordingly.
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
         * Receives a file from the client and saves it to the server.
         *
         * @param socket           the socket connected to the client
         * @param dataInputStream the input stream to receive data from the client
         * @throws IOException if an I/O error occurs while reading or writing the file
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
         * Views the contents of the received file.
         *
         * @param fileName the name of the file to view
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
