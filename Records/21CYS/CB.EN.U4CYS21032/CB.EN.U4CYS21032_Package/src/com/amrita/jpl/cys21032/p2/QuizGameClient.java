public class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        server.addListener(this);
    }

    @Override
    public void startGame() {
        server.startGame();
    }

    @Override
    public void askQuestion() {
        // This method is implemented by the server; clients receive the question via onQuestionAsked()
    }

    @Override
    public void evaluateAnswer(String answer) {
        server.evaluateAnswer(answer);
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        // Display the question to the client
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is incorrect.");
        }
        // Display the result to the client
    }
}
