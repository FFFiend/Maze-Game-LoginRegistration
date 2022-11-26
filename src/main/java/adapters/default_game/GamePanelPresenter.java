package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
import use_cases.default_game.CustomAssetSetter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanel presents
 **/
public class GamePanelPresenter extends JPanel implements IGamePanelOutputBoundary {
    final int SPRITE_TILE_SIZE = 16;
    final int SCALE = 3; // may be changed to an unfixed variable later
    final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    final int MAX_PANEL_COL = 16;
    final int MAX_PANEL_ROW = 12;
    final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
    final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;
    private int playerX;
    private int playerY;

    private final MazeHazards hazards;
    private final MazeItems items;

    /**
     * Construct a new GamePanelPresenter with fixed settings.
     **/
    public GamePanelPresenter(MazeItems items, MazeHazards hazards) {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.items = items;
        this.hazards = hazards;
        loadMaze("mazes/maze02.txt");
    }

    /** Load a maze from a file.
     *
     * @param filename The path to the maze description file.
     */
    public void loadMaze(String filename) {
        new CustomAssetSetter(filename, items, hazards);
    }

    /**
     * Update the player position and draw the maze accordingly.
     *
     * @param playerX player position X
     * @param playerY player position Y
     */
    public void updateMaze(int playerX, int playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
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
        g2.fillRect(playerX*TILE_SIZE, playerY*TILE_SIZE, TILE_SIZE, TILE_SIZE);

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
