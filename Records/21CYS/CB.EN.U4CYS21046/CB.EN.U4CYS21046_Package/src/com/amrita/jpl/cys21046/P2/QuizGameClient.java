package com.amrita.jpl.cys21046.P2;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * A client for the Quiz Game application.
 */
public class QuizGameClient extends QuizGame implements QuizGameListener {
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    /**
     * Starts the quiz game by connecting to the server, receiving questions, and evaluating answers.
     */
    public void startGame() {
        Socket serverSocket = null;
        try {
            // Connect to the server
            serverSocket = new Socket("localhost", 12345);
            outputStream = new DataOutputStream(serverSocket.getOutputStream());
            inputStream = new DataInputStream(serverSocket.getInputStream());

            String question = inputStream.readUTF();
            int n = 10;
            while (n-- > 0) {
                // Notify the listener about the question asked
                onQuestionAsked(question);
                evaluateAnswer();
                question = inputStream.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Evaluates the user's answer and sends it to the server.
     */
    void evaluateAnswer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Answer:");
            String answer = scanner.nextLine();
            outputStream.writeUTF(answer);
            boolean isCorrect = inputStream.readBoolean();
            // Notify the listener about the evaluated answer
            onAnswerEvaluated(isCorrect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callback method called when a question is asked.
     *
     * @param question The question asked by the server.
     */
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    /**
     * Callback method called when an answer is evaluated.
     *
     * @param isCorrect Indicates whether the answer is correct or not.
     */
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer is " + (isCorrect ? "correct!" : "incorrect!"));
        try {
            int marks = inputStream.readInt();
            System.out.println("Your marks are: " + marks);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void askQuestion() {
        // This method is not used in this class
    }

    /**
     * The main method to start the Quiz Game client.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
