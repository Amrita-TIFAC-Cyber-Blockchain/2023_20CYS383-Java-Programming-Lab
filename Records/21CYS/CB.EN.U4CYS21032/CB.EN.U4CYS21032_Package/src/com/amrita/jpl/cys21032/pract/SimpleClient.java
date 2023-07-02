package com.amrita.jpl.cys21032.pract;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class SimpleClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2444);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                System.out.print("Enter a message (or 'exit' to quit): ");
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