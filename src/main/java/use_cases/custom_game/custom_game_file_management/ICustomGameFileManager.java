package use_cases.custom_game.custom_game_file_management;

import java.util.ArrayList;

/**
 * Handles all reading and writing to the files used by the customization feature
 */
public interface ICustomGameFileManager {
    void storeNewCustomMaze();

    ArrayList<String> listCustomMazes();
}