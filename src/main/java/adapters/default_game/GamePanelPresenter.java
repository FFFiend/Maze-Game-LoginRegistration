package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
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
    final int FPS = 20;

    private int playerX;
    private int playerY;
    private int playerStamina;

    private int gameState;
    private int titleState = 0;
    private int playState = 1;
    private int levelClearState = 2;

    private MazeItems items;
    private MazeHazards hazards;

    /**
     * Construct a new GamePanelPresenter with fixed settings.
     **/
    public GamePanelPresenter() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        gameState = titleState;
    }

    /**
     * Update player information and draw the maze accordingly.
     *
     * @param playerX       player position X
     * @param playerY       player position Y
     * @param playerStamina player stamina
     */
    public void updateMaze(int playerX, int playerY, int playerStamina,
                           MazeHazards hazards, MazeItems items) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerStamina = playerStamina;
        this.hazards = hazards;
        this.items = items;

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

        if (gameState == titleState) {
            drawTitleScreen(g2);
        } else if (gameState == levelClearState) {
            drawLevelClearScreen(g2);
        } else if (gameState == playState) {
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
            hazards.draw(b);
            items.draw(b);

            g2.drawString("Stamina: " + playerStamina, TILE_SIZE * 12, TILE_SIZE);
            g2.dispose();
        }
    }

    public void changeState() {
        gameState += 1;
    }

    public void recordStamina(int playerStamina){
        this.playerStamina = playerStamina;
    }

    public void drawTitleScreen(Graphics g2) {
        // just to check the screen, design can be changed later
        String text = "AstroMaze";

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        g2.setColor(Color.white);
        g2.drawString(text, 100, 100);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        text = "Press 1 for easy level, 2 for medium level, 3 for hard level";

        g2.drawString(text, 100, 200);
    }

    private void drawLevelClearScreen(Graphics2D g2) {
        String text = "Level Clear!";

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        g2.setColor(Color.white);
        g2.drawString(text, 100, 200);

        text = "Stamina left:" + playerStamina;
        g2.drawString(text, 100, 100);
    }
}
