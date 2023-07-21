# 20CYS383 Java Programming Lab
![](https://img.shields.io/badge/Batch-21CYS-lightgreen) ![](https://img.shields.io/badge/UG-blue) ![](https://img.shields.io/badge/Subject-JPL-blue)

## Ship Detection 

### Project Description


### Module Split-up

| Name | Topic |
|------|-------|

### Code

#### Main-Activity in Java
```
package com.amrita.jpl.cys21090.pract;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class di {
    private static JLabel inputImage;
    private static JLabel outputImage;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JAVA_UI_APPLICATION_MULTI_MEDIA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Creating the topic label
        JLabel topicLabel = new JLabel("SHIP DETECTION USING ARIAL IMAGES ");
        topicLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topicLabel.setHorizontalAlignment(JLabel.CENTER);
        topicLabel.setBounds(100, 50, 600, 50);
        topicLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(topicLabel);

        // Creating the input image column
        JLabel inputLabel = new JLabel("INPUT  IMAGE");
        inputLabel.setBounds(100, 250, 100, 25);
        inputLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(inputLabel);

        // Creating the output image column
        JLabel outputLabel = new JLabel("OUTPUT IMAGE");
        outputLabel.setBounds(500, 250, 100, 25);
        outputLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(outputLabel);

        // Creating the input image label
        inputImage = new JLabel();
        inputImage.setBounds(100, 290, 200, 150);
        inputImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(inputImage);

        // Creating the output image label
        outputImage = new JLabel();
        outputImage.setBounds(500, 290, 200, 150);
        outputImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(outputImage);

        // Creating the footer label
        JLabel footerLabel = new JLabel("Credits: @monish @sudeepv @yuvarajkumar");
        footerLabel.setHorizontalAlignment(JLabel.CENTER);
        footerLabel.setBounds(0, 500, 900, 25);
        footerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(footerLabel);

        // Creating the file chooser button
        JButton fileChooserButton = new JButton("Upload Image");
        fileChooserButton.setBounds(350, 400, 100, 25);
        frame.add(fileChooserButton);

        // File chooser action listener
        fileChooserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    inputImage.setIcon(imageIcon);
                    outputImage.setIcon(imageIcon);
                }
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
```

#### Screenshots
