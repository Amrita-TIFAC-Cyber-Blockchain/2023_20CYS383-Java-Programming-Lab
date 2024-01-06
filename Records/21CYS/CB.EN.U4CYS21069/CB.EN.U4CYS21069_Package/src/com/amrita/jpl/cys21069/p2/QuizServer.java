package com.amrita.jpl.cys21069.p2;

import java.io.*;
import java.net.*;
/**
 * this was made from scrap
 * The Quizserver class represents a simple quiz between in server and client .
 * It is server
 * Usage:
 * -server
 * -creates an socket connection between cliennt and server
 * - it asks question to the client
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */

public class QuizServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for clients...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Prepare quiz questions and answers
            String[] questions = { "What is the capital of India?", "Which planet is known as the Red Planet?",
                    "What is the annual Techfest in amrita coimbatore?" };
            String[] answers = { "Delhi", "Mars", "Anokha" };

            // Setup input/output streams
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send quiz questions to the client
            for (int i = 0; i < questions.length; i++) {
                clientOutput.println(questions[i]);
                String clientAnswer = clientInput.readLine();

                // Validate client's answer
                String correctAnswer = answers[i];
                if (clientAnswer.equalsIgnoreCase(correctAnswer)) {
                    clientOutput.println("Correct!");
                } else {
                    clientOutput.println("Incorrect!");
                }
            }

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
