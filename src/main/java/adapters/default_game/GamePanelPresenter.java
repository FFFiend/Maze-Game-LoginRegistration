package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
import use_cases.default_game.CustomAssetSetter;
import use_cases.default_game.UpdatePlayer;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanel presents
 **/
public class GamePanelPresenter extends JPanel implements Runnable {
    final int SPRITE_TILE_SIZE = 16;
    final int SCALE = 3; // may be changed to an unfixed variable later
    final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    final int MAX_PANEL_COL = 16;
    final int MAX_PANEL_ROW = 12;
    final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
    final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;
    public Thread gameThread;
    private final int FPS = 5; // updates the screen 5 times per second
    private int playerX;
    private int playerY;
    private final MazeItems items;
    private final MazeHazards hazards;
    /**
     * Construct a new GamePanelPresenter with fixed settings.
     **/
    public GamePanelPresenter(MazeHazards hazards, MazeItems items) {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        UpdatePlayer.setPlayerX(1);
        UpdatePlayer.setPlayerY(1);

        this.hazards = hazards;
        this.items = items;
        CustomAssetSetter setter = new CustomAssetSetter("mazes/maze02.txt",
                items, hazards);
    }

    /**
     * Construct a new game thread and runs it.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // this calls run()
    }

    /**
     * Built-in method that is called if the thread was constructed
     * using a separate Runnable object.
     */
    public void run() {
        // credit to Seamus
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Update the player position for painting.
     */
    public void update() {
        playerX = UpdatePlayer.getPlayerX()*TILE_SIZE;
        playerY = UpdatePlayer.getPlayerY()*TILE_SIZE;
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
        g2.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);

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
        hazards.draw(b);
        items.draw(b);
        g2.dispose();
    }
}
