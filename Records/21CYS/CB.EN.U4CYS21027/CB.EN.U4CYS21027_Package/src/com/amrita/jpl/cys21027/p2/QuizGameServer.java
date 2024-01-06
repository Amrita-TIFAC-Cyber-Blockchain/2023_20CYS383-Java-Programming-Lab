/**
 * The QuizGameServer class represents a server that hosts a quiz game.
 * It listens for a client connection, asks a random question from a predefined set,
 * receives the client's answer, and evaluates the answer.
 */

package com.amrita.jpl.cys21027.p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The QuizGameServer class represents a server that listens for a client connection
 * and receives a client's answer'.
 * It listens for a client connection and receives the client's answer'.
 * It receives the client's answer and evaluates the answer
 * @author K Sri Sai Nitin
 * @version 1.0
 */

public class QuizGameServer {
    private List<String> questions;
    private List<String> answers;
    private int currIndex;

    public QuizGameServer() {
        questions = new ArrayList<>();
        questions.add("What is 1+1");
        questions.add("Who is Captain of Indian Cricket Team?");
        questions.add("Who is Prime Minister of India?");
        questions.add("Which team has most ODI WC trophies?");

        answers = new ArrayList<>();
        answers.add("2");
        answers.add("Rohit Sharma");
        answers.add("Narendra Modi");
        answers.add("Australia");
    }


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
        com.amrita.jpl.cys21027.p2.QuizGameServer server = new com.amrita.jpl.cys21027.p2.QuizGameServer();
        server.startGame();
    }
}
