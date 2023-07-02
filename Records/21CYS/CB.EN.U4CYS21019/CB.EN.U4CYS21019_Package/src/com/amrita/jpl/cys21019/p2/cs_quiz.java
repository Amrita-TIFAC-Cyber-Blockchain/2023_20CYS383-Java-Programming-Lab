package com.amrita.jpl.cys21019.p2;

import java.util.Scanner;

/**
 * Author: Gokulachselvan C D
 * Description: This program demonstrates a simple online quiz game between server and client
 */

abstract class QuizGame {
    // Abstract class representing the Quiz Game
    protected QuizGameListener user;
    protected int score;

    public void setListener(QuizGameListener user) {
        this.user = user;
    }

    public void startGame() {
        askQuestion();
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}


interface QuizGameListener {
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);

    void onFinish(int score);
}

class QuizGameServer extends QuizGame {
    // Server class for the Quiz Game
    private String[] questions = {
            "Which district is called the Textile capital of Tamilnadu?",
            "Which district is called the Manchester of South India?",
            "Which city is called the Turmeric city in Tamilnadu?",
            "Which city is called the Baniyan city in Tamilnadu?"
    };

    private String[] answers = {
            "Karur",
            "Coimbatore",
            "Erode",
            "Tiruppur"
    };

    private int index = -1;

    @Override
    public void askQuestion() {
        index++;
        if (index < questions.length) {
            String question = questions[index];
            user.onQuestionAsked(question);
        } else {
            user.onFinish(score);
        }
    }

    public void evaluateAnswer(String answer) {
        if (index < answers.length) {
            String correctAns = answers[index];
            boolean isCorrect = answer.equalsIgnoreCase(correctAns);
            user.onAnswerEvaluated(isCorrect);
            if (isCorrect) {
                score += 2;
            }
            askQuestion();
        }
    }
}


// Client class for the Quiz Game
class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;
    private int totalScore;
    private Scanner scanner;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        server.setListener(this);
        server.startGame();
    }

    public void askQuestion() {
        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine();
        evaluateAnswer(answer);
    }

    public void evaluateAnswer(String answer) {
        server.evaluateAnswer(answer);
    }

    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        askQuestion();
    }

    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Your answer is correct");
        } else {
            System.out.println("Your answer is wrong");
        }
    }

    public void onFinish(int score) {
        totalScore = score;
        System.out.println("Your final score: " + totalScore);
        if (totalScore >= 8) {
            System.out.println("Congratulations! You won the quiz!");
        } else {
            System.out.println("Sorry! You lost the quiz.");
        }
    }
}

public class cs_quiz {
    // Main class for the Quiz Game
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();
    }
}

/*abstract class QuizGame {
    protected QuizGameListener user;
    protected int score;

    public void setListener(QuizGameListener user) {
        this.user = user;
    }

    public void startGame() {
        askQuestion();
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}


interface QuizGameListener {
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);

    void onFinish(int score);
}

class QuizGameServer extends QuizGame {
    private String[] questions = {
            "Which district is called Textile capital of Tamilnadu?",
            "Which district is called Manchester of South India?",
            "Which city is called Turmeric city in Tamilnadu?",
            "Which city is called Baniyan city in Tamilnadu?"
    };

    private String[] answers = {
            "Karur",
            "Coimbatore",
            "Erode",
            "Tiruppur"
    };

    private int index = -1;

    @Override
    public void askQuestion() {
        index++;
        if (index < questions.length) {
            String question = questions[index];
            user.onQuestionAsked(question);
        } else {
            user.onFinish(score);
        }
    }

    public void evaluateAnswer(String answer) {
        if (index < answers.length) {
            String correctAnswer = answers[index];
            boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);
            user.onAnswerEvaluated(isCorrect);
            if (isCorrect) {
                score += 2;
            }
        }
    }
}


//client
class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
    }

    public void startGame() {
        server.setListener(this);
        server.startGame();
    }

    public void askQuestion() {
    }

    public void evaluateAnswer(String answer) {
        server.evaluateAnswer(answer);
    }

    public void onQuestionAsked(String question) {
        System.out.println("Question that was asked: " + question);
    }

    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Answer is correct");
        } else {
            System.out.println("Answer is wrong");
        }
        server.askQuestion();
    }

    public void onFinish(int score) {
        System.out.println("Your score: " + score);
        if (score >= 6) {
            System.out.println("You are the winner!");
        } else {
            System.out.println("You lost the game.");
        }
    }
}

public class cs_quiz {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();

        client.evaluateAnswer("Karur");
        client.evaluateAnswer("Coimbatore");
        client.evaluateAnswer("Erode");
        client.evaluateAnswer("Tiruppur");
    }
}*/