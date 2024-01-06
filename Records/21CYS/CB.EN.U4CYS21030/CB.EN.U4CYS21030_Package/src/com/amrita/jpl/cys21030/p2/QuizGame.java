package com.amrita.jpl.cys21030.p2;

import java.util.ArrayList;
import java.util.List;

/***Author - Sai Suvarchala
 * Java Programming Lab 2
 * *
 *
 */

public abstract class QuizGame {
    private List<QuizGameListener> listeners;

    public QuizGame() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }

    public void removeListener(QuizGameListener listener) {
        listeners.remove(listener);
    }

    public void notifyQuestionAsked(String question) {
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    public void notifyAnswerEvaluated(boolean isCorrect) {
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }

    public void startGame() {
        askQuestion();
    }

    public abstract void askQuestion();

    public abstract void evaluateAnswer(String answer);
}
