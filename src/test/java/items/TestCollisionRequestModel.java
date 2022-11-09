package items;

import entities.items.ICollisionRequestModel;

import java.awt.*;

/** an IHazardRequestModel implementation for testing only */
public class TestCollisionRequestModel implements ICollisionRequestModel {
    /** simulated player solid area */
    private final Rectangle playerArea;

    /** Create a new test collision request model with the given player position. */
    public TestCollisionRequestModel(int playerX, int playerY) {
        this.playerArea = new Rectangle(playerX, playerY, 48, 48);
    }
    @Override
    public Rectangle getPlayerArea() {
        return this.playerArea;
    }
}
