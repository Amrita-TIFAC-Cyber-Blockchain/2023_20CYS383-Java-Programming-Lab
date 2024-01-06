package com.amrita.jpl.cys21030;

/***Author - Sai Suvarchala
 * Java Programming Lab 2
 * *
 *
 */


public interface QuizGameListener {
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}
