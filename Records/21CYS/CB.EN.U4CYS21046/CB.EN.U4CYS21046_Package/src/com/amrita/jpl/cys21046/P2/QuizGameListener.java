package com.amrita.jpl.cys21046.P2;

/**
 * The QuizGameListener interface defines the methods to handle events related to a quiz game.
 * Implementing classes should provide the necessary logic to handle these events.
 *
 * @author Mukesh SA
 */
public interface QuizGameListener {

    /**
     * Called when a question is asked in the quiz game.
     *
     * @param question The question asked in the quiz.
     */
    void onQuestionAsked(String question);

    /**
     * Called when an answer is evaluated in the quiz game.
     *
     * @param isCorrect A boolean value indicating whether the evaluated answer is correct or not.
     */
    void onAnswerEvaluated(boolean isCorrect);
}
