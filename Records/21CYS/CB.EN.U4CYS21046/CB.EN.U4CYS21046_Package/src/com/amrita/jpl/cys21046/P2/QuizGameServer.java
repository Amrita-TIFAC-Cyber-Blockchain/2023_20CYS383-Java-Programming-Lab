package com.amrita.jpl.cys21046.P2;

import java.net.*;
import java.io.*;

/**
 * A server for the Quiz Game application.
 */
public class QuizGameServer extends QuizGame implements QuizGameListener {
    private DataOutputStream dops;
    private DataInputStream dips;
    int marks = 0;

    /**
     * Starts the quiz game server by accepting a client connection and conducting the quiz.
     */
    public void startGame() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            dops = new DataOutputStream(clientSocket.getOutputStream());
            dips = new DataInputStream(clientSocket.getInputStream());
            int n = 10;
            while (n-- > 0) {
                askQuestion();
                evaluateAnswer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Asks a question by sending it to the connected client.
     */
    void askQuestion() {
        String question = "What is 1 + 1 ?";
        try {
            dops.writeUTF(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Evaluates the client's answer and sends the evaluation result and marks back to the client.
     */
    void evaluateAnswer() {
        try {
            String answer = dips.readUTF();
            boolean isCorrect = answer.equals("2");
            if (isCorrect) {
                marks++;
            }
            dops.writeBoolean(isCorrect);
            dops.writeInt(marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ServerSocket serverSocket;

    /**
     * Starts the quiz game server on the specified port.
     *
     * @param port The port number to start the server on.
     */
    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callback method called when a question is asked.
     *
     * @param question The question asked by the client.
     */
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    /**
     * Callback method called when an answer is evaluated.
     *
     * @param isCorrect Indicates whether the client's answer is correct or not.
     */
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer is " + (isCorrect ? "correct!" : "incorrect!"));
        System.out.println("Your marks are: " + marks);
    }

    /**
     * The main method to start the Quiz Game server.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}
