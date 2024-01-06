package com.amrita.jpl.cys21026.pract;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 *
 * @author Kakara manoj ram
 */
public class SimpleServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Client Getting ready to connect.....");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            int clientPort = clientSocket.getPort();
            InetAddress clientAddress = clientSocket.getInetAddress();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());


            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);
                System.out.println("Received Message from the client from IP "+clientAddress+": " + message);
            }

            clientSocket.close();
            serverSocket.close();
            System.out.println("Server Socket Closed!!!!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
