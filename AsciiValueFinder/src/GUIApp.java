import javax.swing.*;
import java.awt.event.*;

public class GUIApp extends JFrame {
    private JTextField inputField;
    private JButton showButton;
    private JLabel resultLabel;

    public GUIApp() {
        setTitle("ASCII Value Finder");
        setSize(300, 150);
        setLayout(null);

        JLabel promptLabel = new JLabel("Enter a character:");
        promptLabel.setBounds(10, 10, 120, 25);
        add(promptLabel);

        inputField = new JTextField();
        inputField.setBounds(140, 10, 50, 25);
        add(inputField);

        showButton = new JButton("Show ASCII");
        showButton.setBounds(80, 50, 120, 25);
        add(showButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 85, 280, 25);
        add(resultLabel);

        showButton.addActionListener(e -> {
            String input = inputField.getText();
            if (input.length() != 1) {
                resultLabel.setText("Please enter exactly one character.");
            } else {
                char c = input.charAt(0);
                int ascii = AsciiFinder.getAsciiValue(c);
                resultLabel.setText("ASCII value of '" + c + "': " + ascii);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}