package com.amrita.jpl.cys21019.pract.net;

import java.io.*;
import java.net.*;

/**
 * A simple server that listens for client connections and allows communication between the server and client.
 *
 * @author Gokulachselvan C D
 */
public class server {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();


            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            while (true) {
                clientMessage = dis.readUTF();
                System.out.println("Client: " + clientMessage);

                // Break the loop if the client message is "exit" or "Exit"
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                serverMessage = serverReader.readLine();

                dos.writeUTF(serverMessage);
                dos.flush();

                // Break the loop if the server message is "exit" or "Exit"
                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            ss.close();
            dis.close();
            dos.close();
            serverReader.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
