package default_game;

import adapters.default_game.GamePanelPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutputBoundary;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Test the MazeInteractor class
 */
public class MazeInteractorTest {
    /**
     * Test that the gameOver and playerKilled is true after Player collides with StationaryEnemy
     */
    @Test
    public void TestPlayerDeath() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.load("maze04.txt");
        mazeInteractor.startGameThread();
        mazeInteractor.execute(KeyEvent.VK_A);
        Assertions.assertTrue(mazeInteractor.isPlayerKilled());
        Assertions.assertTrue(mazeInteractor.gameOver());
    }

    /**
     * Test resetting the game after dying from collision with ChasingEnemy
     */
    @Test
    public void TestReset() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
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
    public void TestStaminaOut() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
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
    public void TestDisplayLevel() {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.displayLevel(KeyEvent.VK_1);
        Assertions.assertEquals(50, mazeInteractor.getPlayerStamina());
    }

    /**
     * Test the player position after key input W is passed as a parameter of
     * the execute method.
     *
     * @throws IOException
     */
    @Test
    public void TestExecuteWPlayerPos() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.load("maze01.txt");
        int initialX = mazeInteractor.getPlayerX();
        int initialY = mazeInteractor.getPlayerX();
        mazeInteractor.execute(KeyEvent.VK_W);
        Assertions.assertEquals(initialX, mazeInteractor.getPlayerX());
        Assertions.assertEquals(initialY - 1, mazeInteractor.getPlayerY());
    }

    /**
     * Test the player position after key input S is passed as a parameter of
     * the execute method.
     *
     * @throws IOException
     */
    @Test
    public void TestExecuteSPlayerPos() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.load("maze01.txt");
        int initialX = mazeInteractor.getPlayerX();
        int initialY = mazeInteractor.getPlayerX();
        mazeInteractor.execute(KeyEvent.VK_S);
        Assertions.assertEquals(initialX, mazeInteractor.getPlayerX());
        Assertions.assertEquals(initialY + 1, mazeInteractor.getPlayerY());
    }

    /**
     * Test the move function for keyboard input A.
     *
     * @throws IOException
     */
    @Test
    public void TestMovePlayerLeft() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.load("maze01.txt");
        int initialX = mazeInteractor.getPlayerX();
        int initialY = mazeInteractor.getPlayerX();
        mazeInteractor.movePlayer(KeyEvent.VK_A);
        Assertions.assertEquals(initialX - 1, mazeInteractor.getPlayerX());
        Assertions.assertEquals(initialY, mazeInteractor.getPlayerY());
    }

    /**
     * Test the move function for keyboard input D.
     *
     * @throws IOException
     */
    @Test
    public void TestMovePlayerRight() throws IOException {
        IGamePanelOutputBoundary outputBoundary = new TestGamePanelOutputBoundaryModel();
        IFileOutputBoundary updateScore = new TestFileOutputBoundary();
        MazeInteractor mazeInteractor = new MazeInteractor(outputBoundary, updateScore);
        mazeInteractor.load("maze01.txt");
        int initialX = mazeInteractor.getPlayerX();
        int initialY = mazeInteractor.getPlayerX();
        mazeInteractor.movePlayer(KeyEvent.VK_D);
        Assertions.assertEquals(initialX + 1, mazeInteractor.getPlayerX());
        Assertions.assertEquals(initialY, mazeInteractor.getPlayerY());
    }
}
