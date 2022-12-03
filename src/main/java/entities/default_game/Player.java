package entities.default_game;

/**
 * Represents the player. Player data is updated in UpdatePlayer class.
 */
public class Player extends Entity {

    private static int playerX;
    private static int playerY;
    private static int playerStamina;
    private boolean hasKey = false;
    private boolean stageClear = false;

    public Player(int X, int Y) {
        setPlayerX(X);
        setPlayerY(Y);
    }

    /**
     * Get the player's current x-coordinate.
     *
     * @return the current x-coordinate
     */
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Get the player's current y-coordinate.
     *
     * @return the current y-coordinate.
     */
    public int getPlayerY() {
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
    private void setPlayerX(int X) {
        playerX = X;
    }

    /**
     * Set the player's y-coordinate.
     *
     * @param Y y-coordinate to set the player to.
     */
    private void setPlayerY(int Y) {
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

    public void setHasKey(boolean b) {
        hasKey = b;
    }

    public boolean getHasKey(){
        return hasKey;
    }

    public void setStageClear(boolean b) {
        stageClear = b;
    }

    public boolean getStageClear(){
        return stageClear;
    }
}
