package hazards;

public class StationaryEnemy extends Enemy {

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
