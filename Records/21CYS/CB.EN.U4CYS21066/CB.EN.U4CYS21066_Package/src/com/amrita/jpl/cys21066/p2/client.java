package com.amrita.jpl.cys21066.p2;

import java.util.Scanner;

// Abstract class representing the Quiz Game
abstract class QuizGame {
    abstract void startGame();
    abstract void askQuestions();
    abstract void evaluateAnswers(String[] answers);
}

// Interface for the Quiz Game listener
interface QuizGameListener {
    void onQuestionsAsked(String[] questions);
    void onAnswersEvaluated(boolean[] isCorrect);
}


// Quiz Game Client
class QuizGameClient extends QuizGame implements QuizGameListener {
    private Server.QuizGameServer server;

    @Override
    void startGame() {
        server = new Server.QuizGameServer();
        server.setListener(this);
        server.startGame();
    }

    @Override
    void askQuestions() {
        // Do nothing (handled by the server)
    }

    @Override
    void evaluateAnswers(String[] answers) {
        // Do nothing (handled by the server)
    }

    @Override
    public void onQuestionsAsked(String[] questions) {
        System.out.println("Questions:");
        for (String question : questions) {
            System.out.println(question);
        }
        Scanner scanner = new Scanner(System.in);
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            answers[i] = scanner.nextLine();
        }
        server.evaluateAnswers(answers);
    }

    @Override
    public void onAnswersEvaluated(boolean[] isCorrect) {
        System.out.println("Answers:");
        for (boolean correct : isCorrect) {
            if (correct) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
            }
        }
    }
}

// Main class to start the quiz game
public class client {
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
