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
    private final IGamePanelOutputBoundary outputBoundary;
    final int SPRITE_TILE_SIZE = 16;
    final int SCALE = 3; // may be changed to an unfixed variable later
    final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    private final int FPS = 20; // updates the screen 5 times per second

    /**
     * Constructor for this class.
     *
     * @param player         the player that user controls
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
            player.movePlayerY(-TILE_SIZE);
        }
        if (keycode == KeyEvent.VK_S) {
            player.movePlayerY(TILE_SIZE);
        }
        if (keycode == KeyEvent.VK_D) {
            player.movePlayerX(TILE_SIZE);
        }
        if (keycode == KeyEvent.VK_A) {
            player.movePlayerX(-TILE_SIZE);
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
        // credit to Seamus
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (gameThread != null) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                delta--;
            }
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
