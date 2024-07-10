import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameState {

    private int gridSize;
    private int winRowLength;

    int[][] state;
    JButton[] board;

    //Initialise the integer array and JButton array with correct number of spaces
    public GameState(int gridSizeI, int winLength) {
        gridSize = gridSizeI;
        winRowLength = winLength;
        state = new int[gridSize][gridSize];
        board = new JButton[gridSize * gridSize];
    }

    //Create and return a board with initial values / dimensions
    public JButton[] initial_board() {
        for (int i = 0; i < gridSize * gridSize; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(50, 50));
            board[i] = button;
        }
        return board;
    }

    //Getter for grid size
    public int getGridSize() {
        return gridSize;
    }

    //Getter for grid state
    public int[][] getState() {
        return state;
    }
}
