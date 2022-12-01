package entities.default_game;


import java.util.HashMap;

/**
 * HashMap that contains all global constants for the dimensions of the maze and the assets on the maze.
 */
public class Maze {
    private final HashMap<String, Integer> maze;

    /**
     * construct Maze HashMap with all the necessary global constants
     */
    public Maze() {
        HashMap<String, Integer> maze = new HashMap<>();
        this.maze = maze;

        // dimensions
        maze.put("ORIGINAL_TILE_SIZE", 16);
        maze.put("SCALE", 3);
        maze.put("TILE_SIZE", 48);  // ORIGINAL_TILE_SIZE * SCALE

        maze.put("MAX_PANEL_COL", 16);
        maze.put("MAX_PANEL_ROW", 12);

        maze.put("FRAME_WIDTH", 768);  // MAX_SCREEN_COL * TILE_SIZE
        maze.put("FRAME_HEIGHT", 576);  // MAX_SCREEN_ROW * TILE_SIZE

        // Assets
        maze.put("EMPTY_NUM_CODE", 0);
        maze.put("OBSTACLE_NUM_CODE", 1);
        maze.put("STATIONARY_ENEMY_NUM_CODE", 2);
        maze.put("CHASING_ENEMY_NUM_CODE", 3);
        maze.put("KEY_NUM_CODE", 4);
        maze.put("PHOTONS_NUM_CODE", 5);
        maze.put("END_NUM_CODE", 6);
    }

    /**
     * A method to get the value from the HashMap based on the key
     */
    public int getNum(String num) {
        return maze.get(num);
    }
}


