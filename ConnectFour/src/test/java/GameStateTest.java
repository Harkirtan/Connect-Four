import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private final GameState gameState= new GameState(5, 4);

    //Test if the state array is being created correctly
    @Test
    public void testInitialState() {
        int[][] state = gameState.getState();
        assertNotNull(state);
        assertEquals(5, state.length);
        assertEquals(5, state[0].length);

    }

    //Test if adding tokens will update the array correctly
    @Test
    public void testUpdateState() {
        gameState.initialiseBoard();

        gameState.getBoard()[0].setText("R");
        gameState.getBoard()[1].setText("Y");

        int[][] expectedState = {
                {1, 2, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        gameState.updateState();
        assertArrayEquals(expectedState, gameState.getState());
    }

    //Test if win check returns false
    @Test
    public void testWinConditionFalse() {
        gameState.initialiseBoard();

        gameState.getBoard()[0].setText("R");
        gameState.getBoard()[1].setText("Y");

        assertFalse(gameState.checkForWin());
    }

    //Check if win check returns true
    @Test
    public void testWinConditionTrue() {
        gameState.initialiseBoard();

        gameState.getBoard()[0].setText("R");
        gameState.getBoard()[6].setText("R");
        gameState.getBoard()[12].setText("R");
        gameState.getBoard()[18].setText("R");

        assertTrue(gameState.checkForWin());
    }
}