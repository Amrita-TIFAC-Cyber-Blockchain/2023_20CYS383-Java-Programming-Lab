package com.amrita.jpl.cys21023.p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizGameServer {
    private String[] questions = {
            "20CYS383 is the course code for JAVA LAB(true/false)?",
            "Is the color of the sky blue(true/false)?",
    };
    private int currentQuestionIndex = 0;
    private int marks = 0;

    public void startGame() {
        System.out.println("Server initiated the QuizGame!");

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (currentQuestionIndex < questions.length) {
                String question = questions[currentQuestionIndex];
                out.println(question);

                String answer = in.readLine();
                evaluateAnswer(answer);

                currentQuestionIndex++;
            }

            out.println("All questions have been asked.");
            out.println("Total Marks= " + marks);

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void evaluateAnswer(String answer) {
        boolean isCorrect = answer.equals("true");
        System.out.println("The answer is " + isCorrect);
        if (isCorrect) {
            marks++;
        }
    }

    public static void main(String[] args) {
        QuizGameServer qgs = new QuizGameServer();
        qgs.startGame();
    }
}