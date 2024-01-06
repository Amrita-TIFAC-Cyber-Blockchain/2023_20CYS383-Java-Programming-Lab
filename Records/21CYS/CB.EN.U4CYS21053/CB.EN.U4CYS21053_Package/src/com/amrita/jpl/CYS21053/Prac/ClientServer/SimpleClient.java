package com.amrita.jpl.CYS21053.Prac.ClientServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple client that connects to a server and sends messages.
 * This client reads input from the user and sends it to the server.
 * It terminates when the user enters "exit".
 *
 * @author Nived Dineshan
 * @version 0.5
 */
public class SimpleClient {
    /**
     * The main method that starts the client.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2444);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                System.out.print("Enter a message: ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred : " + e);
        }
    }
}
