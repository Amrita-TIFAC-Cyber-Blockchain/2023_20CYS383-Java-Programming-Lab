package com.amrita.jpl.cys21008.P2;

public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

