package com.amrita.jpl.cys21054.p2;
/**
 * @author P Jivan Prasadd
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}