package com.amrita.jpl.cys21015.p2;

import java.io.IOException;

/**
 *  @author Dyanesh S
 *  @version 1.0
 */

public abstract class QuizGame {
    void startGame() throws IOException {

    }

    abstract void askQuestion() throws IOException, ClassNotFoundException;
    abstract void evaluateAnswer(String answer) throws IOException;
}
