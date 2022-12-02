package use_cases.custom_game.custom_game_file_management;

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
        //run tests using TempMaze.getMaze(); and if they pass, call:
        fileManager.storeNewCustomMaze();

        return true;
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
}
