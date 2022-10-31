package hazards;

import java.util.ArrayList;
import java.util.List;

/** A collection of obstacles for a map. */
public class MapObstacles {
    /** The internal list of obstacles. */
    private final List<Obstacle> obstacles;

    /** Construct a MapObstacles object with no obstacles. */
    public MapObstacles() {
        obstacles = new ArrayList<>();
    }

    /** Check whether the player is blocked by any obstacle. */
    public boolean isPlayerBlocked(PlayerInfo player) {
        for (Obstacle obstacle: obstacles) {
            if (obstacle.blocksPlayer(player))
                return true;
        }
        return false;
    }

    /** Add an obstacle. */
    public void add(Obstacle obstacle) {
        obstacles.add(obstacle);
    }
}
