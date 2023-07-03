package com.amrita.jpl.cys21087.p2;

import java.net.*;
import java.io.*;

public class QuizGameServer extends QuizGame implements QuizGameListener {
    private DataOutputStream dops;
    private DataInputStream dips;
    int marks = 0;

    /**
     * 1) below function is to establish connection to the client.
     * 2) It opens a socket and listens to the client
     */
    public void startGame() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("waiting for client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("client connected!");

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
     * The server asks question to the client
     */
    void askQuestion() {
        String question = "What is the name of the new AR headset released by Apple ?";
        try {
            dops.writeUTF(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void evaluateAnswer() {
        try {
            String answer = dips.readUTF();
            boolean isCorrect = answer.equals("Vision Pro");
            // increment marks if answer is correct
            if (isCorrect) {
                marks++;
            }
            dops.writeBoolean(isCorrect);
            // send marks to client
            dops.writeInt(marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onQuestionAsked(String question) {
        System.out.println("question: " + question);
    }

    /**
     * Answer evaluation by the Server
     * Condition to check if the answer of client is correct or not
    */
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("answer is " + (isCorrect ? "correct!" : "incorrect!"));
        System.out.println("your marks are: " + marks);
    }

    /**
     * This the main function of the Client.
     */
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}