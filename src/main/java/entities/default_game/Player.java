package entities.default_game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Represents the player. Player data is updated in UpdatePlayer class.
 */
public class Player extends Entity {

    private int playerX;
    private int playerY;
    private int playerStamina;
    private boolean hasKey = false;
    private boolean stageClear = false;
    /**
     * The images of the Player
     */
    private BufferedImage imageUp, imageDown, imageLeft, imageRight;
    /**
     * The current direction of the Player
     */
    private String direction = "down";

    public Player(int X, int Y) {
        setX(X);
        setY(Y);
        try {
            imageUp = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/astro_up.png"));
            imageDown = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/astro_down.png"));
            imageLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/astro_left.png"));
            imageRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/astro_right.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the player's current x-coordinate.
     *
     * @return the current x-coordinate
     */
    public int getX() {
        return playerX;
    }

    /**
     * Get the player's current y-coordinate.
     *
     * @return the current y-coordinate.
     */
    public int getY() {
        return playerY;
    }

    /**
     * Get the player's current stamina.
     *
     * @return player's current stamina
     */
    public int getStamina() {
        return playerStamina;
    }

    /**
     * Set the player's x-coordinate.
     *
     * @param X x-coordinate to set the player to.
     */
    public void setX(int X) {
        playerX = X;
    }

    /**
     * Set the player's y-coordinate.
     *
     * @param Y y-coordinate to set the player to.
     */
    public void setY(int Y) {
        playerY = Y;
    }

    /**
     * Set the player's stamina.
     *
     * @param initialStamina stamina that the player initially has
     */
    public void setStamina(int initialStamina) {
        playerStamina = initialStamina;
    }

    /**
     * Change the player's x-coordinate by moveByX.
     *
     * @param moveByX value to change the x-coordinate by.
     */
    public void movePlayerX(int moveByX) {
        playerX += moveByX;
    }

    /**
     * Change the player's y-coordinate by moveByY.
     *
     * @param moveByY value to change the y-coordinate by.
     */
    public void movePlayerY(int moveByY) {
        playerY += moveByY;
    }

    /**
     * Add addBy to the player's current stamina.
     *
     * @param addBy the amount to change the stamina by
     */
    public void addStamina(int addBy) {
        playerStamina += addBy;
    }

    /** Set whether or not the player has picked up the key. */
    public void setHasKey(boolean b) {
        hasKey = b;
    }

    /** Has the player picked up they key? */
    public boolean getHasKey(){
        return hasKey;
    }

    /** Set whether or not the player has cleared the stage. */
    public void setStageClear(boolean b) {
        stageClear = b;
    }

    /** Has the player cleared the stage? */
    public boolean getStageClear(){
        return stageClear;
    }

    /** Set the player's direction */
    public void setDirection(String direction){
        this.direction = direction;
    }

    /** Get the player's direction */
    public String getDirection(){
        return direction;
    }
    /** Draw the player's sprite according to its current direction */
    public void draw(IDrawOutputBoundary d) {
        Graphics2D g2 = d.graphics();
        int tileSize = d.getTileSize();
        int xPixels = getX() * tileSize;
        int yPixels = getY() * tileSize;
        BufferedImage image = null;
        switch (getDirection()) {
            case "up": {
                image = imageUp;
                break;
            }
            case "down": {
                image = imageDown;
                break;
            }
            case "left": {
                image = imageLeft;
                break;
            }
            case "right": {
                image = imageRight;
                break;
            }
        }
        if (image != null) {
            g2.drawImage(image, xPixels, yPixels, tileSize, tileSize, null);
        } else {
            // default rectangle in case Image loading fails
            g2.setColor(Color.WHITE);
            g2.drawRect(xPixels, yPixels, tileSize, tileSize);
        }
    }
}
