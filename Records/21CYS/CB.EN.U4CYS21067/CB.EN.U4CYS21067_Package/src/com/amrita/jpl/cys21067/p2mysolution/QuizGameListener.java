package com.amrita.jpl.cys21067.p2mysolution;

/**
 * This is my solution which I submitted
 * The QuizGameListener interface defines the contract for listening to quiz game events.
 */
public interface QuizGameListener {

    /**
     * Called when a question is asked in the quiz game.
     *
     * @param question the question asked
     */
    void onQuestionAsked(String question);

    /**
     * Called when an answer is evaluated in the quiz game.
     *
     * @param isCorrect true if the answer is correct, false otherwise
     */
    void onAnswerEvaluated(boolean isCorrect);
}
