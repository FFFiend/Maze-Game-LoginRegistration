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
    public boolean isPlayerKilled(PlayerInfo player) {
        for (Enemy enemy: enemies) {
            if (enemy.killsPlayer(player))
                return true;
        }
        return false;
    }

    /** Add an enemy. */
    public void add(Enemy enemy) {
        enemies.add(enemy);
    }
}
