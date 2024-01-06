package com.amrita.jpl.cys21017.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * The SimpleClient class represents a simple client program.
 * It connects to a server on the specified host and port, sends a message, and closes the connection.
 * This class demonstrates basic network programming using sockets.
 * <p>
 * Note: This is a simple example and does not handle advanced error handling or response handling from the server.
 * <p>
 * Usage:
 * - Run the SimpleServer program to start the server.
 * - Run the SimpleClient program to connect to the server and send a message.
 * - The server receives the message and prints it to the console.
 * - The client program then closes the connection.
 */

public class simpleclient {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     */
    public static void main(String[] args) {
            try {
                Scanner input = new Scanner(System.in);
                
                // Create a socket and connect to the server at "localhost" on port 2444
                Socket s = new Socket("localhost", 2444);

                // Create a DataOutputStream to send messages to the server
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                // Create a DataInputStream to receive messages from the client
                DataInputStream dis = new DataInputStream(s.getInputStream());

                String cmsg;

                do {
                    cmsg = input.nextLine();
                    // Send a message to the server
                    dout.writeUTF(cmsg);
                    dout.flush();

                    // Read the message from the client
                    String str = dis.readUTF();
                    System.out.println("Message: " + str);
                } while (!cmsg.equals("exit"));

                // Close the output stream and the socket
                dis.close();
                dout.close();
                s.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e);
            }
    }
}
