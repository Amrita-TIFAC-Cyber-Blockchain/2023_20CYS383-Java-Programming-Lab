package com.amrita.jpl.cys21089.p2;

import java.net.*;
import java.io.*;
import java.util.*;

interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameClient extends QuizGame implements QuizGameListener {
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    /**
     * function to start th client
     */
    public void startGame() {
        try {
            Socket serverSocket = new Socket("localhost", 12345);
            outputStream = new DataOutputStream(serverSocket.getOutputStream());
            inputStream = new DataInputStream(serverSocket.getInputStream());

            String question = inputStream.readUTF();
            onQuestionAsked(question);
            evaluateAnswer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void askQuestion() {
        // Not needed for client
    }
    /**
     * get input from user
     * send to server
     * try and catch for connection checking
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

    /**
     * print the question asked
     * @param question
     */
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    /**
     * print answer evaluated
     * @param isCorrect
     */
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer is " + (isCorrect ? "correct!" : "incorrect!"));
        // recieve marks from server
        try {
            int marks = inputStream.readInt();
            System.out.println("Your marks are: " + marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main fucntion of QuizGameClient
     * @param args
     */
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}