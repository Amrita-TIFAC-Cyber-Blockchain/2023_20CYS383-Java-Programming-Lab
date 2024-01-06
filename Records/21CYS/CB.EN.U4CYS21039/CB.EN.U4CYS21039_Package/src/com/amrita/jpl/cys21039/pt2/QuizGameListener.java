package com.amrita.jpl.cys21039.pt2;
/**
 * @author Manbendra Satpathy
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}