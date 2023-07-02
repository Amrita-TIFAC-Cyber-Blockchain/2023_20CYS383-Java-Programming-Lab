import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeaderboardUI extends JFrame {
    private JTable leaderboardTable;

    public LeaderboardUI(Object[][] leaderboardData, String[] columnNames) {
        setTitle("Leaderboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Leaderboard table
        DefaultTableModel tableModel = new DefaultTableModel(leaderboardData, columnNames);
        leaderboardTable = new JTable(tableModel);
        leaderboardTable.setGridColor(Color.LIGHT_GRAY);

        // Center-align the content in the cells
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        leaderboardTable.setDefaultRenderer(Object.class, renderer);

        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Example data for the leaderboard
                Object[][] leaderboardData = {
                        {"1", "John", "10"},
                        {"2", "Emma", "8"},
                        {"3", "David", "7"},
                        {"4", "Sophia", "6"},
                        {"5", "James", "5"}
                };
                String[] columnNames = {"Rank", "Name", "Score"};

                new LeaderboardUI(leaderboardData, columnNames);
            }
        });
    }
}
