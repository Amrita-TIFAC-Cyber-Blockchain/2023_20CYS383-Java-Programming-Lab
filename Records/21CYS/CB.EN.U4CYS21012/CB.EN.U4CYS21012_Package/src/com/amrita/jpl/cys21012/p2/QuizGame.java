package com.amrita.jpl.cys21012.p2;

public abstract class QuizGame {
    abstract void askQuestion();
    abstract void evaluateAnswer(String answer);

    void startGame(){
        System.out.println("Starting the game...");
    }
}
