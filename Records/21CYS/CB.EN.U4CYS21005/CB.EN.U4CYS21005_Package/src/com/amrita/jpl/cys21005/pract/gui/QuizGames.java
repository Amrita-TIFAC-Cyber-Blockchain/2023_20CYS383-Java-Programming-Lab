package com.amrita.jpl.cys21005.pract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alagu Soundarya G
 * @version 1.0
 * Quiz Games Program did for practice
 */

public class QuizGames extends JFrame implements ActionListener {
    private JPanel questionPanel;
    private JPanel answerPanel;
    private JButton submitButton;
    private JLabel resultLabel;

    public QuizGames() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionPanel = new JPanel(new GridLayout(3, 1));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        questionPanel.add(new JLabel("1. What is the capital of India?"));
        questionPanel.add(new JLabel("2. Who is the Prime Minister of India'?"));
        questionPanel.add(new JLabel("3. Who is the chairperson of G20?"));

        answerPanel = new JPanel(new GridLayout(3, 1));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        answerPanel.add(new JTextField());
        answerPanel.add(new JTextField());
        answerPanel.add(new JTextField());

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        resultLabel = new JLabel();

        add(questionPanel, BorderLayout.WEST);
        add(answerPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String[] answers = {
                    "Delhi",
                    "Narendra Modi",
                    "Shri Mata Amritanandamayi Devi"
            };

            JTextField[] textFields = {
                    (JTextField) answerPanel.getComponent(0),
                    (JTextField) answerPanel.getComponent(1),
                    (JTextField) answerPanel.getComponent(2)
            };

            int correctAnswers = 0;

            for (int i = 0; i < answers.length; i++) {
                if (textFields[i].getText().equalsIgnoreCase(answers[i])) {
                    correctAnswers++;
                }
            }

            resultLabel.setText("Correct answers: " + correctAnswers);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizGames();
            }
        });
    }
}