package com.amrita.jpl.cys21087.pract.net;

import java.io.*;
import java.net.*;
/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 * Usage:
 * - Run the SimpleServer program.
 * - Connect to the server using a client program and send a message.
 * - The server receives the message and prints it to the console.
 * - The server then closes the connection.
 * - The chat bot runs until the message from either of the side is "exit".
 * @author Vishnu
 * @version 1.0
 */
public class SimpleServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2445);

            // Wait for a client to establish a connection
            Socket s = ss.accept();

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("exit") && !str2.equals("exit")) {
                str = dis.readUTF();
                System.out.println("Client says: " + str);
                if (!str.equals("exit")) {
                    str2 = br.readLine();
                    dos.writeUTF(str2);
                    dos.flush();
                }
            }

            // Close the server socket
            dis.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
