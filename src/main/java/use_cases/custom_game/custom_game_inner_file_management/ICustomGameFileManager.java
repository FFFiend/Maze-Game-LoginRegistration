package use_cases.custom_game.custom_game_inner_file_management;

import adapters.custom_game.custom_game_file_adapters.TempMaze;

public interface ICustomGameFileManager {
    default void storeNewCustomMaze(){
    }
}