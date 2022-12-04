package entities.default_game;

/**
 * Contains all global constants for the dimensions of the maze and the
 * assets on the maze.
 */
public class MazeInfo {

    private static final int ORIGINAL_TILE_SIZE = 16;
    private static final int SCALE = 3;
    private static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    private static final int MAX_PANEL_COL = 16;
    private static final int MAX_PANEL_ROW = 12;
    private static final int FRAME_WIDTH = MAX_PANEL_COL * TILE_SIZE;
    private static final int FRAME_HEIGHT = MAX_PANEL_ROW * TILE_SIZE;
    private static final int EMPTY_NUM_CODE = 0;
    private static final int OBSTACLE_NUM_CODE = 1;
    private static final int STATIONARY_ENEMY_NUM_CODE = 2;
    private static final int CHASING_ENEMY_NUM_CODE = 3;
    private static final int KEY_NUM_CODE = 4;
    private static final int PHOTONS_NUM_CODE = 5;
    private static final int GOAL_NUM_CODE = 6;

    public static int getOriginalTileSize(){
        return ORIGINAL_TILE_SIZE;
    }

    public static int getScale(){
        return SCALE;
    }
    public static int getTileSize(){
        return TILE_SIZE;
    }

    public static int getMaxPanelCol(){
        return MAX_PANEL_COL;
    }

    public static int getMaxPanelRow(){
        return MAX_PANEL_ROW;
    }

    public static int getFrameWidth(){
        return FRAME_WIDTH;
    }

    public static int getFrameHeight(){
        return FRAME_HEIGHT;
    }

    public static int getAssetCodeEmpty(){
        return EMPTY_NUM_CODE;
    }

    public static int getAssetCodeObstacle(){
        return OBSTACLE_NUM_CODE;
    }

    public static int getAssetCodeStationaryEnemy(){
        return STATIONARY_ENEMY_NUM_CODE;
    }

    public static int getAssetCodeChasingEnemy(){
        return CHASING_ENEMY_NUM_CODE;
    }

    public static int getAssetCodeKey(){
        return KEY_NUM_CODE;
    }

    public static int getAssetCodePhotons(){
        return PHOTONS_NUM_CODE;
    }

    public static int getAssetCodeGoal(){
        return GOAL_NUM_CODE;
    }
}


