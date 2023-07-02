package com.amrita.jpl.cys21009.pract.net;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * The SimpleClient class represents a simple client program.
 * It connects to a server on the specified host and port, sends a message, and closes the connection.
 * This class demonstrates basic network programming using sockets.
 *
 * Note: This is a simple example and does not handle advanced error handling or response handling from the server.
 *
 * Usage:
 * - Run the SimpleServer program to start the server.
 * - Run the SimpleClient program to connect to the server and send a message.
 * - The server receives the message and prints it to the console.
 * - The client program then closes the connection.
 *
 * Note: The server must be running before executing the client program.
 *
 * To change the host and port, modify the arguments of the Socket constructor.
 *
 * @author Aravind
 * @version 1
 */
public class chat_Client {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);
            /**
             * @param s Socket Variable
             * @param dout Data Output Stream
             * @param din Data Input Stream
             */
            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Create a DataInputStream to receive messages from the server.
            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println("Connected to the Server.");
            // Sending messages to the server by using the Do-While Loop

            /**
             * @param msg Client input message
             * @param str Server message
             */
            String msg;
            do {
                String str = sc.nextLine();
                dout.writeUTF(str); // sending the message to output stream
                dout.flush();
                msg = din.readUTF(); // reading the message from the input stream of server.
                System.out.println("Server: " + msg);
                if(msg.equals("exit")) {
                    System.out.println("Connection closed.");
                    dout.close();
                    din.close();
                    s.close(); // Close the output stream and the socket if the server sends exit.
                }
            } while (!msg.equals("exit"));
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}