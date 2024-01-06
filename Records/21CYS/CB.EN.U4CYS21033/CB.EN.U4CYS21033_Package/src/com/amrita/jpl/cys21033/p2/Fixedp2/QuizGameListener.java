package com.amrita.jpl.cys21033.p2.Fixedp2;

public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
