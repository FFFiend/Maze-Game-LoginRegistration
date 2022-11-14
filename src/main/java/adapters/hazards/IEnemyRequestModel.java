package adapters.hazards;

/**
 * Interface for communicating relevant information about the maze to the enemies.
 * This is currently only being used internally by enemy-related classes.
 */
public interface IEnemyRequestModel {
    /**
     * Is the tile at this position blocked?
     * This is important information for moving enemies, since they should never move onto obstacles.
     */
    boolean isTileBlockedForEnemies(int x, int y);
    /** Player X position */
    int getPlayerX();
    /** Player Y position */
    int getPlayerY();

}
