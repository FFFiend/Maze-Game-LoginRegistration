package adapters.default_game;

import use_cases.default_game.IGamePanelInputBoundary;
import use_cases.default_game.MazeInteractor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User controller for the game.
 */
public class GamePanelController implements KeyListener, Runnable {
    private final IGamePanelInputBoundary inputBoundary;

    /**
     * Number of times per second the inputBoundary update method is called.
     */
    private final int updateFrequency = 4;
    private Thread updateThread;

    public GamePanelController(IGamePanelInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
        updateThread = new Thread(this);
        updateThread.start();
    }

    /**
     * Stop updating the game.
     */
    public void stopGame() {
        updateThread = null;
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
        if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_S ||
                keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_A) {
            inputBoundary.movePlayer(keycode);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (updateThread != null) {
            long currentTime = System.currentTimeMillis();
            long sleepTime = lastTime + 1000 / updateFrequency - currentTime;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lastTime = System.currentTimeMillis();

            inputBoundary.update();
        }
    }
}
