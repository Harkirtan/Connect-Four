import javax.swing.*;

public class StartFrame extends JFrame {

    private int chosenGridSize;
    private int chosenWinRowLength;

    public StartFrame() {
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
            if(checkValidityOfSettings(gridSizeInput.getText(), winningLengthInput.getText())){
                //Once settings have been validated, then launch the game frame and close this settings screen
                new GameFrame(chosenGridSize, chosenWinRowLength);
                StartFrame.this.dispose();
            }
        });

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private Boolean checkValidityOfSettings(String gridSizeText, String rowLengthText){
        //Check if user typed in a number or string and inform accordingly
        try {
            chosenGridSize = Integer.parseInt(gridSizeText);
            chosenWinRowLength = Integer.parseInt(rowLengthText);
        } catch (NumberFormatException e) {
            System.out.println("Error: Both inputs must be valid integers");
            return false;
        }

        //To make the game plausible, remove case where the winning length is greater than grid size
        if(chosenWinRowLength > chosenGridSize){
            System.out.println("Error: Winning row length greater than size of grid");
            return false;
        } else {
            System.out.println("Selected Grid Size: " + chosenGridSize + " Winning Row Length: " + chosenWinRowLength);
            return true;
        }
    }

    //Main function
    public static void main(String[] args)
    {
        new StartFrame();
    }
}
