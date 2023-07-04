package com.amrita.jpl.cys21066.p2;

public class Server {
    // Quiz Game Server
    static class QuizGameServer extends QuizGame {
        private QuizGameListener listener;
        private String[] questions = {
                "Who is the jersey sponsor for Indian Cricket team ?",
                "Who painted the Mona Lisa?",
                "What is the smallest planet in our solar system?",
                "what is the Colour of the apple?"
        };
        private String[] answers = {
                "Adidas",
                "Leonardo da Vinci",
                "Mercury",
                "Red"
        };

        @Override
        void startGame() {
            askQuestions();
        }

        @Override
        void askQuestions() {
            if (listener != null) {
                listener.onQuestionsAsked(questions);
            }
        }

        @Override
        void evaluateAnswers(String[] answers) {
            boolean[] isCorrect = new boolean[answers.length];
            for (int i = 0; i < answers.length; i++) {
                isCorrect[i] = answers[i].equalsIgnoreCase(this.answers[i]);
            }
            if (listener != null) {
                listener.onAnswersEvaluated(isCorrect);
            }
        }

        void setListener(QuizGameListener listener) {
            this.listener = listener;
        }
    }
}
