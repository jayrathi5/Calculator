import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calimp extends JFrame {
    calimp() {
        super("Calculator");
        setSize(400, 400);
        setResizable(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Input display
        JTextArea display = new JTextArea();
        display.setBounds(30, 30, 340, 50); // Adjusted for better visibility
        display.setFont(new Font("Dialog", Font.PLAIN, 32));
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        display.setEditable(false);
        add(display);

        // Answer display (for output)
        JTextArea answerDisplay = new JTextArea();
        answerDisplay.setBounds(30, 90, 340, 40); // Slightly smaller for output
        answerDisplay.setFont(new Font("Dialog", Font.PLAIN, 24));
        answerDisplay.setEditable(false);
        answerDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(answerDisplay);

        // Clear button positioned above all number and operation buttons
        JButton clear = new JButton("C");
        clear.setBounds(30, 140, 340, 50); // Positioned above buttons and spans the full width
        clear.setFont(new Font("Dialog", Font.BOLD, 24));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                answerDisplay.setText("");
            }
        });
        add(clear);

        // Button Labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "x",
            "1", "2", "3", "-",
            "0", ".", "+", "="
        };

        JButton[] button = new JButton[buttonLabels.length]; // Create an array to store buttons

        // Add buttons below the "Clear" button
        for (int i = 0; i < buttonLabels.length; i++) {
            button[i] = new JButton(buttonLabels[i]);
            final JButton btn = button[i];

            // Calculate positions dynamically
            int x = 30 + (i % 4) * 80;
            int y = 200 + (i / 4) * 80; // Start below the "Clear" button

            button[i].setBounds(x, y, 70, 50);
            button[i].setFont(new Font("Dialog", Font.BOLD, 24));

            button[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Get the text of the button pressed
                    String buttonText = btn.getText();

                    // Append the button text to the display if it's not '='
                    if (!buttonText.equals("=")) {
                        display.append(buttonText);
                    } else {
                        // When "=" is pressed, perform the calculation
                        String expression = display.getText();
                        double result = callogic.convert(expression);  // Calling the convert method from callogic class
                        answerDisplay.setText(String.valueOf(result));  // Display the result
                        display.setText("");  // Optionally, clear the input display after calculation
                    }
                }
            });

            add(button[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new calimp().setVisible(true);
        });
    }
}
