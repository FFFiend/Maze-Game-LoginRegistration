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
        inputBoundary.execute(keycode);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
