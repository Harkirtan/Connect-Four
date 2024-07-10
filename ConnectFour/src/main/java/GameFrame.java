import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private GameState gameState;
    private JLabel currentPlayerLabel = new JLabel();

    //For simplicity of this exercise,
    // 1 == RED and 2 == YELLOW, and red will always start
    private int currentTurn = 1;


    public GameFrame(int gridSize, int winLength){

        //Initialise the state of the game
        gameState = new GameState(gridSize, winLength);
        gameState.initialiseBoard();

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
        //The 'board' is implemented using JButtons with action listeners
        for ( int i = 0 ; i < gridSize*gridSize ; i++ )
        {
            mainPanel.add(gameState.getBoard()[i]);
            gameState.getBoard()[i].addActionListener(this);
        }
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < gameState.getGridSize() * gameState.getGridSize(); i++) {
            //If one of the JButtons is pressed find which one
            if (e.getSource() == gameState.getBoard()[i]) {

                int column = i % gameState.getGridSize();
                //Loop through rows from bottom to top
                for (int row = gameState.getGridSize() - 1; row >= 0; row--) {

                    //Calculate the index in the 1D Array
                    int index = row * gameState.getGridSize() + column;

                    //If there is no text there then action the move
                    if (gameState.getBoard()[index].getText().isEmpty()) {
                        //RED turn
                        if (currentTurn == 1) {
                            gameState.getBoard()[index].setText("R");
                            currentPlayerLabel.setText("YELLOW PLAYER: PLACE YELLOW TOKEN");
                            GameFrame.this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
                            currentTurn = 2;
                        }
                        //YELLOW turn
                        else if (currentTurn == 2) {
                            gameState.getBoard()[index].setText("Y");
                            currentPlayerLabel.setText("RED PLAYER: PLACE RED TOKEN");
                            GameFrame.this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
                            currentTurn = 1;
                        }
                        //Check if a player has won after each move
                        if (gameState.checkForWin()) {
                            String winner = currentTurn == 2 ? "Red" : "Yellow";
                            JOptionPane.showMessageDialog(this, winner + " Player Wins!");
                            System.out.println(winner + " Player Wins!");
                            //Close game
                            GameFrame.this.dispose();
                        }
                        //exit the loop once the token is placed
                        break;
                    }
                }
                //exit the outer loop once the source button is found
                break;
            }
        }
    }
}
