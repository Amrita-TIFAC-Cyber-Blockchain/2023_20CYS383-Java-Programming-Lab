package com.amrita.jpl.cys21061.pract.QuizGameUI;
public interface QuizGameListener1 {
    /**
     * Listens to answer and gives result
     * @param question
     */
    void onQuestionAsked(String[] question);

    void onAnswerEvaluated(boolean isCorrect);
}

