package com.amrita.jpl.cys21067.p2mysolution;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is my solution which I submitted
 * The QuizGameClient class represents a client for the quiz game.
 * It extends the QuizGame abstract class and implements the game logic for the client side.
 * @author Dharmik S
 * @version 1.0
 */
class QuizGameClient extends QuizGame {
    private QuizGameListener listener;
    private Scanner scanner;

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
        System.out.println("Starting the Quiz Game on the client side.");
        System.out.println("Connecting to the server...");
        super.startGame();
    }

    @Override
    public void askQuestion() {
        String question = "What is the capital of France?";
        if (listener != null) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    public void evaluateAnswer(String answer) {
        boolean isExit = answer.equalsIgnoreCase("exit");
        if (isExit) {
            System.out.println("Exiting the game...");
            System.exit(0);
        }

        boolean isCorrect = answer.equalsIgnoreCase("Paris");
        if (listener != null) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }

    /**
     * Runs the quiz game on the client side.
     */
    public void runGame() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();

            evaluateAnswer(answer);
        }
    }
}

/**
 * The QZClient class represents the main entry point for the quiz game client application.
 */
public class QZClient {
    public static void main(String[] args) {
        try {
            // Create a socket and streams for communication with the server
            Socket socket = new Socket("localhost", 2444);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // Create a QuizGameClient instance
            QuizGameClient client = new QuizGameClient();

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

            // Set the listener for the client
            client.setListener(listener);

            // Start the game on the client side
            client.startGame();

            Scanner scanner = new Scanner(System.in);
            String answer = "";
            do {
                System.out.print("Enter your answer (or 'exit' to quit): ");
                answer = scanner.nextLine();
                dataOutputStream.writeUTF(answer);
                dataOutputStream.flush();

                String response = dataInputStream.readUTF();
                System.out.println("Server: " + response);
            } while (!answer.equalsIgnoreCase("exit"));

            // Close the streams and socket
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
