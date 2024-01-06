/**
 * @author Tanvi Sonti
 * The SimpleClient class represents a simple client program.
 * It connects to a server on the specified host and port, sends a message, and closes the connection.
 * This class demonstrates basic network programming using sockets.
 * @version 0.5
 */
package com.amrita.jpl.cys21072.practice.net;
import java.io.*;
import java.net.*;


public class SimpleClient {

    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Send a message to the server
            dout.writeUTF("Hello Server");
            dout.flush();

            // Close the output stream and the socket
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}