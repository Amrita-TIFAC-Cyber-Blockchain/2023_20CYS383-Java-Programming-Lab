package com.amrita.jpl.cys21083.P2Lab;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;
import java.net.Socket;

/**
 * @author Revan - CB.EN.U4CYS21083
 */
abstract class QuizGameClient extends QuizGame implements
        QuizGameListener {
    private ServerSocket clientSocket;
    private QuizGameListener listener;
    private Scanner scanner;

    void setListener(QuizGameListener listener) {
        this.listener = listener;
    }

    @Override
    void startGame() {
        System.out.println("Quiz game started!");
        try {
            BufferedReader in = null;
            int inputStream = clientSocket.getLocalPort();
            String question;
            while ((question = in.readLine()) != null) {
                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                evaluateAnswer(answer, clientSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Quiz game over!");
    }

    @Override
    void askQuestion() {
    }

    @Override
    public void evaluateAnswer(String answer) {
    }

    /**
     *
     * @param answer IT PASSES THE ANSWER TO server to EVALUVATE WHETHER IT IS CORRECT OR WRONG
     * @param clientSocket
     * @throws IOException throws error
     */
    private void evaluateAnswer(String answer, Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(answer);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        boolean isCorrect = Boolean.parseBoolean(in.readLine());

        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }
}

public class clientSideGame {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 2020);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }
}
