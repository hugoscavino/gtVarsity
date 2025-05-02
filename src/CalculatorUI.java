import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    private final JTextField display = new JTextField("");

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Display

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

        if (text.equals("=")) {
            button.addActionListener(e -> {
                String currentText = display.getText().trim();
                double result = evaluateExpression(currentText);
                display.setText(Double.toString(result));
            });

        } else if (text.equalsIgnoreCase("C/A")){
            button.addActionListener(e -> {
                display.setText("");
            });
        } else if (text.equalsIgnoreCase("C")){
            button.addActionListener(e -> {
                String currentText = display.getText().trim();
                currentText = currentText.substring(0, currentText.length() - 1);
                display.setText(currentText);
            });
        } else if (text.equalsIgnoreCase("OFF")){
            button.addActionListener(e -> {
                this.dispose();
            });
        } else {
            button.addActionListener(e -> {
                String currentText = display.getText().trim();
                String operation = button.getText().trim();
                currentText = currentText + operation;
                display.setText(currentText);

            });
        }
        return button;
    }

    public static double evaluateExpression(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Input expression is null");
        }
        // Remove any surrounding whitespaces
        expression = expression.trim();
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Input expression is empty");
        }

        double result = 0.0;
        double lastValue = 0.0;        // will hold the last processed term (for * and /)
        double currentNumber = 0.0;    // current number being built from consecutive digits
        char operation = '+';          // initialize operation to '+' for the first number
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) {
                continue;  // skip spaces, if any
            }

            // If current char is part of a number (digit or decimal point), append to buffer
            if (Character.isDigit(ch) || ch == '.') {
                numberBuffer.append(ch);
                continue;
            }

            // If we encounter an operator ( +, -, *, / ):
            // First, if there's a number buffered, convert it to double
            if (!numberBuffer.isEmpty()) {
                currentNumber = Double.parseDouble(numberBuffer.toString());
                numberBuffer.setLength(0);  // reset the buffer for the next number
            }

            // Handle a unary minus sign (negative number) scenario:
            // If the current operator is '-' and it's at the start or right after another operator,
            // treat it as part of the number (e.g., expression "-5+3" or "4 * -2").
            if (ch == '-' && (i == 0 || "+-*/".indexOf(expression.charAt(i-1)) != -1)) {
                numberBuffer.append(ch);
                continue;
            }

            // Apply the previous operation stored in 'operation' with the currentNumber
            switch (operation) {
                case '+':
                    // finalize the previous term by adding lastValue to result
                    result += lastValue;
                    // current number becomes the new lastValue (for next term)
                    lastValue = currentNumber;
                    break;
                case '-':
                    result += lastValue;
                    lastValue = -currentNumber;
                    break;
                case '*':
                    // multiply the lastValue by current number (high precedence)
                    lastValue = lastValue * currentNumber;
                    break;
                case '/':
                    lastValue = lastValue / currentNumber;
                    break;
            }

            // Update operation to the current operator and reset currentNumber
            operation = ch;
            currentNumber = 0.0;
        }

        // If any number remains in the buffer after the loop, parse and use it
        if (!numberBuffer.isEmpty()) {
            currentNumber = Double.parseDouble(numberBuffer.toString());
            // Apply the last pending operation with this number
            switch (operation) {
                case '+':
                    result += lastValue;
                    lastValue = currentNumber;
                    break;
                case '-':
                    result += lastValue;
                    lastValue = -currentNumber;
                    break;
                case '*':
                    lastValue = lastValue * currentNumber;
                    break;
                case '/':
                    lastValue = lastValue / currentNumber;
                    break;
            }
        }

        // Add the lastValue of the final term to the result
        result += lastValue;
        return result;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
    }
}