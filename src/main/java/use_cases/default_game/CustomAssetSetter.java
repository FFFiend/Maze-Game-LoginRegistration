package use_cases.default_game;

import entities.default_game.MazeInfo;
import entities.hazards.ChasingEnemy;
import entities.hazards.Obstacle;
import entities.hazards.StationaryEnemy;
import entities.items.ItemBlackhole;
import entities.items.ItemKey;
import entities.items.ItemOxygen;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Use case which reads the maze data from a file.
 */
public class CustomAssetSetter {

    /**
     * dimensions of the map
     */
    final int MAX_MAZE_COL = MazeInfo.getMaxMazeCol();
    final int MAX_MAZE_ROW = MazeInfo.getMaxMazeRow();

    /**
     * Num codes for the Assets
     */
    final int OBSTACLE_NUM_CODE = MazeInfo.getAssetCodeObstacle();
    final int STATIONARY_ENEMY_NUM_CODE = MazeInfo.getAssetCodeStationaryEnemy();
    final int CHASING_ENEMY_NUM_CODE = MazeInfo.getAssetCodeChasingEnemy();
    final int KEY_NUM_CODE = MazeInfo.getAssetCodeKey();
    final int OXYGEN_NUM_CODE = MazeInfo.getAssetCodeOxygen();
    final int GOAL_NUM_CODE = MazeInfo.getAssetCodeGoal();

    /**
     * Matrix to store integers that correspond to various Assets in the maze.
     */
    private final int[][] mazeAssetNum;

    /**
     * UseCases that deal with the Assets
     */
    private final MazeItems mazeItems;
    private final MazeHazards mazeHazards;

    /**
     * Constructs CustomAssetSetter to place assets on the maze.
     */
    public CustomAssetSetter(String filePath, MazeItems mazeItems, MazeHazards mazeHazards) {
        mazeItems.clear();
        mazeHazards.clear();
        this.mazeItems = mazeItems;
        this.mazeHazards = mazeHazards;
        this.mazeAssetNum = new int[MAX_MAZE_COL][MAX_MAZE_ROW];
        loadMaze(filePath);
        setAssets();
    }

    /**
     * Adds the integers to mazeAssetNum matrix that correspond to various Assets in the maze.
     *
     * @param filePath the filePath to the txt. file to get the integers from
     */
    public void loadMaze(String filePath) {
        InputStream is;
        try {
            if (filePath.startsWith("custom_mazes/")) {
                is = new FileInputStream(filePath);
            } else {
                is = getClass().getClassLoader().getResourceAsStream(filePath);
            }
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < MAX_MAZE_COL && row < MAX_MAZE_ROW) {
                String line = br.readLine();
                while (col < MAX_MAZE_COL) {
                    String[] numbers = line.split(" ");  // remove whitespace
                    int num = Integer.parseInt(numbers[col]);  // change String -> int

                    mazeAssetNum[col][row] = num;
                    col++;
                }
                if (col == MAX_MAZE_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    /**
     * Add assets to MazeItems & MazeHazards according to the mazeAssetNum matrix.
     */
    public void setAssets() {
        int col = 0;
        int row = 0;

        while (col < MAX_MAZE_COL && row < MAX_MAZE_ROW) {
            int assetNum = mazeAssetNum[col][row];  // go through each element in matrix
            if (assetNum == OBSTACLE_NUM_CODE) {
                mazeHazards.addObstacle(new Obstacle(col, row));
            }
            if (assetNum == STATIONARY_ENEMY_NUM_CODE) {
                mazeHazards.addEnemy(new StationaryEnemy(col, row));
            }
            if (assetNum == CHASING_ENEMY_NUM_CODE) {
                mazeHazards.addEnemy(new ChasingEnemy(col, row));
            }
            if (assetNum == KEY_NUM_CODE) {
                mazeItems.add(new ItemKey(col, row));
            }
            if (assetNum == OXYGEN_NUM_CODE) {
                mazeItems.add(new ItemOxygen(col, row));
            }
            if (assetNum == GOAL_NUM_CODE) {
                mazeItems.add(new ItemBlackhole(col, row));
            }
            col++;
            if (col == MAX_MAZE_COL) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Getters for testing
     */
    public int[][] getMazeAssetNum() {
        return this.mazeAssetNum;
    }

    /** Get the items in this maze. */
    public MazeItems getMazeItems() {
        return this.mazeItems;
    }

    /** Get the hazards in this maze. */
    public MazeHazards getMazeHazards() {
        return this.mazeHazards;
    }
}
