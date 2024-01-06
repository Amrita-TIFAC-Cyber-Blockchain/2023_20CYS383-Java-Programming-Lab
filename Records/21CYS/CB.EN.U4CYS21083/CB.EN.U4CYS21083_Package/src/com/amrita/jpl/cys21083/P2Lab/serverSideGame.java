package com.amrita.jpl.cys21083.P2Lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author Revan - CB.EN.U4CYS21083
 */
abstract class QuizGame {
    void startGame() {
    }
    abstract void askQuestion();

    /**
     *
     * @param answer IT PASSES THE ANSWER TO EVALUVATE WHETHER IT IS CORRECT OR WRONG
     */
    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {

    /**
     *
     * @param question IT PASSES THE QUESTION THAT SHOULD BE ASKED
     */
    void onQuestionAsked(String question);

    /**
     *
     * @param isCorrect IT IS A BOOLEN IF QUESTION IS CORRECT IT GIVE TRUE OR FALSE
     */
    void onAnswerEvaluated(boolean isCorrect);

    /**
     *
     * @param answer IT PASSES THE ANSWER TO EVALUVATE WHETHER IT IS CORRECT OR WRONG
     */
    void evaluateAnswer(String answer);
}

abstract class QuizGameServer extends QuizGame {
    private ServerSocket serverSocket;
    private QuizGameListener listener;
    private String[] questions = {
            "What is Today's Lab Evaluvation Subject",
            "Who is JavaProgramming Lab Faculty",
            "SubjectCode for Java Programming Lab"
    };
    private String[] answers = {
            "Java",
            "Ramaguru R",
            "20CYS383"
    };

    void setListener(QuizGameListener listener) {
        this.listener = listener;
    }

    @Override
    public void startGame() {
        try {
            System.out.println("Waiting for client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            for (int i = 0; i < questions.length; i++) {
                askQuestion(clientSocket);
                evaluateAnswer(clientSocket, answers[i]);
            }
            System.out.println("Quiz game over!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param clientSocket PASSING THE CLIENT SOCKET FOR ASKING THE QUESTION TO CLIENT
     * @throws IOException TROWS ERROR
     */
    private void askQuestion(Socket clientSocket) throws IOException {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        String question = questions[index];

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(question);
    }

    /**
     *
     * @param clientSocket PASSING THE CLIENT SOCKET FOR ASKING THE QUESTION TO CLIENT
     * @param answer IT PASSES THE ANSWER TO EVALUVATE WHETHER IT IS CORRECT OR WRONG
     * @throws IOException THROES ERROR
     */
    private void evaluateAnswer(Socket clientSocket, String answer) throws IOException {
        // Simulate answer evaluation
        Random random = new Random();
        boolean isCorrect = random.nextBoolean();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(isCorrect);
    }
}

public class serverSideGame {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        //serverSocket.startGame();
        // super.startGame();
    }
}

