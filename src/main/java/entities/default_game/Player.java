package entities.default_game;

/**
 * Represents the player. Player data is updated in UpdatePlayer class.
 */
public class Player extends Entity {

    private int playerX;
    private int playerY;
    private int playerStamina;
    private boolean hasKey = false;
    private boolean stageClear = false;

    public Player(int X, int Y) {
        setX(X);
        setY(Y);
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
}
