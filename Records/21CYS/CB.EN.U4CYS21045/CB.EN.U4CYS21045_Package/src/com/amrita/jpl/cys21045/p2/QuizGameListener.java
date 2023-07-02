package com.amrita.jpl.cys21045.p2;

/**
 * The QuizGameListener interface defines the contract for listening to quiz game events.
 */
interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

    /**
     * Called when a question is asked in the quiz game.
     *
     * @param question the question asked
     */

