package com.amrita.jpl.cys21008.P2;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @Author:Anuvarshini M K
 */

public class QuizGameServer extends QuizGame {
    /**
     * QuizGameServer
     */
    private List<String> questions;
    private List<String> answers;
    private int currIndex;

    public QuizGameServer() {
        questions = new ArrayList<>();
        questions.add("What is the capital city of India");
        questions.add("How many planets in our solar system");
        questions.add("Biggest planet in our solar system?");
        questions.add("what is 10/2 ?");

        answers = new ArrayList<>();
        answers.add("New Delhi");
        answers.add("8");
        answers.add("Jupiter");
        answers.add("5");
    }

    @Override
    public void startGame() {
        System.out.println("Starting the game!");
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());

            for (currIndex = 0; currIndex < questions.size(); currIndex++)
            //To make user finish a set of questions, we use for loop
            {
                String question = questions.get(currIndex);
                askQuestion(question, outputStream);

                try {
                    String answer = (String) inputStream.readObject();
                    evaluateAnswer(answer, outputStream);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error reading client answer.");
                }
            }

            outputStream.writeObject("Game Over");
            outputStream.flush();

            outputStream.close();
            inputStream.close();
            clientSocket.close();
            System.out.println("Client disconnected.");
        } catch (IOException e) {
            System.out.println("Error accepting client connection.");
        }

        System.out.println("All questions answered. Game over!");
    }


    public void askQuestion() {

    }

    @Override
    public void evaluateAnswer(String answer) {

    }

    public void askQuestion(String question, ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(question);
        outputStream.flush();

        System.out.println("Question: " + question);
    }

    public void evaluateAnswer(String answer, ObjectOutputStream outputStream) throws IOException {
        String correctAnswer = answers.get(currIndex);
        boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);

        outputStream.writeObject(isCorrect);
        outputStream.flush();

        System.out.println("Answer: " + answer);
        System.out.println("Correct Answer: " + correctAnswer);
        System.out.println("Result: " + (isCorrect ? "Correct" : "Incorrect"));
    }

    /**
     *
     * @param args Main
     */
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}
