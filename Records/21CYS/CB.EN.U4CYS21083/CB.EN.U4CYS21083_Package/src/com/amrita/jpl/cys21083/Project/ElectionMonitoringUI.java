import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ElectionMonitoringUI extends JFrame {
    private JLabel titleLabel;
    private JTextArea monitoringTextArea;
    private JButton refreshButton;

    private Map<String, Integer> candidateVotes;

    public ElectionMonitoringUI() {
        setTitle("Election Monitoring");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Real-time Voting Results:");
        topPanel.add(titleLabel, BorderLayout.NORTH);

        monitoringTextArea = new JTextArea(10, 30);
        monitoringTextArea.setEditable(false);
        JScrollPane monitoringScrollPane = new JScrollPane(monitoringTextArea);
        topPanel.add(monitoringScrollPane, BorderLayout.CENTER);

        refreshButton = new JButton("Refresh");
        topPanel.add(refreshButton, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        candidateVotes = new HashMap<>();

        // ActionListener for Refresh Button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMonitoringResults();
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private void updateMonitoringResults() {
        StringBuilder results = new StringBuilder();

        // Iterate through the candidate votes and display the results
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            String candidate = entry.getKey();
            int voteCount = entry.getValue();
            results.append(candidate).append(": ").append(voteCount).append(" votes").append("\n");
        }

        monitoringTextArea.setText(results.toString());
    }

    public void updateVoteCount(String candidate) {
        // Increment the vote count for the specified candidate
        int voteCount = candidateVotes.getOrDefault(candidate, 0);
        candidateVotes.put(candidate, voteCount + 1);

        // Update the monitoring results
        updateMonitoringResults();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ElectionMonitoringUI monitoringUI = new ElectionMonitoringUI();
                // Simulate vote counts for testing
                monitoringUI.updateVoteCount("Candidate 1");
                monitoringUI.updateVoteCount("Candidate 2");
                monitoringUI.updateVoteCount("Candidate 1");
                monitoringUI.updateVoteCount("Candidate 1");
            }
        });
    }
}
