import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Display
        JTextField display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);

        // Panels for different sections
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        JPanel operationPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        JPanel extraOpPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JPanel sidePanel = new JPanel(new BorderLayout(5, 5));

        // Number buttons
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "00"};
        for (String num : numbers) {
            buttonPanel.add(createButton(num));
        }

        // Add . button separately to maintain layout
        buttonPanel.add(createButton("."));

        // Operation buttons
        String[] operations = {"+", "-", "*", "/", "="};
        for (String op : operations) {
            operationPanel.add(createButton(op));
        }

        // Extra buttons (C, C/A, OFF)
        extraOpPanel.add(createButton("C"));
        extraOpPanel.add(createButton("C/A"));
        extraOpPanel.add(createButton("OFF"));

        // Combine operation and extra operation panels
        sidePanel.add(operationPanel, BorderLayout.CENTER);
        sidePanel.add(extraOpPanel, BorderLayout.EAST);

        // Add panels to frame
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.add(buttonPanel, BorderLayout.WEST);
        centerPanel.add(operationPanel, BorderLayout.CENTER);
        centerPanel.add(extraOpPanel, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
    }
}