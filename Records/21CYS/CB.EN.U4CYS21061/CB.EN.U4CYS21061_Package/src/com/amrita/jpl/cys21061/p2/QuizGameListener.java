package com.amrita.jpl.cys21061.p2;

public interface QuizGameListener {
    /**
     * Listens to answer and gives result
     * @param question
     */
    void onQuestionAsked(String[] question);

    void onAnswerEvaluated(boolean isCorrect);
}

