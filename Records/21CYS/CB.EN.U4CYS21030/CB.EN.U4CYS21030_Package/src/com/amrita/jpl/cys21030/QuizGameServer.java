package com.amrita.jpl.cys21030;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
/***Author - Sai Suvarchala
 * Java Programming Lab 2
 * *
 *
 */

public class QuizGameServer extends QuizGame {
    private List<String> questions;
    private Random random;

    public QuizGameServer() {
        this.questions = Arrays.asList(
                "What is the capital of France?",
                "Who painted the Mona Lisa?",
                "What is the largest planet in our solar system?"
        );
        this.random = new Random();
    }

    @Override
    public void askQuestion() {
        int randomIndex = random.nextInt(questions.size());
        String question = questions.get(randomIndex);
        notifyQuestionAsked(question);
    }

    @Override
    public void evaluateAnswer(String answer) {
        String correctAnswer = getCorrectAnswer(); // You should implement this method
        boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);
        notifyAnswerEvaluated(isCorrect);
    }

    private String getCorrectAnswer() {

        return "Correct Answer";
    }
}
