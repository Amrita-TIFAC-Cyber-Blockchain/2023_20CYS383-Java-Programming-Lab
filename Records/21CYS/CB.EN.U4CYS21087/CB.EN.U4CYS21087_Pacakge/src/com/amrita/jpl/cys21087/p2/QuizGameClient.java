package com.amrita.jpl.cys21087.p2;

import java.net.*;
import java.io.*;
import java.util.*;

public class QuizGameClient extends QuizGame implements QuizGameListener {
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    /**
     * 1) below function is to establish connection to the server.
     * 2) It opens a socket and listens to the server
     */
    public void startGame() {
        try {
            Socket serverSocket = new Socket("localhost", 8080);
            outputStream = new DataOutputStream(serverSocket.getOutputStream());
            inputStream = new DataInputStream(serverSocket.getInputStream());

            String question = inputStream.readUTF();
            int n = 10;
            while (n-- > 0) {
                onQuestionAsked(question);
                evaluateAnswer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void askQuestion() {
        // Not needed for client
    }
    /**
     * 1) First the client inputs the answer
     * 2) The answer gets sent to the server
     */
    void evaluateAnswer() {
        try {

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            outputStream.writeUTF(answer);
            boolean isCorrect = inputStream.readBoolean();
            onAnswerEvaluated(isCorrect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer is " + (isCorrect ? "correct!" : "incorrect!"));
        try {
            int marks = inputStream.readInt();
            System.out.println("you got" + marks + "mark");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This the main function of the Client.
     */
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}