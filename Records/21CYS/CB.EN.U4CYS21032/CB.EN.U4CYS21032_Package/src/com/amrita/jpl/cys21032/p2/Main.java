public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);

        server.addQuestion("What is the capital of France?");
        server.addQuestion("What is the square root of 144?");
        server.addQuestion("Who developed the GPT-3.5 model?");

        client.startGame();
    }
}
