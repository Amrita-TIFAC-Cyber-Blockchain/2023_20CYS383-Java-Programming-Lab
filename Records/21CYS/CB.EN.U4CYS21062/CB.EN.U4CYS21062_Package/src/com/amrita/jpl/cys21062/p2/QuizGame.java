package com.amrita.jpl.cys21062.p2;

/**
 * @author Ruthwik Krishna Bandreddy
 */
public abstract class QuizGame {
    public void startGame() {
        System.out.println("Starting the quiz game...");
        askQuestion();
    }

    protected abstract void askQuestion();

    protected abstract void evaluateAnswer(String answer);
}

