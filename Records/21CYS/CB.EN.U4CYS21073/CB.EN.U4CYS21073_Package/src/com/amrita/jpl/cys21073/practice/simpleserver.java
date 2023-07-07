package com.amrita.jpl.cys21073.practice;


import java.io.*;
import java.net.*;

public class simpleserver {

    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();
            System.out.println("Server is Running");
            // Create a DataInputStream to receive messages from the client
            try (DataInputStream dis = new DataInputStream(s.getInputStream())) {

                while (true) {
                    // Read the message from the client
                    try {
                        String str = dis.readUTF();
                        System.out.println("Message: " + str);
                        if (str.equals("CLOSE")) {
                            System.out.println("Stopping  the Server !!!");
                            break;
                        }
                    } catch (EOFException ignored) {

                    }
                }
            }

            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}