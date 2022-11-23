package adapters.default_game;

import use_cases.default_game.CollisionHandler;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User controller for the game.
 */
public class GamePanelController implements KeyListener {
    private final CollisionHandler iHandler;

    public GamePanelController(MazeHazards hazards, MazeItems items) {
        this.iHandler = new CollisionHandler(hazards, items);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            this.iHandler.upPressed();
        }
        if (code == KeyEvent.VK_S) {
            this.iHandler.downPressed();
        }
        if (code == KeyEvent.VK_D) {
            this.iHandler.rightPressed();
        }
        if (code == KeyEvent.VK_A) {
            this.iHandler.leftPressed();
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
