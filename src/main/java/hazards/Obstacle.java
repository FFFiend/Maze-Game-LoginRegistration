package hazards;

/** An obstacle in a map */
public class Obstacle {
    /** The x position of the obstacle. */
    private int x;
    /** The y position of the obstacle. */
    private int y;
    /** The width of the obstacle, in tiles. */
    private int width;
    /** The height of the obstacle, in tiles. */
    private int height;

    /** Construct a new obstacle at (x, y) with the given width and height. */
    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /** Construct a new 1x1 object at (x, y). */
    public Obstacle(int x, int y) {
        this(x, y, 1, 1);
    }

    /** Get the x position of the obstacle. */
    public int getX() { return x; }

    /** Get the y position of the obstacle. */
    public int getY() { return y; }

    /** Set the x position of the obstacle. */
    public void setX(int x) { this.x = x; }

    /** Set the y position of the obstacle. */
    public void setY(int y) { this.y = y; }

    /** Get the width of the obstacle */
    public int getWidth() { return width; }

    /** Get the height of the obstacle. */
    public int getHeight() { return height; }

    /** Set the width of the obstacle. */
    public void setWidth(int w) { width = w; }

    /** Set the height of the obstacle. */
    public void setHeight(int h) { height = h; }

    /** Check whether the obstacle blocks the player. */
    public boolean blocksPlayer(PlayerInfo player) {
        int playerX = player.getX();
        int playerY = player.getY();
        return playerX >= x && playerY >= y && playerX < x + width && playerY < y + height;
    }
}
