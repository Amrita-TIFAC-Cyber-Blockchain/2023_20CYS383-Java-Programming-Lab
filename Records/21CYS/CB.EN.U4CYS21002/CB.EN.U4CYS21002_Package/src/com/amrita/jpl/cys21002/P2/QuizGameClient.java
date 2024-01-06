package com.amrita.jpl.cys21002.P2;




import java.util.Scanner;

public class QuizGameClient implements QuizGameListener {
    private final QuizGameListener listener;
    private final Scanner scanner;

    public QuizGameClient(QuizGameListener listener) {
        this.listener = listener;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        connectToServer();
        listener.onQuestionAsked(null);
    }

    private void connectToServer() {
        // Add server connection logic here
        System.out.println("Connected to the server.");
    }

    @Override
    public void onQuestionAsked(String question) {
        if (question != null) {
            System.out.println("Question: " + question);
        }

        System.out.print("Your answer: ");
        String answer = scanner.nextLine();
        listener.onAnswerEvaluated(true); // For simplicity, always consider the answer as correct
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        String result = isCorrect ? "Correct answer!" : "Wrong answer!";
        System.out.println("Result: " + result);
    }
}

