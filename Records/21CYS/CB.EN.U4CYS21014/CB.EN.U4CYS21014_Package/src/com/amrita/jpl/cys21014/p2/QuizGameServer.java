package com.amrita.jpl.cys21014.p2;

/**
 * @author: Deepthi J
 * @version: 1.0
 *
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * declaring abstract class
 */
abstract class QuizGame{

    public String question;
    public String answer;
    public void startGame() {

    }
    public abstract void askQuestion();
    public abstract void evaluateAnswer();

}
/**
 * extending abstract class
 */
public class QuizGameServer extends QuizGame {


    public void askQuestion(){
    }

    public void evaluateAnswer(){

    }
    /**
     * main function to carry out the flow of the game
     */
    public static void main(String[] args) {
        QuizGameServer obj1 = new QuizGameServer();

        try {
            ServerSocket server = new ServerSocket(2444);
            Socket client = server.accept();
            DataInputStream d_in = new DataInputStream(client.getInputStream());
            DataOutputStream d_out = new DataOutputStream(client.getOutputStream());
            d_out.writeUTF("Question 1:\n1000*1000 = ?");
            d_out.flush();
            String answer;
            answer = d_in.readUTF();
            System.out.println("Answer received from player 1: " + answer);
            if(answer.equals("1000000")){
                d_out.writeUTF("Answer correct. You won!");
                d_out.flush();
            }
            else{
                d_out.writeUTF("Incorrect answer. Better luck next time!");
                d_out.flush();
            }
            server.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}