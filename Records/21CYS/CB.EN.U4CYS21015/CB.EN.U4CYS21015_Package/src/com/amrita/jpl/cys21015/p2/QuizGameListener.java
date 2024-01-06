package com.amrita.jpl.cys21015.p2;

/**
 *  @author Dyanesh S
 *  @version 1.0
 */

public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
