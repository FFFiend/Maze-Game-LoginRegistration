package use_cases.default_game;

import entities.default_game.Player;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.awt.event.KeyEvent;

/**
 * Use case interactor for mazes
 */
public class MazeInteractor implements IGamePanelInputBoundary, Runnable {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final CollisionHandler cHandler;
    private final Player player;
    private final int playerSpeed = 1;
    private final int playerStamina = 100;
    private String mazeLevel;
    private final IGamePanelOutputBoundary outputBoundary;
    public Thread gameThread;
    int FPS = 20;

    public MazeInteractor(IGamePanelOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;

        hazards = new MazeHazards();
        items = new MazeItems();
        player = new Player(1, 1);
        cHandler = new CollisionHandler(items, hazards, player);
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
     * Update all maze components.
     */
    public void update(){
        outputBoundary.updateMaze(player.getPlayerX(), player.getPlayerY(), player.getStamina(),
                hazards, items );
    }

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input
     */
    public void movePlayer(int keycode) {
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
