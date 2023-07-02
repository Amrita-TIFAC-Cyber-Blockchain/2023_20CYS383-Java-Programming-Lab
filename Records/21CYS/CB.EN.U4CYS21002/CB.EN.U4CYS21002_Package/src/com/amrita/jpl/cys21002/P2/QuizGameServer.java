package com.amrita.jpl.cys21002.P2;



import java.util.Random;

public class QuizGameServer extends QuizGame {
    private final QuizGameListener listener;
    private final String[] questions = {
            "What is the capital of France?",
            "Who is the author of 'To Kill a Mockingbird'?",
            "What is the chemical symbol for gold?",
            "Which planet is known as the Red Planet?"
    };

    public QuizGameServer(QuizGameListener listener) {
        this.listener = listener;
    }

    @Override
    protected void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        String question = questions[index];
        listener.onQuestionAsked(question);
    }

    @Override
    protected void evaluateAnswer(String answer) {
        boolean isCorrect = false;

        switch (answer.toLowerCase()) {
            case "paris":
                isCorrect = true;
                break;
            case "harper lee":
                isCorrect = true;
                break;
            case "au":
                isCorrect = true;
                break;
            case "mars":
                isCorrect = true;
                break;
        }

        listener.onAnswerEvaluated(isCorrect);
    }
}