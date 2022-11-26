package use_cases.default_game;

import entities.default_game.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Update the Player's data. Use case interactor.
 */
public class UpdatePlayer extends JPanel implements IGamePanelInputBoundary, Runnable {

    public Thread gameThread;
    private final Player player;
    private final int playerSpeed = 1;
    private final IGamePanelOutputBoundary outputBoundary;
    private final int FPS = 20; // updates the screen 20 times per
    // second

    /**
     * Constructor for this class.
     *
     * @param player         theplayer that user controls
     * @param outputBoundary the output boundary for the game panel
     */
    public UpdatePlayer(Player player, IGamePanelOutputBoundary outputBoundary) {
        this.player = player;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input
     */
    public void movePlayer(int keycode) {
        if (keycode == KeyEvent.VK_W) {
            player.movePlayerY(-playerSpeed);
        }
        if (keycode == KeyEvent.VK_S) {
            player.movePlayerY(playerSpeed);
        }
        if (keycode == KeyEvent.VK_D) {
            player.movePlayerX(playerSpeed);
        }
        if (keycode == KeyEvent.VK_A) {
            player.movePlayerX(-playerSpeed);
        }
    }

    /**
     * Construct a new game thread and runs it.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // this calls run()
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (gameThread != null) {
            long currentTime = System.currentTimeMillis();
            long sleepTime = lastTime + 1000 / FPS - currentTime;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lastTime = currentTime;
            update();
        }
    }

    /**
     * Passes the updated player positions to the output boundary.
     */
    public void update() {
        // may change this later so that the updating of player position
        // is fully taken care of within the class instead of
        // accessing the entity layer
        outputBoundary.updateMaze(player.getPlayerX(), player.getPlayerY());
    }
}
