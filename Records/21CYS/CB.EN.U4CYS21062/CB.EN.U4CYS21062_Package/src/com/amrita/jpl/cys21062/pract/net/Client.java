package com.amrita.jpl.cys21062.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @author Ruthwik Krishna Bandreddy
 * @version 0.5
 */
public class Client {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2610);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                System.out.print("Enter  message or 'q' to exit: ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

            } while (!message.equalsIgnoreCase("q"));
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error has occurred : " + e);
        }
    }
}