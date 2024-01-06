import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGameServer extends QuizGame {
    private List<QuizGameListener> listeners;
    private List<String> questions;
    private Random random;
    private int currentQuestionIndex;

    public QuizGameServer() {
        listeners = new ArrayList<>();
        questions = new ArrayList<>();
        random = new Random();
        currentQuestionIndex = -1;
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    @Override
    public void startGame() {
        askQuestion();
    }

    @Override
    public void askQuestion() {
        currentQuestionIndex = random.nextInt(questions.size());
        String question = questions.get(currentQuestionIndex);
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    public void evaluateAnswer(String answer) {
        boolean isCorrect = answer.equalsIgnoreCase("OpenAI"); // Replace with your evaluation logic
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }
}
