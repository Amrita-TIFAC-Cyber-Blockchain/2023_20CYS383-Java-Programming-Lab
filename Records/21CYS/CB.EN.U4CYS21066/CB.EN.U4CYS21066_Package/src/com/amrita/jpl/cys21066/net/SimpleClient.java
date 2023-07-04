package com.amrita.jpl.cys21066.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {
    public SimpleClient() {
    }

    public static void main(String[] args) {
        try {
            // Create a socket connection to the server
            Socket socket = new Socket("localhost", 2444);

            // Create a data output stream to send data to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Create a scanner to read user input from the console
            Scanner scanner = new Scanner(System.in);
            String message = "";

            do {
                // Prompt the user to enter a message
                System.out.print("Enter 'exit' to quit: ");
                message = scanner.nextLine();

                // Send the message to the server
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));

            // Close the data output stream and the socket
            dataOutputStream.close();
            socket.close();
        } catch (IOException var5) {
            // Handle any IO errors that occur
            System.out.println("An error occurred: " + var5);
        }
    }
}
