package com.amrita.jpl.cys21060.P2;

import com.amrita.jpl.cys21060.P2.QuizGame;
import com.amrita.jpl.cys21060.P2.QuizGameClient;
import com.amrita.jpl.cys21060.P2.QuizGameListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGameServer extends QuizGame {
    List<String> questions;
    List<QuizGameListener> listeners;
    List<String> answers;

    public QuizGameServer() {

        questions = new ArrayList<>();
        questions.add("Who is the father of the nation ?");
        questions.add("What is the capital of India ?");

        answers = new ArrayList<>();
        answers.add("Gandhi");
        answers.add("Delhi");

        listeners = new ArrayList<>();

    }

    @Override
    public void startGame() {
        listeners.add(new QuizGameClient(this));
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked("The Quiz begins!!!");
        }
        askQuestion();
    }

    @Override
    public void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        String question = questions.get(index);

        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    public void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        if (answer.equalsIgnoreCase(answers.get(0)) || answer.equalsIgnoreCase(answers.get(1))) {
            isCorrect = true;
        }
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }
}