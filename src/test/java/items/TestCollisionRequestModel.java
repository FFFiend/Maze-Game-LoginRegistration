package items;

import entities.hazards.IHazardRequestModel;


/**
 * an IHazardRequestModel implementation for testing only
 */
public class TestCollisionRequestModel implements IHazardRequestModel {
    /**
     * simulated player x position
     */
    private final int playerX;
    /**
     * simulated player y position
     */
    private final int playerY;

    /**
     * Create a new test collision request model with the given player position.
     */
    public TestCollisionRequestModel(int playerX, int playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }

    @Override
    public int getPlayerX() {
        return playerX;
    }

    @Override
    public int getPlayerY() {
        return playerY;
    }

    @Override
    public int mazeWidth() {
        return 0;
    }

    @Override
    public int mazeHeight() {
        return 0;
    }
}
