package com.amrita.jpl.cys21063.p2;

import com.amrita.jpl.cys21063.p2.QuizGame;
import com.amrita.jpl.cys21063.p2.QuizGameClient;
import com.amrita.jpl.cys21063.p2.QuizGameListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGameServer extends QuizGame {
    List<String> questions;
    List<QuizGameListener> listeners;
    List<String> answers;

    public QuizGameServer() {

        questions = new ArrayList<>();
        questions.add("what is the name of the student Cb.en.u4cys21063?");
        questions.add("What exam is he attending right now?");

        answers = new ArrayList<>();
        answers.add("S.Adhwaith");
        answers.add("java p2 lab evaluation");

        listeners = new ArrayList<>();

    }

    @Override
    public void startGame() {
        listeners.add(new QuizGameClient(this));
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked("Let the quiz game begin!");
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
        if (answer.equalsIgnoreCase(answers.get(0))) {
            isCorrect = true;
        }
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }
}