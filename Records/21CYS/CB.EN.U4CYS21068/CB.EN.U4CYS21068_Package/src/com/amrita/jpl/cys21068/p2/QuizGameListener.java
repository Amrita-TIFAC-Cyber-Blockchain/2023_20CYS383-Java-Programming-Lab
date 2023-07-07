package com.amrita.jpl.cys21068.p2;

public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(int correctness);
}
