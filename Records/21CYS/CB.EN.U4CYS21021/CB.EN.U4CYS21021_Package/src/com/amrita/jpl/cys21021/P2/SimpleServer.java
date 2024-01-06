package com.amrita.jpl.cys21021.P2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Server started. Waiting for a client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            do {
                String clientMessage = reader.readLine();
                System.out.println("Client: " + clientMessage);

                userInput = userInputReader.readLine();
                writer.println(userInput);
                writer.flush();
            } while (!userInput.equals("EXIT"));

            System.out.println("Connection closed.");
            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
