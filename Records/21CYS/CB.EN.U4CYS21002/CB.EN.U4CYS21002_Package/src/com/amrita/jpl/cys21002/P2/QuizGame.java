package com.amrita.jpl.cys21002.P2;



public abstract class QuizGame {
    public void startGame() {
        askQuestion();
        // Additional game flow logic can be added here
    }

    protected abstract void askQuestion();

    protected abstract void evaluateAnswer(String answer);
}
