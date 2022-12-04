package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;

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

    private MazeInteractor maze;

    /**
     * Construct a new GamePanelPresenter with fixed settings.
     **/
    public GamePanelPresenter() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        gameState = IGamePanelOutputBoundary.TITLE_STATE;
    }

    /**
     * Update maze information and draw the maze accordingly.
     *
     * @param maze the use case interactor for the maze
     */
    public void redrawMaze(MazeInteractor maze) {
        this.playerX = maze.getPlayerX();
        this.playerY = maze.getPlayerY();
        this.playerStamina = maze.getPlayerStamina();
        this.maze = maze;

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

        if (gameState == IGamePanelOutputBoundary.TITLE_STATE) {
            drawTitleScreen(g2);
        } else if (gameState == IGamePanelOutputBoundary.LEVEL_CLEAR_STATE) {
            drawLevelClearScreen(g2);
        } else if (gameState == IGamePanelOutputBoundary.GAME_OVER_STATE) {
            drawGameOverScreen(g2);
        } else if (gameState == IGamePanelOutputBoundary.PLAY_STATE) {
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

            g2.setFont(new Font(null, Font.PLAIN, 28));
            g2.setColor(Color.GREEN);
            g2.drawString("Stamina: " + playerStamina, TILE_SIZE * 12, TILE_SIZE);
            g2.dispose();
        }
    }

    /**
     * Set the game state.
     *
     * @param newState The new game state. This must be one of the *_STATE
     *                 constants defined in IGameOutputBoundary.
     */
    public void changeState(int newState) {
        gameState = newState;
    }

    public int getState() {
        return gameState;
    }

    /**
     * Record the current stamina.
     *
     * @param playerStamina current stamina
     */
    public void recordStamina(int playerStamina) {
        this.playerStamina = playerStamina;
    }

    /**
     * Draw the title screen.
     *
     * @param g2 graphics
     */
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

    /**
     * Draw clear level screen.
     *
     * @param g2 graphics
     */
    private void drawLevelClearScreen(Graphics2D g2) {
        String text = "LEVEL CLEAR";

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        g2.setColor(Color.green);

        int x = getCenteredTextX(g2, text);
        int y = getCenteredTextY(g2);
        g2.drawString(text, x, y);

        text = "STAMINA LEFT: " + playerStamina;

        g2.setColor(Color.WHITE);
        g2.setFont(new Font(null, Font.PLAIN, 20));

        x = getCenteredTextX(g2, text);
        y = y + 40;
        g2.drawString(text, x, y);

        text = "PRESS ESC TO GO BACK TO TITLE SCREEN";
        x = getCenteredTextX(g2, text);
        y = y + 40;
        g2.drawString(text, x, y);
    }

    private void drawGameOverScreen(Graphics2D g2) {
        String text = "GAME OVER";
        g2.setColor(Color.RED);
        g2.setFont(new Font(null, Font.PLAIN, 48));

        int x = getCenteredTextX(g2, text);
        int y = getCenteredTextY(g2);
        g2.drawString(text, x, y);

        text = "PRESS R TO RESTART LEVEL";
        g2.setColor(Color.WHITE);
        g2.setFont(new Font(null, Font.PLAIN, 20));

        x = getCenteredTextX(g2, text);
        y = y + 40;
        g2.drawString(text, x, y);

        text = "PRESS ESC TO GO BACK TO TITLE SCREEN";
        x = getCenteredTextX(g2, text);
        y = y + 40;
        g2.drawString(text, x, y);
    }

    public int getCenteredTextX(Graphics2D g2, String text) {
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        return x;
    }

    public int getCenteredTextY(Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();
        int y = (getHeight() + fm.getAscent()) / 2;
        return y;
    }


}
