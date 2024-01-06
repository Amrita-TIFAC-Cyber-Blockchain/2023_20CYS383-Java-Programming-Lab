package com.amrita.jpl.cys21020.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
  * @author Hemesh sai
   * @version 1.0
 * The Server class represents a server that communicates with clients using sockets.
 */
public class Server {

    /**
     * The main method of the Server class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Create a ServerSocket that listens on port 2444
            ServerSocket serverSocket = new ServerSocket(2444);

            // Wait for a client to connect and accept the connection
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            // Create input and output streams for communication with the client
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Create a Scanner to read user input from the console
            Scanner scanner = new Scanner(System.in);

            String input;
            do {
                // Read the message from the client
                String message = inputStream.readUTF();
                System.out.println("Client: " + message);

                // Read user input from the console
                input = scanner.nextLine();

                // Send the input to the client
                outputStream.writeUTF(input);
                outputStream.flush();

            } while (!input.equals("EXIT"));

            // Close the streams and the socket
            outputStream.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
