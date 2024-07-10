import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameState {

    private int gridSize;
    private int winRowLength;

    private int[][] state;
    private JButton[] board;

    //Initialise the integer array and JButton array with correct number of spaces
    public GameState(int gridSizeI, int winLength){
        gridSize = gridSizeI;
        winRowLength = winLength;
        state = new int[gridSize][gridSize];
        board = new JButton[gridSize*gridSize];
    }

    //Create a board with initial values / dimensions
    public void initialiseBoard()
    {
        for ( int i = 0 ; i < gridSize*gridSize ; i++ )
        {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(50, 50));
            board[i] = button;
        }
    }

    //Update integer array according to the JButton array
    public void updateState()
    {
        int counter = 0;
        for ( int i = 0; i < gridSize ; i++ )
        {
            for ( int j = 0 ; j < gridSize ; j++ )
            {
                if(Objects.equals(board[counter].getText(), "R")){
                    state[i][j] = 1;
                }
                else if(Objects.equals(board[counter].getText(), "Y")){
                    state[i][j] = 2;
                }
                else{
                    state[i][j] = 0;
                }
                counter++;
            }
        }

    }


    public boolean checkForWin() {
        //Updates the state[][] array
        updateState();

        //Check horizontal and vertical
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (checkConsecutive(row, col, 1, 0) || //horizontal
                        checkConsecutive(row, col, 0, 1) || //vertical
                        checkConsecutive(row, col, 1, 1) || //diagonal \
                        checkConsecutive(row, col, 1, -1)) { //diagonal /
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkConsecutive(int startRow, int startCol, int rowDirection, int colDirection) {
        //Get the player's token at the starting position
        int player = state[startRow][startCol];
        //If the starting position is empty (player = 0), return false
        if (player == 0) {
            return false;
        }
        //Calculate the end position based on direction and winRowLength
        int endRow = startRow + (winRowLength - 1) * rowDirection;
        int endCol = startCol + (winRowLength - 1) * colDirection;

        //Check if the end position is out of bounds
        if (endRow < 0 || endRow >= gridSize || endCol < 0 || endCol >= gridSize) {
            return false;
        }
        //Iterate over the positions between start and end to check for consecutive tokens
        for (int k = 1; k < winRowLength; k++) {
            int currentRow = startRow + k * rowDirection;
            int currentCol = startCol + k * colDirection;
            //If any token in the sequence is not the same as the player's token, return false
            if (state[currentRow][currentCol] != player) {
                return false;
            }
        }

        return true;
    }

    //Getter for grid size
    public int getGridSize() {
        return gridSize;
    }

    //Getter for grid state
    public int[][] getState() {
        return state;
    }

    //Getter for JButton board
    public JButton[] getBoard() {
        return board;
    }
}