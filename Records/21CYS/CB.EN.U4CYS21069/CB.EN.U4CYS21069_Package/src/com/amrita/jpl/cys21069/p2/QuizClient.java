package com.amrita.jpl.cys21069.p2;

import java.io.*;
import java.net.*;

/**
 * this was made from scrap
 * The QuizClient class represents a simple quiz between in server and client .
 * It is client
 * Usage:
 * -client
 * -creates an socket connection between client and server
 * -it gives the answers for the questions asked by server
 *
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */
public class QuizClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",12345);

            // Setup input/output streams
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

            // Receive and answer quiz questions
            String question;
            while ((question = serverInput.readLine()) != null) {
                System.out.println("Question: " + question);
                String answer = getUserInput();

                // Send answer to the server
                serverOutput.println(answer);

                // Receive and display the server's response
                String response = serverInput.readLine();
                System.out.println("Server: " + response);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Your answer: ");
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
