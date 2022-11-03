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

    /**
     * An exception indicating that the obstacle has been set to an invalid (zero or negative) size.
     * This is a RuntimeException, because it would be annoying to check for this everywhere,
     * and it's a relatively unlikely mistake.
     * */
    public static class BadSizeException extends RuntimeException {
        /** Create a new BadSizeException.
         * @param isWidth If true, the problem is the obstacle's width. If false, it's the obstacle's height.
         * @param value The attempted width/height value.
         */

        public BadSizeException(boolean isWidth, int value) {
            super(getMessage(isWidth, value));
        }

        private static String getMessage(boolean isWidth, int value) {
            if (isWidth)
                return "Bad obstacle width: " + value;
            else
                return "Bad obstacle height: " + value;
        }
    }

    /** Throw a BadSizeException if width is invalid. */
    public static void checkWidth(int width) {
        if (width <= 0)
            throw new BadSizeException(true, width);
    }

    /** Throw a BadSizeException if height is invalid. */
    public static void checkHeight(int height) {
        if (height <= 0)
            throw new BadSizeException(false, height);
    }



    /** Construct a new obstacle at (x, y) with the given width and height.
     * width and height must be positive, otherwise a BadSizeException will be thrown.
     * */
    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        checkWidth(width);
        checkHeight(height);
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

    /** Get the width of the obstacle. */
    public int getWidth() { return width; }

    /** Get the height of the obstacle. */
    public int getHeight() { return height; }

    /** Set the width of the obstacle. width must be positive, otherwise a BadSizeException will be thrown. */
    public void setWidth(int w) {
        checkWidth(w);
        width = w;
    }

    /** Set the height of the obstacle. height must be positive, otherwise a BadSizeException will be thrown. */
    public void setHeight(int h) {
        checkHeight(h);
        height = h;
    }

    /** Check whether the obstacle blocks the player. */
    public boolean blocksPlayer(IHazardRequestModel request) {
        int playerX = request.getPlayerX();
        int playerY = request.getPlayerY();
        return playerX >= x && playerY >= y && playerX < x + width && playerY < y + height;
    }
}
