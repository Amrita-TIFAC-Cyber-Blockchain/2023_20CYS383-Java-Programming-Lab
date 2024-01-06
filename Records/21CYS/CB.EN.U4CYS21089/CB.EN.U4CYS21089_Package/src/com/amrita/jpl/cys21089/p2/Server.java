package com.amrita.jpl.cys21089.p2;

/**
 * @author Yaswanth Gadamsetti
 * @version 1.0
 * */

import java.net.*;
import java.io.*;
import java.util.Random;

class QuizGameServer extends QuizGame implements QuizGameListener {
    private DataOutputStream dops;
    private DataInputStream dips;
    private boolean isCorrect = false;
    int marks = 0;

    private final String[] quizQuestions = {
            "What is the course code of Java Programming?",
            "Who is the faculty teaching Java programming Subject?",
            "What is the roll number of Yaswanth?"
    };
    private final String[] quizAnswers = {
            "CYS383",
            "Ramaguru R",
            "CYS21089"
    };

    /**
     * function to establish connection to the client. Opens a socket and listens to the client
     */
    public void startGame() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client to connect...");
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                dops = new DataOutputStream(clientSocket.getOutputStream());
                dips = new DataInputStream(clientSocket.getInputStream());
                askQuestion();
                evaluateAnswer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the question
     */
    void askQuestion() {
        Random a = new Random();
        int selection = a.nextInt(3);
        String question = quizQuestions[selection];
        try {
            dops.writeUTF(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void evaluateAnswer() {
        try {
            String answer = dips.readUTF();
            for (String quizAnswer : quizAnswers) {
                if (answer.equals(quizAnswer)) {
                    isCorrect = true;
                }
            }
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
        System.out.println("Question: " + question);
    }

    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer is " + (isCorrect ? "correct!" : "incorrect!"));
        System.out.println("Your marks are: " + marks);
    }

    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}