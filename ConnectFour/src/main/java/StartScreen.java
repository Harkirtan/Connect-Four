import javax.swing.*;

public class StartScreen  extends JFrame {

    private int gridSize;
    private int winRowLength;

    public StartScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Settings");

        //Panel for elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.getContentPane().add(panel);

        //Label for the grid size
        JLabel gridSizeLabel = new JLabel("What grid size would you like to play?");
        panel.add(gridSizeLabel);

        //Text field to get user input
        JTextField gridSizeInput = new JTextField("5", 2);
        panel.add(gridSizeInput);

        //Label for the winning row length
        JLabel winningLengthLabel = new JLabel("What winning row length would you like?");
        panel.add(winningLengthLabel);

        //Text field to get winning row length
        JTextField winningLengthInput = new JTextField("4", 2);
        panel.add(winningLengthInput);

        //Button to confirm settings
        JButton confirmSettingsButton = new JButton("Confirm settings");
        panel.add(confirmSettingsButton);
        confirmSettingsButton.addActionListener(e -> {

        });

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //Run this JFrame
    public static void main(String[] args)
    {
        new StartScreen();
    }
}
