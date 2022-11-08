package hazards;

import java.util.ArrayList;
import java.util.List;

/** A collection of enemies for a map. */
public class MapEnemies {
    /** The internal list of enemies. */
    private final List<Enemy> enemies;

    /** Construct a new MapEnemies object with no enemies. */
    public MapEnemies() {
        enemies = new ArrayList<>();
    }

    /** Check whether the player is killed by any enemy. */
    public boolean isPlayerKilled(IHazardRequestModel request) {
        for (Enemy enemy: enemies) {
            if (enemy.killsPlayer(request))
                return true;
        }
        return false;
    }

    /** Add an enemy. */
    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    /** Update all enemies */
    public void update() {
        for (Enemy enemy: enemies) {
            enemy.update();
        }
    }

    /** Reset all enemies to their starting positions. */
    public void reset() {
        for (Enemy enemy: enemies) {
            enemy.reset();
        }
    }
}
