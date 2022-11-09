package use_cases.hazards;

import adapters.hazards.IHazardRequestModel;
import entities.hazards.Enemy;
import entities.hazards.Obstacle;

/**
 * A collection of hazards for a map.
 * A hazard is currently an obstacle or an enemy, but more types of hazards could be added in the future.
 * */
public class MapHazards {
    /** An object which manages the enemies for the map. */
    private final MapEnemies enemies;
    /** An object which manages the obstacles for the map. */
    private final MapObstacles obstacles;

    /** Create an empty map hazards object. */
    public MapHazards() {
        enemies = new MapEnemies();
        obstacles = new MapObstacles();
    }

    /** Add an enemy to the map hazards. */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    /** Add an obstacle to the map hazards. */
    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    /** Check whether the player is blocked by a hazard. */
    public boolean isPlayerBlocked(IHazardRequestModel request) {
        return obstacles.isPlayerBlocked(request);
    }

    /** Check whether the player is blocked by a hazard. */
    public boolean isPlayerKilled(IHazardRequestModel request) {
        return enemies.isPlayerKilled(request);
    }

    /** Update the map hazards.
     * This should be called at a fixed interval (e.g. every 0.5 seconds).
     * The game can be made more difficult by calling this more often, since enemies will move faster. */
    public void update() {
        enemies.update();
    }

    /** Reset the map hazards to their initial state.
     * This can be called when the player is killed, and the user has to restart the level. */
    public void reset() {
        enemies.reset();
    }

    /** Get the enemy at the given position.
     * @return The enemy, or null if there is no enemy at this position.
     */
    public Enemy getEnemy(int x, int y) {
        return enemies.get(x, y);
    }

    /** Delete the enemy at the given position if there is one. */
    public void deleteEnemy(int x, int y) {
        enemies.delete(x, y);
    }
}
