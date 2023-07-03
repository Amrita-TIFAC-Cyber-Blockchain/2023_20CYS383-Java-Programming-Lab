package com.amrita.jpl.cys21067.p2mysolution;

/**
 * This is my solution which I submitted
 * The QuizGame class represents an abstract quiz game.
 */
public abstract class QuizGame {

    /**
     * Starts the quiz game.
     */
    public void startGame() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Let's get started!");
        System.out.println("---------------------");
        askQuestion();
    }

    /**
     * Abstract method to ask a question in the quiz game.
     */
    abstract void askQuestion();

    /**
     * Abstract method to evaluate the answer provided by the player.
     *
     * @param answer the answer provided by the player
     */
    abstract void evaluateAnswer(String answer);
}
