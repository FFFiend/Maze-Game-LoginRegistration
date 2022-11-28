package use_cases.default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.Maze;
import entities.default_game.Player;
import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Use case interactor for mazes.
 *
 * All the methods in this class use the "synchronized" keyword. This prevents
 * java.util.ConcurrentModificationException, because we are accessing this class in separate threads.
 * */
public class MazeInteractor implements IGamePanelInputBoundary, IHazardRequestModel {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final CollisionHandler cHandler;
    private final Player player;
    private final int playerSpeed = 1;
    private final Maze mazeInfo;

    private boolean playerKilled;
    /** The file name of the maze which is currently loaded. */
    private String currentMaze;



    public MazeInteractor() {
        hazards = new MazeHazards();
        items = new MazeItems();
        this.player = new Player(1, 1);
        cHandler = new CollisionHandler(items, hazards, player);
        mazeInfo = new Maze();
        playerKilled = false;
    }

    /** Load a maze from a file. */
    public synchronized void load(String filename) {
        currentMaze = filename;
        new CustomAssetSetter(currentMaze, items, hazards);
    }

    @Override
    public synchronized void reset() {
        load(currentMaze);
        playerKilled = false;
    }

    /** Draw all maze components. */
    public synchronized void draw(IDrawOutputBoundary d) {
        Graphics2D g2 = d.graphics();
        hazards.draw(d);
        items.draw(d);
        if (isPlayerKilled()) {
            g2.setColor(Color.RED);
            g2.setFont(new Font(null, Font.PLAIN, 48));
            g2.drawString("Game over", 270, 330);
        }
    }

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input
     */
    public synchronized void movePlayer(int keycode) {
        if (gameOver()) {
            // prevent player from moving after game is over.
            return;
        }

        if (keycode == KeyEvent.VK_W) {
            if (cHandler.upPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(-playerSpeed);}
        }
        if (keycode == KeyEvent.VK_S) {
            if (cHandler.downPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(playerSpeed);}
        }
        if (keycode == KeyEvent.VK_D) {
            if (cHandler.rightPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(playerSpeed);}
        }
        if (keycode == KeyEvent.VK_A) {
            if (cHandler.leftPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(-playerSpeed);}
        }

        checkPlayerKilled();
    }

    /** Get the player's current x position */
    public synchronized int getPlayerX() {
        return player.getPlayerX();
    }

    /** Get the player's current y position */
    public synchronized int getPlayerY() {
        return player.getPlayerY();
    }

    @Override
    public synchronized int mazeWidth() {
        return mazeInfo.getNum("ORIGINAL_TILE_SIZE");
    }

    @Override
    public synchronized int mazeHeight() {
        return mazeInfo.getNum("ORIGINAL_TILE_SIZE");
    }

    @Override
    public synchronized void update() {
        if (gameOver()) {
            // don't update after the game is over.
            return;
        }
        hazards.update(this);
        checkPlayerKilled();
    }

    /** Check if the player has been killed by an enemy. */
    private synchronized void checkPlayerKilled() {
        if (hazards.isPlayerKilled(this)) {
            playerKilled = true;
        }
    }

    /** Is the game over? */
    public synchronized boolean gameOver() {
        return isPlayerKilled();
    }

    /** Has the player been killed? */
    public synchronized boolean isPlayerKilled() {
        return playerKilled;
    }
}
