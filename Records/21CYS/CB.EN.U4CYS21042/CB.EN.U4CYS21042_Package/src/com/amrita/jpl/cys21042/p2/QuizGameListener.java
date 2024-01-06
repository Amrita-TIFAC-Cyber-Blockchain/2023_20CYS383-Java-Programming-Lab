package com.amrita.jpl.cys21042.p2;

/**
 * @Author : Mittul R
 * @Version : 1.1
 */

public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
