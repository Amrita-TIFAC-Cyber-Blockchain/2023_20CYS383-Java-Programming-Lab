package com.amrita.jpl.cys21045.p2;

/**
 * The QuizGame class represents an abstract quiz game.
 */
abstract class quizGame {
    abstract void startGame();

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}