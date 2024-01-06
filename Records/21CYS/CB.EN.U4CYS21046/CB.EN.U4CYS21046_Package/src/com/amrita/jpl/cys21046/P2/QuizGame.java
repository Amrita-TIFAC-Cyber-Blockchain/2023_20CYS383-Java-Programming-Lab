package com.amrita.jpl.cys21046.P2;

/**
 * The QuizGame class is an abstract base class that represents a quiz game.
 * Subclasses must implement the startGame, askQuestion, and evaluateAnswer methods to define the specific behavior of the quiz game.
 *
 * @author Mukesh SA
 */
public abstract class QuizGame {

    /**
     * Starts the quiz game.
     * Subclasses must implement this method to define how the game is started.
     */
    public abstract void startGame();

    /**
     * Asks a question during the quiz game.
     * Subclasses must implement this method to define how questions are asked.
     */
    abstract void askQuestion();

    /**
     * Evaluates the answer provided during the quiz game.
     * Subclasses must implement this method to define how answers are evaluated.
     */
    abstract void evaluateAnswer();
}
