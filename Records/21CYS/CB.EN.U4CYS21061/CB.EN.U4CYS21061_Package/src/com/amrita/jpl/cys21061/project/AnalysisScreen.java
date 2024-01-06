package com.amrita.jpl.cys21061.project;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

public class AnalysisScreen extends JFrame {
    private UniCyMeGUI parentGUI;
    private JLabel analyzingLabel;

    public AnalysisScreen(UniCyMeGUI parentGUI) {
        this.parentGUI = parentGUI;
        setTitle("Analyzing...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        analyzingLabel = new JLabel("Analyzing file...");
        analyzingLabel.setHorizontalAlignment(JLabel.CENTER);
        analyzingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(analyzingLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void startAnalysis() {
        // Simulate analysis delay of 5 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                showAnalysisResult();
                timer.cancel();
            }
        }, 5000);
    }

    private void showAnalysisResult() {
        String analysisResult = "Damaged";
        String severity = "Medium";
        parentGUI.showAnalysisResult(analysisResult, severity);
        analyzingLabel.setText("Analysis Result: " + analysisResult);

        JPanel resultPanel = new JPanel(new GridLayout(3, 1));
        resultPanel.add(analyzingLabel);

        // Add a gradient indicator based on severity
        JPanel indicatorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (severity.equals("Low")) {
                    g.setColor(Color.GREEN);
                } else if (severity.equals("Medium")) {
                    Graphics2D g2d = (Graphics2D) g;
                    GradientPaint gradient = new GradientPaint(
                            0, 0, Color.ORANGE,
                            getWidth(), 0, Color.YELLOW
                    );
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else if (severity.equals("High")) {
                    g.setColor(Color.RED);
                }

                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        resultPanel.add(indicatorPanel);

        JLabel severityLabel = new JLabel("Severity: " + severity);
        resultPanel.add(severityLabel);

        getContentPane().removeAll();
        add(resultPanel);
        revalidate();
    }
}
