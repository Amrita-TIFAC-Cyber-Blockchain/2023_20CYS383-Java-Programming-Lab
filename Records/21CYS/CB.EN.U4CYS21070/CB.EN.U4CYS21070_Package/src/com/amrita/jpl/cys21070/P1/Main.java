import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class Main extends JFrame {
    private JTextArea text;

    public Main() {
        setTitle("Java Swing Simple Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,350);
        setLayout(new BorderLayout());


        JButton save = new JButton("Save File");
        JButton load = new JButton("Load File");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });

        text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text);
        add(scroll, BorderLayout.CENTER);

        JPanel button = new JPanel();
        button.add(save);
        button.add(load);
        add(button, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void save() {
        String file = JOptionPane.showInputDialog(this, "Enter file name:");
        if (file == null || file.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid file name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String path = file;
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.print(text.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void load() {
        String file = JOptionPane.showInputDialog(this, "Enter file name:");
        if (file == null || file.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid file name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String path = file;
        File file1 = new File(path);
        if (!file1.exists()) {
            JOptionPane.showMessageDialog(this, "File does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            text.setText(content.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
