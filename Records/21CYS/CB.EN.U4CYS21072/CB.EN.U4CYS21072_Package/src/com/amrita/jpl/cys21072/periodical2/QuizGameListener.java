package com.amrita.jpl.cys21072.periodical2;

public interface QuizGameListener {
    /**
     * @param question The question that has been asked.
     */
    void onQuestionAsked(String question);
    /**
     * @param isCorrect Indicates whether the answer is correct (true) or incorrect (false).
     */
    void onAnswerEvaluated(boolean isCorrect);
}