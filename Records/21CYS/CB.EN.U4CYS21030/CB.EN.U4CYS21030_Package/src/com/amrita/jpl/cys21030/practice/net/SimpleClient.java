package com.amrita.jpl.cys21030.pract;


import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);

            // Create input and output streams for sending and receiving messages
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Create a BufferedReader to read messages from the console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String message = "";

            while (!message.equals("bye")) {
                // Read a message from the console
                message = br.readLine();

                // Send the message to the server
                dout.writeUTF(message);
                dout.flush();

                // Receive a message from the server
                String receivedMessage = dis.readUTF();
                System.out.println("Server: " + receivedMessage);
            }

            // Close the streams and the socket
            dout.close();
            dis.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}









