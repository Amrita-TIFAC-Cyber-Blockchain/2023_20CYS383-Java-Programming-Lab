package com.amrita.jpl.cys21006.p2;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Madhav H
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
        questions.add("What is 1+1");
        questions.add("Who captained the Argentina National team for 2022 World Cup?");
        questions.add("Where is the tallest building in the world located?");
        questions.add("What is the capital of America?");

        answers = new ArrayList<>();
        answers.add("2");
        answers.add("Lionel Messi");
        answers.add("Dubai");
        answers.add("Washington DC");
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

    @Override
    public void askQuestion() {

    }

    @Override
    public void evaluateAnswer(String answer) {

    }

    private void askQuestion(String question, ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(question);
        outputStream.flush();

        System.out.println("Question: " + question);
    }

    private void evaluateAnswer(String answer, ObjectOutputStream outputStream) throws IOException {
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
