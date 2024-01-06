package com.amrita.jpl.cys21030.p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class QuizGameServer extends QuizGame {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private Scanner in;


    public void startGame() {
        try {
            serverSocket = new ServerSocket(12345); // Choose a port number
            System.out.println("Server started. Waiting for clients to connect...");

            // Wait for a client to connect
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Initialize input and output streams for communication
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new Scanner(clientSocket.getInputStream());

            // Start the quiz game by asking questions to the client
            super.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the sockets and streams
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void askQuestion() {
        // Randomly select a question from predefined questions
        String question = getRandomQuestion();

        // Notify the client about the question
        out.println(question);
    }


    public void evaluateAnswer(String answer) {
        // Evaluate the given answer
        boolean isCorrect = checkAnswer(answer);

        // Notify the client whether the answer is correct
        out.println(isCorrect ? "Correct answer!" : "Incorrect answer!");
    }

    // Utility method to generate a random question
    private String getRandomQuestion() {
        // Add your logic to randomly select a question from a predefined list
        return "What is the Input?";
    }

    // Utility method to check the answer
    private boolean checkAnswer(String answer) {
        // Add your logic to compare the answer with the correct answer
        return answer.equalsIgnoreCase("Number");
    }
}
