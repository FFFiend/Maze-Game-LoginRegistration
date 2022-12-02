package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.Maze;
import use_cases.default_game.CustomAssetSetter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanel presents
 **/
public class GamePanelPresenter extends JPanel implements IGamePanelOutputBoundary, Runnable {
    final int SPRITE_TILE_SIZE = 16;
    final int SCALE = 3; // may be changed to an unfixed variable later
    final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    final int MAX_PANEL_COL = 16;
    final int MAX_PANEL_ROW = 12;
    final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
    final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;
    final int FPS = 20;

    private int playerX;
    private int playerY;
    private int playerStamina;

    private final MazeInteractor maze;
    private final Thread gameThread;

    /**
     * Construct a new GamePanelPresenter with fixed settings.
     **/
    public GamePanelPresenter(MazeInteractor maze) {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.maze = maze;
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Update player information and draw the maze accordingly.
     *
     * @param playerX       player position X
     * @param playerY       player position Y
     * @param playerStamina player stamina
     */
    public void updateMaze(int playerX, int playerY, int playerStamina) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerStamina = playerStamina;
        repaint();
    }

    /**
     * Built-in method which calls the UI delegate's paint method
     * if the UI delegate is non-null.
     *
     * @param g a copy of the Graphics object to protect the rest of
     *          the paint code from irrevocable changes.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX * TILE_SIZE, playerY * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // draw the maze
        IDrawOutputBoundary b = new IDrawOutputBoundary() {
            @Override
            public int getTileSize() {
                return TILE_SIZE;
            }

            @Override
            public Graphics2D graphics() {
                return g2;
            }
        };
        maze.draw(b);
        g2.drawString("Stamina: " + playerStamina, TILE_SIZE * 12, TILE_SIZE);
        g2.dispose();
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
            updateMaze(maze.getPlayerX(), maze.getPlayerY(), maze.getPlayerStamina());
        }
    }

}
