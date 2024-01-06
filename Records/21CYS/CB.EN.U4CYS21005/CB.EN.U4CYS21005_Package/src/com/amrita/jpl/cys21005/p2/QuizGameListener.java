package com.amrita.jpl.cys21005.p2;

/**
 * @author Alagu Soundarya G
 * @version 1.0
 * P2
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
