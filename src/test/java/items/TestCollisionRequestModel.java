package items;

import entities.items.ICollisionRequestModel;


/**
 * an ICollisionRequestModel implementation for testing only
 */
public class TestCollisionRequestModel implements ICollisionRequestModel {
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
}
