package com.amrita.jpl.cys21085.ex;

import java.io.*;
import java.net.*;

/**
 * @author Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program demonstrates a simple implementation of the File Transfer Protocol (FTP)
 * using a client-server model. The client sends a file to the server, and the server
 * receives and saves the file. After receiving the file, the server displays its contents.
 */
class FTP {
    /**
     * The main method starts the FTP program by creating a server thread and a client.
     * It starts the server thread in the background, waits for it to start,
     * starts the client to send a file to the server, and then waits for the server thread to finish.
     *
     * @param args The command-line arguments.
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
     * Starts the server that listens for incoming client connections on the specified port.
     * When a client connects, a new thread is created to handle the client's requests.
     *
     * @param port The port number to listen on.
     * @throws IOException if an I/O error occurs while opening the server socket.
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
     * Connects to the server on the specified host and port, and sends a file to the server.
     *
     * @param host The server host name or IP address.
     * @param port The server port number.
     */
    private static void startClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server. Sending file...");

            String filePath = "/Users/vinoth/Downloads/4th sem/Java Programing/JPL final/src/com/amrita/jpl/cys21085/ex/a.txt"; // Replace with the actual file path
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
     * @throws IOException if an I/O error occurs while reading the file or sending data.
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
     * The ClientHandler class is responsible for handling client connections.
     * It receives commands from the client and performs the corresponding actions.
     */
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        /**
         * Constructs a new instance of the ClientHandler class.
         *
         * @param clientSocket The client socket associated with the client connection.
         */
        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        /**
         * The run method is executed when the client handler thread is started.
         * It reads commands from the client and performs the corresponding actions.
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
         * The received file is saved and its contents are displayed.
         *
         * @param socket           The socket to receive the file over.
         * @param dataInputStream The input stream used to receive data from the client.
         * @throws IOException if an I/O error occurs while reading the data or saving the file.
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
         * Displays the contents of the received file.
         *
         * @param fileName The name of the file to display.
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
