package com.amrita.jpl.cys21083.P2Lab.Modified;

/**
 * @author Venkata Revan Nagireddy - CB.EN.U4CYS21082
 */

public interface listenerGame {
    /**
     * Called when a question is asked.
     *
     * @param question The question that has been asked.
     */
    void onQuestionAsked(String question);

    /**
     * Called when an answer is evaluated.
     *
     * @param isCorrect Indicates whether the answer is correct (true) or incorrect (false).
     */
    void onAnswerEvaluated(boolean isCorrect);
}