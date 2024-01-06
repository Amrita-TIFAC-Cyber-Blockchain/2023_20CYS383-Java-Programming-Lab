package com.amrita.jpl.cys21028.Practice.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @author Hitesh
 * @version 0.6
 */
public class SimpleClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 2444;

    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read user input
            Scanner scanner = new Scanner(System.in);
            String message;

            // Send messages to the server until 'exit' is entered
            do {
                System.out.print("Enter a message : ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));

            // Close the connections
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
