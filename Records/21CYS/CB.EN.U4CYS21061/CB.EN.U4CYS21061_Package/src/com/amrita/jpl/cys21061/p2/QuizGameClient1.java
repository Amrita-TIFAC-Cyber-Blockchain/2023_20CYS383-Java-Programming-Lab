package com.amrita.jpl.cys21061.p2;

import java.io.*;
import java.net.Socket;

public class QuizGameClient1 extends QuizGame {
    /**
     * Instantiates the methods for client 1 when called
     */
    private Socket cs1;

    public void startGame() throws IOException {
        cs1 = new Socket("localhost", 2448);
    }
    /**
     * Question from server
     */
    public void askQuestion() {
        try {
            DataOutputStream dout = new DataOutputStream(cs1.getOutputStream());
            dout.writeUTF("Question request from client 1");
            dout.flush();
        } catch (IOException e) {
            System.out.println("Error sending question request from client 1.");
            e.printStackTrace();
        }
    }
    /**
     * Answer to server
     */
    public void evaluateAnswer(String[] answer) {
        try {
            DataInputStream dis = new DataInputStream(cs1.getInputStream());
            DataOutputStream dout = new DataOutputStream(cs1.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str;
            do {
                String input = reader.readLine();
                dout.writeUTF(input);
                dout.flush();
                str = dis.readUTF();
                System.out.println("Message: " + str);
            } while (!str.equals("Exit"));
        } catch (IOException e) {
            System.out.println("Error evaluating answer in client 1.");
            e.printStackTrace();
        }
    }
}
