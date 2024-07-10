import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    JLabel currentPlayerLabel = new JLabel();


    public GameFrame(int gridSize, int winLength){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Connect Four");
        this.getContentPane().setLayout(new BorderLayout());

        //Indication of whose turn it currently is
        currentPlayerLabel.setText("Red Player - Click a column to place a red token");
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        this.getContentPane().add(currentPlayerLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout(gridSize,gridSize) );
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        //The 'board' is implemented using JButtons
        for ( int i = 0 ; i < gridSize*gridSize ; i++ )
        {
            mainPanel.add(new JButton());

        }
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}
