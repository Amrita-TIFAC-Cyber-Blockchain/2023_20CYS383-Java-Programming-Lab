package com.amrita.jpl.CYS21053.Prac.ClientServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: Nived Dineshan
 * Version: 0.5
 */
public class SimpleServer {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            Socket clientSocket = serverSocket.accept();
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();
                System.out.println(" Message from client: " + message);
            }
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}