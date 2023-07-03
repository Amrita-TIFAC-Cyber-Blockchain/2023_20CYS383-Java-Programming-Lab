package com.amrita.jpl.cys21078.pract.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * This is the simple client file
 * @author suvetha
 * Version 0.1
 */
public class SimpleClient {

    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2445);

            // Create a DataInputStream to receive messages from the server
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            String message, str;

            // Send a message to the server
            do{
                System.out.println("Type your message: ");
                message = input.nextLine();
                dout.writeUTF(message);
                dout.flush();
                if(!message.equals("EXIT")){
                    str = dis.readUTF();
                    System.out.println("Message Received: " + str);
                }
            }while(!message.equals("EXIT"));

            // Close the output stream and the socket
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}