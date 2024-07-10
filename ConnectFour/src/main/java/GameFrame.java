import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    GameState gameState;
    JLabel currentPlayerLabel = new JLabel();
    JButton[] board;

    //For simplicity of this exercise,
    // 1 == RED and 2 == YELLOW, and red will always start
    int currentTurn = 1;


    public GameFrame(int gridSize, int winLength){

        //Intialise the state of the game
        gameState = new GameState(gridSize, winLength);
        board = gameState.initial_board();

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
            mainPanel.add(board[i]);
            board[i].addActionListener(this);
        }
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < gameState.getGridSize() * gameState.getGridSize(); i++) {
            if (e.getSource() == board[i]) {

                int column = i % gameState.getGridSize();
                //Loop through rows from bottom to top
                for (int row = gameState.getGridSize() - 1; row >= 0; row--) {

                    //Calculate the index in the 1D Array
                    int index = row * gameState.getGridSize() + column;

                    //If there is no text there then action the move
                    if (board[index].getText().isEmpty()) {
                        //RED turn
                        if (currentTurn == 1) {
                            board[index].setText("R");
                            currentPlayerLabel.setText("YELLOW PLAYER: PLACE YELLOW TOKEN");
                            GameFrame.this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
                            currentTurn = 2;
                        }
                        //YELLOW turn
                        else if (currentTurn == 2) {
                            board[index].setText("Y");
                            currentPlayerLabel.setText("RED PLAYER: PLACE RED TOKEN");
                            GameFrame.this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
                            currentTurn = 1;
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
