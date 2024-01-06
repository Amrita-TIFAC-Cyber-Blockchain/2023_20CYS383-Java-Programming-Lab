package com.amrita.jpl.cys21031.p2;

/**
 * @author Kishanth K
 * @version 1.0
 * P2
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
