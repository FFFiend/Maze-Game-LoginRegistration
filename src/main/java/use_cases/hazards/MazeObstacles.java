package use_cases.hazards;

import adapters.hazards.IHazardRequestModel;
import entities.hazards.Obstacle;

import java.util.ArrayList;
import java.util.List;

/** A collection of obstacles for a maze. */
public class MazeObstacles {
    /**
     * The internal list of obstacles.
     */
    private final List<Obstacle> obstacles;

    /**
     * Construct a MazeObstacles object with no obstacles.
     */
    public MazeObstacles() {
        obstacles = new ArrayList<>();
    }

    /**
     * Check whether the player is blocked by any obstacle.
     */
    public boolean isPlayerBlocked(IHazardRequestModel request) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.blocksPlayer(request))
                return true;
        }
        return false;
    }

    /**
     * Add an obstacle.
     */
    public void add(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    /**
     * Get the obstacle at the specified position.
     */
    public Obstacle get(int x, int y) {
        for (Obstacle o : obstacles) {
            if (o.blocksPoint(x, y)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Delete the obstacle at the specified position.
     */
    public void delete(int x, int y) {
        Obstacle obstacle = get(x, y);
        if (obstacle != null)
            obstacles.remove(obstacle);
    }
}
