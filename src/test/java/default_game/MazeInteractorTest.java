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
}
