import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTrackerUI extends JFrame {
    private JLabel timerLabel;
    private JButton startButton;
    private JButton stopButton;
    private JComboBox<String> categoryComboBox;

    public TimeTrackerUI() {
        setTitle("Time Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Timer label
        timerLabel = new JLabel("00:00:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timerLabel);

        // Start button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        add(startButton);

        // Stop button
        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });
        add(stopButton);

        // Category selection
        String[] categories = {"Work", "Study", "Exercise", "Break"};
        categoryComboBox = new JComboBox<>(categories);
        add(categoryComboBox);

        pack();
        setVisible(true);
    }

    private void startTimer() {
        // TODO: Implement timer logic
    }

    private void stopTimer() {
        // TODO: Implement timer stop logic
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimeTrackerUI();
            }
        });
    }
}
