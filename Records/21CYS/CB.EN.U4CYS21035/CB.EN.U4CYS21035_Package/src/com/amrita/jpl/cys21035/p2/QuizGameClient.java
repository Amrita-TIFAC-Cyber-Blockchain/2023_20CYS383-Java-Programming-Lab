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

public class QuizGameClient {


    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4424);

            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            DataInputStream in = new DataInputStream(s.getInputStream());

            Scanner console = new Scanner(System.in);

            String str = "yes";
            String ans = null;
            do {
                String question = in.readUTF();
                System.out.print(question);
                String clientAnswer = console.nextLine();
                ans = clientAnswer;
                out.writeUTF(clientAnswer);
                out.flush();
                String result = in.readUTF();
                System.out.println(result);

            } while (!str.equals(ans));

            out.close();
            s.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}



