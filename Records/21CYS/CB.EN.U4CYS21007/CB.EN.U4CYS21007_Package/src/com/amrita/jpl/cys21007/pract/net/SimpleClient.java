package com.amrita.jpl.cys21007.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Author: Anu Priya P
 * Version: 0.5
 */
public class SimpleClient {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2444);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message;

            while (true) {
                System.out.print("Enter a message (or 'exit' to quit): ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
