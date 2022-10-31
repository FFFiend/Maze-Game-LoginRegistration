package hazards;

/**
 * A collection of hazards for a map.
 * A hazard is currently an obstacle or an enemy, but more types of hazards coulds be added in the future.
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
    public boolean isPlayerBlocked(PlayerInfo player) {
        return obstacles.isPlayerBlocked(player);
    }

    /** Check whether the player is blocked by a hazard. */
    public boolean isPlayerKilled(PlayerInfo player) {
        return enemies.isPlayerKilled(player);
    }
}
