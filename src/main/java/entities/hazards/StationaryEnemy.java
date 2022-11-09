package entities.hazards;

import entities.hazards.Enemy;

/** An enemy which does not move from its starting position */
public class StationaryEnemy extends Enemy {

    /** Create a new stationary enemy at the given position. */
    public StationaryEnemy(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void reset() {
        // we don't need to do anything here
    }

    @Override
    public void update() {
        // we don't need to do anything here
    }

    @Override
    public int getX() {
        return getStartX();
    }

    @Override
    public int getY() {
        return getStartY();
    }
}
