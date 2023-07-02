package com.amrita.jpl.cys21014.p2;
/**
 * @author: Deepthi J
 * @version: 1.0
 *
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
/**
 * declaring interface
 */

interface QuizGameListener{
    public void onQuestionAsked(String question);
    public void onAnswerEvaluated(boolean isCorrect);

}
/**
 * implementing interface
 */
public class QuizGameClient implements QuizGameListener  {

    public void onQuestionAsked(String question){

    }
    public void onAnswerEvaluated(boolean isCorrect){

    }
    /**
     * main function to carry out the flow of the game
     */
    public static void main(String[] args) {
        QuizGameClient obj1 = new QuizGameClient();
        try {
            Socket client = new Socket("localhost", 2444);
            DataOutputStream d_out = new DataOutputStream(client.getOutputStream());
            DataInputStream d_in = new DataInputStream(client.getInputStream());
            String question = d_in.readUTF();
            System.out.println("Question: " + question);
            Scanner input = new Scanner(System.in);
            System.out.println("Please type your answer here: ");
            String answer = input.nextLine();
            d_out.writeUTF(answer);
            d_out.flush();
            String result = d_in.readUTF();
            System.out.println("Result: " + result);
            d_out.close();
            client.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}