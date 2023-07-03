/**
 * @author Tanvi Sonti
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 * @version 0.5
 */

package com.amrita.jpl.cys21072.practice.net;
import java.io.*;
import java.net.*;


public class SimpleServer {

    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Read the message from the client
            String str = dis.readUTF();
            System.out.println("Message: " + str);

            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
