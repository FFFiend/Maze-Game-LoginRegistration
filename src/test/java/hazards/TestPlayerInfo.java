package hazards;

/** a PlayerInfo implementation for testing only */
public class TestPlayerInfo implements PlayerInfo {
    /** simulated x position */
    private final int x;
    /** simulated y position */
    private final int y;

    /** Create a new test player info with the given position. */
    public TestPlayerInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
