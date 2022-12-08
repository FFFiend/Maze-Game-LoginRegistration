package use_cases.custom_game.custom_game_file_management;

import entities.custom_game.EditorTile;
import entities.default_game.MazeInfo;
import use_cases.custom_game.custom_game_editor.TempMaze;

/**
 * Responsible for verifying input the user wants to store: maze names from the initializer panel and mazes from the
 * editor panel
 */
public class CustomGameValidator {

    /**
     * Checks if a new custom maze is valid
     *
     * @return whether the maze is valid or not
     */
    public boolean verifyMaze(ICustomGameFileManager fileManager) {
        //Check that the maze contains at least one key and at least one goal
        if (verifyMazeComponents(MazeInfo.getAssetCodeGoal())) {
            if (verifyMazeComponents(MazeInfo.getAssetCodeKey())) {
                fileManager.storeNewCustomMaze();
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a maze name is unique
     *
     * @param name the maze name to check
     * @return whether the name is unique or not
     */
    public boolean verifyName(String name, ICustomGameFileManager fileManager) {
        return !(fileManager.listCustomMazes().contains(name));
    }

    /**
     * Check TempMaze for the presence of at least one of a particular asset
     *
     * @param component the numCode of an asset (goal, key, obstacle etc.) as defined in MazeInfo
     * @return whether that asset can be found in TempMaze
     */
    private boolean verifyMazeComponents(int component){
        EditorTile[][] maze = TempMaze.getMaze();
        for (EditorTile[] row:maze){
            for (EditorTile tile:row){
                if (tile.getNumCode() == component) {
                    return true;
                }
            }
        }
        return false;
    }
}