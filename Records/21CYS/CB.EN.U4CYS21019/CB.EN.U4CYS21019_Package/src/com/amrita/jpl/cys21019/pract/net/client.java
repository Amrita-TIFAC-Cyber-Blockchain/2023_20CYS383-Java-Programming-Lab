package com.amrita.jpl.cys21019.pract.net;

import java.io.*;
import java.net.*;

/**
 * A simple client that connects to a server and allows communication between the client and server.
 * The client can be terminated by sending an "exit" message to the server or receiving an "exit" message from the server.
 * The client connects to the server at "localhost" on port 2444.
 *
 * @author Gokulachselvan C D
 */
public class client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2444);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            while (true) {
                clientMessage = clientReader.readLine();

                dos.writeUTF(clientMessage);
                dos.flush();

                // Break the loop if the client message is "exit" or "Exit"
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                serverMessage = dis.readUTF();
                System.out.println("Server: " + serverMessage);

                // Break the loop if the server message is "exit" or "Exit"
                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            dis.close();
            dos.close();
            clientReader.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
