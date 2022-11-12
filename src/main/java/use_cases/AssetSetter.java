package use_cases;

import entities.hazards.Obstacle;
import entities.hazards.StationaryEnemy;
import entities.items.ItemBlackhole;
import entities.items.ItemKey;
import entities.items.ItemPhotons;
import use_cases.hazards.MazeHazards;

/**
 * UseCase class for placing all the Assets (Items & Hazards) on the maze
 */
public class AssetSetter {
    private final MazeItems mazeItems;
    private final MazeHazards mazeHazards;

    /**
     * Construct a new AssetSetter class with lists of Assets (Items & Hazards).
     */
    public AssetSetter(MazeItems mazeItems, MazeHazards mazeHazards) {
        this.mazeItems = mazeItems;
        this.mazeHazards = mazeHazards;
    }

    /**
     * Place all the Assets on EASY maze
     */
    public void setAssetsEasy() {
        mazeItems.add(new ItemBlackhole(14, 10));
        mazeItems.add(new ItemKey(5, 5));
        mazeItems.add(new ItemPhotons(4, 8));

        mazeHazards.addEnemy(new StationaryEnemy(10, 10));
        mazeHazards.addObstacle(new Obstacle(2, 2));
    }

    /**
     * Place all the Assets on MEDIUM maze
     */
    public void setAssetsMedium() {
        // implement later
    }

    /**
     * Place all the Assets on HARD maze
     */
    public void setAssetsHard() {
        // implement later
    }
}