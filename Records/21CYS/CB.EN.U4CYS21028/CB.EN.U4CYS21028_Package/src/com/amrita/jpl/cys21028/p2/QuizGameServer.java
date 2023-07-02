package com.amrita.jpl.cys21028.p2;
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
        questions.add("What is the capital of India");
        questions.add("Who is the prime minister of india?");
        questions.add("What is our class advisor name");
        questions.add("What 2 + 26");

        answers = new ArrayList<>();
        answers.add("New Delhi");
        answers.add("Narendra modi");
        answers.add("Amrita maam");
        answers.add("28");
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


/**
 * The QuizGameListener interface defines the methods to be implemented by classes
 * that listen to the quiz game events.
 */
 interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}



