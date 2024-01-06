package com.amrita.jpl.cys21021.P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2444);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to the server.");

            String userInput;
            do {
                userInput = userInputReader.readLine();
                writer.println(userInput);
                String response = reader.readLine();
                System.out.println("Server: " + response);
            } while (!userInput.equals("EXIT"));

            System.out.println("Connection closed.");
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}