package com.amrita.jpl.cys21047.p2;

/**
 * com.amrita.jpl.cys21047.p2 is a Java Swing-based client application for a Quiz system.
 * This class should implement the server-side functionality.
 *
 * @author vihal roy
 * @version 0.5
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * we created class QuizGameServer that extends to QuizGame.
 */
class QuizGameServer extends QuizGame {
    private final List<String> questions;
    private final List<String> answers;
    private final List<QuizGameListener> listeners;

    /**
     * we asked some questions and answers.
     */
    public QuizGameServer() {
        questions =  new ArrayList<>();
        questions.add("1+1");
        questions.add("1+2");
        answers = new ArrayList<>();
        answers.add("2");
        answers.add("6");
        listeners = new ArrayList<>();
    }

    /**
     * This method should start the quiz game by asking questions to the clients.
     */
    @Override
    void startgame() {
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked("quiz starts: ");
        }
        askquestions();
    }

    /**
     * This method should randomly select a question from predefined questions and notify the clients about the question.
     */
    @Override
    void askquestions() {
        Random num = new Random();
        int index = num.nextInt(questions.size());
        String question = questions.get(index);
        String answer = answers.get(index);

        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
        evaluateAnswer(answer);
    }

    /**
     * This method should evaluate the given answer and notify the clients whether the answer is correct.
     * @param answer
     */
    @Override
    void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        if (answer.equalsIgnoreCase(answers.get(0))) {
            isCorrect = true;
        }
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }

    }

    /**
     * it is just a Listener which checks.
     * @param listener
     */
    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }
}
