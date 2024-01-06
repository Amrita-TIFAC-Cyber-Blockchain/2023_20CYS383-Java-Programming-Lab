package com.amrita.jpl.cys21062.p2;
import java.util.Random;

public class QuizGameServer extends QuizGame {
    private String[] questions = {
            "1+1=?",
            "2+3=?",
            "4+5=?"
    };

    private String[] answers = {
            "Paris",
            "Jane Austen",
            "Jupiter"
    };

    private int score = 0;
    private QuizGameListener listener;

    public QuizGameServer(QuizGameListener listener) {
        this.listener = listener;
    }

    @Override
    public void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        String question = questions[index];
        listener.onQuestionAsked(question);
    }

    @Override
    public void evaluateAnswer(String answer) {
        int index = -1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase(answer)) {
                index = i;
                break;
            }
        }

        boolean isCorrect = index != -1;
        listener.onAnswerEvaluated(isCorrect);

        if (isCorrect) {
            score++;
        }

        System.out.println("Score: " + score);

        askQuestion();
    }
}


