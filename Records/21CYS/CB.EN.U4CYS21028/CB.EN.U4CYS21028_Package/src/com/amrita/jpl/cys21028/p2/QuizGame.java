package com.amrita.jpl.cys21028.p2;
/**
 * Quiz game between client and server
 */
public abstract class QuizGame {
    public abstract void startGame();
    public abstract void askQuestion();
    public abstract void evaluateAnswer(String answer);
}

