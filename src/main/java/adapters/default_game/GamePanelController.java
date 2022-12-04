package adapters.default_game;

import use_cases.default_game.IGamePanelInputBoundary;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User controller for the game.
 */
public class GamePanelController implements KeyListener {
    private final IGamePanelInputBoundary inputBoundary;
    private boolean levelSelected = false;

    /**
     * Number of times per second the inputBoundary update method is called.
     */
    private final int updateFrequency = 4;

    public GamePanelController(IGamePanelInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
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
        int keycode = e.getKeyCode();
        if (!levelSelected) {
            if (keycode == KeyEvent.VK_1 || keycode == KeyEvent.VK_2 ||
                    keycode == KeyEvent.VK_3) {
                inputBoundary.displayLevel(keycode);
                levelSelected = true;
            }
        } else if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_S ||
                keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_A) {
            inputBoundary.movePlayer(keycode);
        } else if (keycode == KeyEvent.VK_R) {
            inputBoundary.reset();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
