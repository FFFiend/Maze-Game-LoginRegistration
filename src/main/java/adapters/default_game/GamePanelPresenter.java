package adapters.default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.MazeInfo;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanel presents
 **/
public class GamePanelPresenter extends JPanel implements IGamePanelOutputBoundary {
    final int TILE_SIZE = MazeInfo.getTileSize();
    final int PANEL_WIDTH = MazeInfo.getPanelWidth();
    final int PANEL_HEIGHT = MazeInfo.getPanelHeight();
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
            g2.drawString("Oxygen: " + playerStamina, TILE_SIZE * 12, TILE_SIZE);
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

    /**
     * Get the current game state.
     *
     * @return current game state
     */
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
    public void drawTitleScreen(Graphics2D g2) {
        // just to check the screen, design can be changed later
        String text = "AstroMaze";

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        g2.setColor(Color.gray);
        g2.drawString(text, 273, 103);
        g2.setColor(Color.white);
        g2.drawString(text, 270, 100);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        text = "Press 1 for easy level, 2 for medium level, 3 for hard level";
        g2.drawString(text, 100, 200);

        text = "Get on the Escape Pod and go through the Blackhole";
        g2.drawString(text, 100, 300);
        text = "before you run out of Oxygen!";
        g2.drawString(text, 100, 350);
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

        text = "OXYGEN LEFT: " + playerStamina;

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

    /**
     * Draw game over screen.
     *
     * @param g2 graphics
     */
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

    /**
     * Get the x position to center the text on the panel.
     *
     * @param g2 graphics
     * @param text text to center
     * @return x position to set the text to
     */
    public int getCenteredTextX(Graphics2D g2, String text) {
        FontMetrics fm = g2.getFontMetrics();
        return (getWidth() - fm.stringWidth(text)) / 2;
    }

    /**
     * Get the y position to center the text on the panel.
     * @param g2 graphics
     * @return y position to set the text to
     */
    public int getCenteredTextY(Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();
        return (getHeight() + fm.getAscent()) / 2;
    }
}
