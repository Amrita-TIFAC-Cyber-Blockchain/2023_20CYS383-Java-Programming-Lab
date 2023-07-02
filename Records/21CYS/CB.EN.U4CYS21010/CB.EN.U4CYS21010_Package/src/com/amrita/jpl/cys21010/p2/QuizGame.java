package com.amrita.jpl.cys21010.p2;

import java.io.IOException;

public abstract  class QuizGame {
    void startGame() throws IOException {
        System.out.println("Game Started...!!");

    }
    abstract  void askQuestion() throws IOException;
    abstract void evaluateAnswer() throws IOException;
}
