import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieManagerString extends JFrame {
    private final JTextField nameField;
    private final JTextField mediaField;
    private final JTextField yearField;
    private final JTextArea movieListArea;
    private final ArrayList<String> movieList;

    public MovieManagerString() {
        super("Movie Manager");
        movieList = new ArrayList<>();

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Movie"));
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Movie Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Media:"));
        mediaField = new JTextField();
        inputPanel.add(mediaField);

        inputPanel.add(new JLabel("Release Year:"));
        yearField = new JTextField();
        inputPanel.add(yearField);

        JButton addButton = new JButton("Add Movie");
        inputPanel.add(addButton);

        // Placeholder for layout
        inputPanel.add(new JLabel(""));

        // Movies display
        JPanel moviePanel = new JPanel(new BorderLayout());
        moviePanel.setBorder(BorderFactory.createTitledBorder("Movies:"));
        movieListArea = new JTextArea(10, 30);
        movieListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(movieListArea);
        moviePanel.add(scrollPane, BorderLayout.CENTER);

        JButton showButton = new JButton("Show Movies");
        moviePanel.add(showButton, BorderLayout.SOUTH);

        // Main Layout
        setLayout(new FlowLayout());
        add(inputPanel);
        add(moviePanel);

        // Button Actions
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String media = mediaField.getText().trim();
            String year = yearField.getText().trim();
            if (!name.isEmpty() && !media.isEmpty() && !year.isEmpty()) {
                movieList.add(year + "    " + media + "    " + name);
                nameField.setText("");
                mediaField.setText("");
                yearField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
            }
        });

        showButton.addActionListener(e -> {
            movieListArea.setText("Year    Media    Title\n");
            for (String movie : movieList) {
                movieListArea.append(movie + "\n");
            }
        });

        // Frame Settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovieManager::new);
    }
}
