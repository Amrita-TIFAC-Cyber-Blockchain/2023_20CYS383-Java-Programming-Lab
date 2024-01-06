package com.amrita.jpl.cys21047.p2;

/**
 * com.amrita.jpl.cys21047.p2 is a Java Swing-based client application for a Quiz system.
 * In this we created class QuizGameClient that will extends to QuizGame and implements the QuizGameListener.
 * and it gets access from server.
 *
 * @author vihal roy
 * @version 0.5
 */
public class QuizGameClient extends QuizGame implements QuizGameListener {
    private final QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
    }

    /**
     * This method should connect to the server and start the quiz game.
     */
    @Override
    void startgame() {
        server.addListener(this);
        server.startgame();
    }
    /**
     * This method should receive the question from the server and display it to the client.
     */
    @Override
    void askquestions() {
        //no need of this
    }

    /**
     *  This method should send the answer to the server for evaluation and display the result to the client.
     */
    @Override
    void evaluateAnswer(String answer) {
        //no need of this
    }

    /**
     *  Implement the QuizGameListener interface in both the server and client classes.
     * In the appropriate methods, print messages indicating the questions asked answers evaluated, and the winner of the quiz game.
     */
    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question asked: " + question);
    }

    /**
     * it checks whether it is true or false.
     * @param isCorrect
     */
    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("answer is True");
        } else {
            System.out.println("answer is False");
        }
    }
}
