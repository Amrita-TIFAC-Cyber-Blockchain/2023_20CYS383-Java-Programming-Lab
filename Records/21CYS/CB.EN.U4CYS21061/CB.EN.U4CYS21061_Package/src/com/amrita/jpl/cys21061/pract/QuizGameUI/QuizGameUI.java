package com.amrita.jpl.cys21061.pract.QuizGameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QuizGameUI extends JFrame implements QuizGameListener1 {
    private JButton startButton;
    private JTextArea questionArea;
    private JTextField answerField;
    private JButton submitButton;
    private JTextArea resultArea;

    private QuizGameServer1 server;
    private QuizGameClient01 client1;
    private QuizGameClient02 client2;

    public QuizGameUI() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setLayout(new FlowLayout());

        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        questionArea = new JTextArea(10, 30);
        questionArea.setEditable(false);
        JScrollPane questionScrollPane = new JScrollPane(questionArea);

        answerField = new JTextField(20);

        submitButton = new JButton("Submit Answer");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = answerField.getText();
                evaluateAnswer(answer);
            }
        });

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        add(startButton);
        add(questionScrollPane);
        add(answerField);
        add(submitButton);
        add(resultScrollPane);

        pack();
        setVisible(true);
    }

    private void startGame() {
        server = new QuizGameServer1();
        client1 = new QuizGameClient01(this);
        client2 = new QuizGameClient02(this);

        try {
            server.startGame();
            client1.startGame();
            client2.startGame();
        } catch (IOException e) {
            System.out.println("Error starting the game.");
            e.printStackTrace();
        }

        server.askQuestion();
    }

    private void evaluateAnswer(String answer) {
        client1.evaluateAnswer(new String[]{answer});
        client2.evaluateAnswer(new String[]{answer});
    }

    public void onQuestionAsked(String[] question) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StringBuilder questionText = new StringBuilder();
                for (String q : question) {
                    questionText.append(q).append("\n");
                }
                questionArea.setText(questionText.toString());
            }
        });
    }

    public void onAnswerEvaluated(boolean isCorrect) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (isCorrect) {
                    resultArea.setText("Yay!!");
                } else {
                    resultArea.setText("Nay :(");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizGameUI();
            }
        });
    }
}
