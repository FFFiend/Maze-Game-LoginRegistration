package default_game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;

import java.awt.event.KeyEvent;

/**
 * Test the MazeInteractor class
 */
public class MazeInteractorTest {
    /**
     * Test that the gameOver is true after Player collides with StationaryEnemy
     */
    @Test
    public void TestDeath() {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary);
        mazeInteractor.load("maze04.txt");
        mazeInteractor.startGameThread();
        mazeInteractor.execute(KeyEvent.VK_A);
        Assertions.assertTrue(mazeInteractor.gameOver());
    }

    /**
     * Test resetting the game after dying from collision with ChasingEnemy
     */
    @Test
    public void TestReset() {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary);
        mazeInteractor.load("maze04.txt");
        mazeInteractor.startGameThread();
        mazeInteractor.execute(KeyEvent.VK_S);
        Assertions.assertTrue(mazeInteractor.gameOver());
        mazeInteractor.execute(KeyEvent.VK_R);
        Assertions.assertFalse(mazeInteractor.gameOver());
    }

    /**
     * Test that gameOver is true when Player is out of Stamina
     */
    @Test
    public void TestStaminaOut() {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary);
        mazeInteractor.load("maze04.txt");
        mazeInteractor.startGameThread();
        mazeInteractor.execute(KeyEvent.VK_D);
        int i = 0;
        while (i < 24) {
            mazeInteractor.execute(KeyEvent.VK_S);
            mazeInteractor.execute(KeyEvent.VK_W);
            i++;
        }
        Assertions.assertFalse(mazeInteractor.gameOver());

        // take the last step
        mazeInteractor.execute(KeyEvent.VK_S);
        Assertions.assertTrue(mazeInteractor.gameOver());
    }

    /**
     * Test that displayLevel loads the maze
     */
    @Test
    public void DisplayLevel() {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary);
        mazeInteractor.displayLevel(KeyEvent.VK_1);
        Assertions.assertEquals(50, mazeInteractor.getPlayerStamina());
    }
}
