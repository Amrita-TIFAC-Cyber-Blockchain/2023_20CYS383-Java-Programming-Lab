package com.amrita.jpl.cys21035.p2;
/**
 * IAbstract class
 * @author M C Vivek Veera
 * Refered ChatClient.java ChatServer.java
 */
public abstract class QuizGame {
    private QuizGameListener listener;
    public void set(QuizGameListener listener) {
        this.listener = listener;
    }

    public void startGame() {
        for (int i = 0; i < 3; i++) {
            String question = askQuestion(i);
            listener.onQuestionAsked(question);
            String answer = get();
            evaluateAnswer(i, answer);
            listener.onAnswerEvaluated(true);
        }
    }

    private String get() {
        return null;
    }
    protected abstract String askQuestion(int i);

    protected abstract void evaluateAnswer(int i, String answer);

}

