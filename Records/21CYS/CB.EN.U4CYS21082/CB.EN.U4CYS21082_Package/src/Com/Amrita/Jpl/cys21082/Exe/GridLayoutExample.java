package Com.Amrita.Jpl.cys21082.Exe;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    public GridLayoutExample() {
        setTitle("GridLayout Example");
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Create a JPanel to hold the components
        JPanel panel = new JPanel(new GridLayout(2, 2));

        // Create and add components to the panel
        panel.add(new JLabel("Name", JLabel.CENTER));
        panel.add(new JTextArea("UMASHANKAR KAVYA"));
        panel.add(new JLabel("Email", JLabel.CENTER));
        panel.add(new JTextArea("KAVYA@jbl.in"));

        // Add the panel to the content pane
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
