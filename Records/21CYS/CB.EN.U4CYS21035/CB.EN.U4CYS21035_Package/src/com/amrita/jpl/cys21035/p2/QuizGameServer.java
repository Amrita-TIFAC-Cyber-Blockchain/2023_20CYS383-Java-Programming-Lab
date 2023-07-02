package com.amrita.jpl.cys21035.p2;
/**
 * Note: The server must be running before executing the client program.
 *
 * To change the host and port, modify the arguments of the Socket constructor.
 *
 * @author M C Vivek Veera
 * Refered ChatClient.java ChatServer.java
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class QuizGameServer {
    public static void main(String[] args) {
        try {
            ServerSocket soc = new ServerSocket(4424);
            Socket s = soc.accept();

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner console = new Scanner(System.in);

            String[] questions = {
                    "On wall. Has hands",
                    "JPL Lecturer",
                    "2+3"
            };

            String[] answers = {
                    "Clock",
                    "Ramaguru",
                    "5"
            };

            for (int i = 0; i < questions.length; i++) {
                out.writeUTF(questions[i]);
                out.flush();

                String clientAnswer = in.readUTF();
                System.out.println("Input: " + clientAnswer);

                String correctAnswer = answers[i];
                String message;
                if (clientAnswer.equalsIgnoreCase(correctAnswer)) {
                    message = "Correct";
                } else {
                    message = "Wrong \nAnswer is: " + correctAnswer;
                }
                out.writeUTF(message);
                out.flush();
            }
            out.writeUTF("Exit?");
            out.flush();

            soc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
