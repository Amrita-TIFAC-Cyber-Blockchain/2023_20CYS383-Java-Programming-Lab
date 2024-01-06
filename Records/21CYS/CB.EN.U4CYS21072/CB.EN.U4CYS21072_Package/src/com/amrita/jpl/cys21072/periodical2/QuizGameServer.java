package com.amrita.jpl.cys21072.periodical2;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */


public class QuizGameServer extends QuizGame {

    private List<String> questions;
    private List<String> answers;
    private int currIndex;

    public QuizGameServer() {
        questions = new ArrayList<>();
        questions.add("Number of states in India?");
        questions.add("Name the Pink city of India");
        questions.add("Where is Taj Mahal located?");
        questions.add("Kerela is also known as?");

        answers = new ArrayList<>();
        answers.add("29");
        answers.add("Jaipur");
        answers.add("Agra");
        answers.add("City of God");
    }

    public void startGame() {
        System.out.println("Starting the game!");
        try (ServerSocket serverSocket = new ServerSocket(2424)) {
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

    /**
     * Asks a question to the client by sending it through the output stream.
     *
     * @param question      The question to be asked.
     * @param outputStream  The output stream used to send data to the client.
     * @throws IOException  If an I/O error occurs while writing the question to the output stream.
     */
    private void askQuestion(String question, ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(question);
        outputStream.flush();

        System.out.println("Question: " + question);
    }

    /**
     * Evaluates the client's answer by comparing it with the correct answer and sends the evaluation result through the output stream.
     *
     * @param answer         The client's answer to be evaluated.
     * @param outputStream   The output stream used to send data to the client.
     * @throws IOException   If an I/O error occurs while writing the evaluation result to the output stream.
     */
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

