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
<<<<<<< HEAD
 * Use case interactor for mazes.
 *
 * All the methods in this class use the "synchronized" keyword. This prevents
 * java.util.ConcurrentModificationException, because we are accessing this class in separate threads.
 * */
public class MazeInteractor implements IGamePanelInputBoundary, IHazardRequestModel, Runnable {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final CollisionHandler cHandler;
    private final Player player;
    private final int playerSpeed = 1;

    private final Maze mazeInfo;

    private boolean playerKilled;
    /** The file name of the maze which is currently loaded. */
    private String currentMaze;

    private final int playerStamina = 100;
    private String mazeLevel;
    private final IGamePanelOutputBoundary outputBoundary;
    public Thread gameThread;
    private final int FPS = 20;
    /** Hazards will be updated every this many frames */
    private final int HAZARD_UPDATE_FRAME_INTERVAL = 10;

    public MazeInteractor(IGamePanelOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;

        hazards = new MazeHazards();
        items = new MazeItems();
        player = new Player(1, 1);
        cHandler = new CollisionHandler(items, hazards, player);
        mazeInfo = new Maze();
        playerKilled = false;
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
        player.setStamina(playerStamina);
    }

    /**
     * Load a maze from a file.
     *
     * @param filename the file to read the maze from
     */
    public void load(String filename) {
        new CustomAssetSetter(filename, items, hazards);
        outputBoundary.changeState();
        startGameThread();
        currentMaze = filename;
    }

    /**
     * Create a new game thread and run it.
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
        long frameNumber = 0;
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
            if (frameNumber % HAZARD_UPDATE_FRAME_INTERVAL == 0) {
                updateHazards();
            }
            outputBoundary.redrawMaze(this);
            frameNumber++;
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

        if (player.getStageClear()){
            outputBoundary.changeState();
            outputBoundary.recordStamina(player.getStamina());
            return;
        }
        else if (keycode == KeyEvent.VK_W) {
            if (cHandler.upPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(-playerSpeed);
            }
        }
        else if (keycode == KeyEvent.VK_S) {
            if (cHandler.downPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(playerSpeed);
            }
        }
        else if (keycode == KeyEvent.VK_D) {
            if (cHandler.rightPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(playerSpeed);
            }
        }
        else if (keycode == KeyEvent.VK_A) {
            if (cHandler.leftPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(-playerSpeed);
            }
        }

        player.addStamina(-playerSpeed);
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

    /** Get the player's current stamina */
    public synchronized int getPlayerStamina() {
        return player.getStamina();
    }

    @Override
    public synchronized int mazeWidth() {
        return mazeInfo.getNum("ORIGINAL_TILE_SIZE");
    }

    @Override
    public synchronized int mazeHeight() {
        return mazeInfo.getNum("ORIGINAL_TILE_SIZE");
    }

    private synchronized void updateHazards() {
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

    /**
     * Select the difficulty of the maze.
     *
     * @param keycode the input received from user's keyboard
     */
    @Override
    public void selectLevel(int keycode) {
        if(keycode == KeyEvent.VK_1){
            load("mazes/EasyMaze.txt");
            mazeLevel = "EASY";
        }
        else if(keycode == KeyEvent.VK_2){
            load("mazes/MediumMaze.txt");
            mazeLevel = "MEDIUM";
        }
        else if(keycode == KeyEvent.VK_3){
            load("mazes/HardMaze.txt");
            mazeLevel = "HARD";
        }
    }
}
