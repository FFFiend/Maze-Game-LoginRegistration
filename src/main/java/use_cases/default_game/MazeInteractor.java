package use_cases.default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.MazeInfo;
import entities.default_game.Player;
import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;
import use_cases.login_leaderboard.IFileOutput;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Use case interactor for mazes.
 * <p>
 * All the methods in this class use the "synchronized" keyword. This prevents
 * java.util.ConcurrentModificationException, because we are accessing this class in separate threads.
 */
public class MazeInteractor implements IGamePanelInputBoundary, IHazardRequestModel, Runnable {
    private MazeHazards hazards;
    private MazeItems items;
    private CollisionHandler cHandler;
    private Player player;
    private final int playerSpeed = 1;

    private boolean playerKilled;
    /**
     * The file name of the maze which is currently loaded.
     */
    private String currentMaze;

    private final int STARTING_STAMINA = 50;
    private String mazeLevel;
    private final IGamePanelOutputBoundary outputBoundary;
    private final IFileOutput updateScore;
    /** This is set to true when the game has been stopped. */
    private boolean stop;
    private final int FPS = 20;
    private int currState;
    /**
     * Hazards will be updated every this many frames
     */
    private final int HAZARD_UPDATE_FRAME_INTERVAL = 10;

    public MazeInteractor(IGamePanelOutputBoundary outputBoundary, IFileOutput updateScore) {
        this.outputBoundary = outputBoundary;
        this.updateScore = updateScore;
    }

    /**
     * Reset the state of the maze.
     */
    public synchronized void reset() {
        if (player.getStageClear()) {
            // don't reset if the level has been completed.
            return;
        }
        load(currentMaze);
        playerKilled = false;
    }

    /**
     * Draw all maze components.
     */
    public synchronized void draw(IDrawOutputBoundary d) {
        hazards.draw(d);
        items.draw(d);
        player.draw(d);
    }

    /**
     * Load a maze from a file.
     *
     * @param filename the file to read the maze from
     */
    public synchronized void load(String filename) {
        player = new Player(1, 1);
        hazards = new MazeHazards();
        items = new MazeItems();
        cHandler = new CollisionHandler(items, hazards, player);

        player.setStamina(STARTING_STAMINA);
        player.setHasKey(false);
        player.setStageClear(false);

        hazards.clear();
        items.clear();
        new CustomAssetSetter(filename, items, hazards);
        outputBoundary.changeState(IGamePanelOutputBoundary.PLAY_STATE);

        playerKilled = false;
        currentMaze = filename;
    }

    /** Start the game update thread. */
    public void startGameThread() {
        Thread gameThread = new Thread(this);
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
        while (!stop) {
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
        // Reset stop to false, so that the next time this is called,
        // it doesn't stop immediately.
        stop = false;
    }

    /**
     * Execute the given keycode.
     *
     * @param keycode user keyboard input
     */
    public void execute(int keycode) throws IOException {
        currState = outputBoundary.getState();
        if (keycode == KeyEvent.VK_1 || keycode == KeyEvent.VK_2 || keycode == KeyEvent.VK_3) {
            if (currState == outputBoundary.TITLE_STATE) {
                displayLevel(keycode);
            }
        } else if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_S ||
                keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_A) {
            if (currState == outputBoundary.PLAY_STATE) {
                movePlayer(keycode);
            }
        } else if (keycode == KeyEvent.VK_R) {
            if (currState == outputBoundary.PLAY_STATE ||
                    currState == outputBoundary.GAME_OVER_STATE) {
                reset();
            }
        } else if (keycode == KeyEvent.VK_ESCAPE) {
            if (currState == outputBoundary.GAME_OVER_STATE ||
                    currState == outputBoundary.LEVEL_CLEAR_STATE) {
                stop = true;
                outputBoundary.changeState(outputBoundary.TITLE_STATE);
            }
        }
    }

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode user keyboard input
     */
    public synchronized void movePlayer(int keycode) throws IOException {
        if (gameOver()) {
            // prevent player from moving after game is over.
            return;
        } else if (keycode == KeyEvent.VK_W) {
            player.setDirection("up");
            if (cHandler.upPressed(player.getX(), player.getY())) {
                player.movePlayerY(-playerSpeed);
                player.addStamina(-playerSpeed);
            }
        } else if (keycode == KeyEvent.VK_S) {
            player.setDirection("down");
            if (cHandler.downPressed(player.getX(), player.getY())) {
                player.movePlayerY(playerSpeed);
                player.addStamina(-playerSpeed);
            }
        } else if (keycode == KeyEvent.VK_D) {
            player.setDirection("right");
            if (cHandler.rightPressed(player.getX(), player.getY())) {
                player.movePlayerX(playerSpeed);
                player.addStamina(-playerSpeed);
            }
        } else if (keycode == KeyEvent.VK_A) {
            player.setDirection("left");
            if (cHandler.leftPressed(player.getX(), player.getY())) {
                player.movePlayerX(-playerSpeed);
                player.addStamina(-playerSpeed);
            }
        }

        if (player.getStageClear()) {
            outputBoundary.changeState(IGamePanelOutputBoundary.LEVEL_CLEAR_STATE);
            outputBoundary.recordStamina(player.getStamina());

            updateScore.updateScore(player.getStamina(), mazeLevel, "arifa");

            return;
        }

        checkPlayerKilled();
    }

    /**
     * Get the player's current x position
     */
    public synchronized int getPlayerX() {
        return player.getX();
    }

    /**
     * Get the player's current y position
     */
    public synchronized int getPlayerY() {
        return player.getY();
    }

    /**
     * Get the player's current stamina
     */
    public synchronized int getPlayerStamina() {
        return player.getStamina();
    }

    @Override
    public synchronized int mazeWidth() {
        return MazeInfo.getOriginalTileSize();
    }

    @Override
    public synchronized int mazeHeight() {
        return MazeInfo.getOriginalTileSize();
    }

    private synchronized void updateHazards() {
        if (gameOver()) {
            // don't update after the game is over.
            return;
        }
        hazards.update(this);
        checkPlayerKilled();
    }

    /**
     * Check if the player has been killed by an enemy or has run out of stamina.
     */
    private void checkPlayerKilled() {
        if (hazards.isPlayerKilled(this) || player.getStamina() <= 0) {
            playerKilled = true;
            outputBoundary.changeState(IGamePanelOutputBoundary.GAME_OVER_STATE);
        }
    }

    /**
     * Is the game over?
     */
    public synchronized boolean gameOver() {
        return isPlayerKilled() || player.getStageClear();
    }

    /**
     * Has the player been killed?
     */
    public synchronized boolean isPlayerKilled() {
        return playerKilled;
    }

    /**
     * Display the maze level that the user selected
     *
     * @param keycode user keyboard input 1,2,3
     */
    public void displayLevel(int keycode) {
        if (keycode == KeyEvent.VK_1) {
            load("mazes/EasyMaze.txt");
            mazeLevel = "EASY";
        } else if (keycode == KeyEvent.VK_2) {
            load("mazes/MediumMaze.txt");
            mazeLevel = "MEDIUM";
        } else if (keycode == KeyEvent.VK_3) {
            load("mazes/HardMaze.txt");
            mazeLevel = "HARD";
        }
        startGameThread();
    }
}
