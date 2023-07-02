package com.amrita.jpl.cys21045.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Abstract class representing the Quiz Game
abstract class QuizGame {
    abstract void startGame();

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);

}
class QuizGameServer extends quizGame {
    private List<String> questions;
    private List<QuizGameListener> listeners;

    public QuizGameServer() {
        questions = new ArrayList<>();
        questions.add("What is the capital of France?");
        questions.add("Who painted the Mona Lisa?");
        questions.add("What is the largest planet in our solar system?");

        listeners = new ArrayList<>();
    }

    // Server-side code
    @Override
    void startGame() {
        askQuestion();
    }

    @Override
    void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        String question = questions.get(index);

        // Notify listeners about the question
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        // Perform answer evaluation logic
        if (answer.equalsIgnoreCase("Paris")) {
            isCorrect = true;
        } else if (answer.equalsIgnoreCase("Leonardo da Vinci")) {
            isCorrect = true;
        } else if (answer.equalsIgnoreCase("Jupiter")) {
            isCorrect = true;
        }

        // Notify listeners about the answer evaluation
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }
}
public class Server {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}