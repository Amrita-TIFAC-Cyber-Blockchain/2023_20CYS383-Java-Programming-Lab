package com.amrita.jpl.cys21067.p2mysolution;
import java.util.Random;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is my solution which I submitted
 * The QuizGameServer class represents a server for the quiz game.
 * It extends the QuizGame abstract class and implements the game logic for the server side.
 * It also implements the QuizGameListener interface to handle game events.
 * @author Dharmik S
 * @version 1.0
 */
class QuizGameServer extends QuizGame implements QuizGameListener {
    private QuizGameListener listener;
    private String[] questions = {
            "What is the capital of India?",
            "Who painted the Mona Lisa?",
            "What comes after A?"
    };

    /**
     * Sets the listener for the quiz game events.
     *
     * @param listener the listener to set
     */
    public void setListener(QuizGameListener listener) {
        this.listener = listener;
    }

    @Override
    public void startGame() {
        System.out.println("Starting the Quiz Game on the server side.");
        super.startGame();
    }

    @Override
    public void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        String question = questions[index];

        if (listener != null) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    public void evaluateAnswer(String answer) {
        boolean isCorrect = false;

        if (answer.equalsIgnoreCase("Delhi")) {
            isCorrect = true;
        } else if (answer.equalsIgnoreCase("Leonardo da Vinci")) {
            isCorrect = true;
        } else if (answer.equalsIgnoreCase("B")) {
            isCorrect = true;
        }

        if (listener != null) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Client: Received question - " + question);
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Client: Answer evaluated - " + (isCorrect ? "Correct" : "Incorrect"));
    }
}

/**
 * The QZServer class represents the main entry point for the quiz game server application.
 */
public class QZServer {
    public static void main(String[] args) {
        try {
            // Create a server socket and wait for a client to connect
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);

            // Create a QuizGameServer instance
            QuizGameServer server = new QuizGameServer();

            // Create a QuizGameListener to handle game events
            QuizGameListener listener = new QuizGameListener() {
                @Override
                public void onQuestionAsked(String question) {
                    System.out.println("Server: Question asked - " + question);
                }

                @Override
                public void onAnswerEvaluated(boolean isCorrect) {
                    System.out.println("Server: Answer evaluated - " + (isCorrect ? "Correct" : "Incorrect"));
                }
            };

            // Set the listener for the server
            server.setListener(listener);

            // Start the game on the server side
            server.startGame();

            // Close the client socket when the game is finished
            clientSocket.close();
            System.out.println("Client socket closed.");

            // Close the server socket
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
