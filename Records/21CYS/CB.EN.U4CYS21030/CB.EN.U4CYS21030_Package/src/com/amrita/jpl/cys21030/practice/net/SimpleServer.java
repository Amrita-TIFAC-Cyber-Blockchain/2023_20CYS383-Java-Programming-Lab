package com.amrita.jpl

.21030.pract





import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();

            // Create input and output streams for sending and receiving messages
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Create a BufferedReader to read messages from the console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String message = "";

            while (!message.equals("bye")) {
                // Receive a message from the client
                message = dis.readUTF();
                System.out.println("Client: " + message);

                // Read a message from the console
                String response = br.readLine();

                // Send the response to the client
                dout.writeUTF(response);
                dout.flush();
            }

            // Close the streams and the socket
            dout.close();
            dis.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
