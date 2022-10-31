package hazards;

public abstract class Enemy {
    /** The starting x position for the enemy. */
    private int startX;
    /** The starting y position for the enemy. */
    private int startY;

    /** Reset the enemy to its initial state. */
    public abstract void reset();

    /** Update the enemy. This should be called at a fixed interval (e.g. every 0.5 seconds). */
    public abstract void update();

    /** Get the current x position of the enemy. */
    public abstract int getX();

    /** Get the current y position of the enemy. */
    public abstract int getY();

    /** Get the starting x position of the enemy. */
    public int getStartX() { return startX; }

    /** Get the starting y position of the enemy. */
    public int getStartY() { return startY; }

    /** Set the starting x position of the enemy. */
    protected void setStartX(int x) { startX = x; }

    /** Set the starting y position of the enemy. */
    protected void setStartY(int y) { startY = y; }

    /** Check whether this enemy kills the player. */
    public boolean killsPlayer(PlayerInfo player) {
        return player.getX() == getX() && player.getY() == getY();
    }


}
