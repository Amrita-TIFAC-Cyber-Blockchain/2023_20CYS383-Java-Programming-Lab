import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeolocationToolGUI extends JFrame {
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JTextArea resultArea;

    public GeolocationToolGUI() {
        setTitle("Geolocation Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel for input and search button
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel latitudeLabel = new JLabel("Latitude:");
        JLabel longitudeLabel = new JLabel("Longitude:");
        latitudeField = new JTextField();
        longitudeField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performGeolocationSearch();
            }
        });

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(latitudeLabel);
        labelPanel.add(longitudeLabel);

        JPanel fieldPanel = new JPanel(new GridLayout(2, 1));
        fieldPanel.add(latitudeField);
        fieldPanel.add(longitudeField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchButton);

        inputPanel.add(labelPanel, BorderLayout.WEST);
        inputPanel.add(fieldPanel, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        // Text area for displaying results
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void performGeolocationSearch() {
        double latitude = Double.parseDouble(latitudeField.getText());
        double longitude = Double.parseDouble(longitudeField.getText());

        // Perform geolocation-based search and update resultArea with the output
        // Add your logic here to perform the geolocation search

        // Example: Manually specifying a location for testing purposes
        String city = "San Francisco";
        String country = "United States";

        resultArea.setText("Latitude: " + latitude + "\nLongitude: " + longitude + "\n\nSearch Results:\nCity: " + city + "\nCountry: " + country);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeolocationToolGUI gui = new GeolocationToolGUI();
                gui.setVisible(true);
            }
        });
    }
}
