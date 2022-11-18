package use_cases.custom_game.custom_game_inner_file_management;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;

public class CustomGameValidator {
    private final EditorTile[][] MAZE;

    public CustomGameValidator(EditorTile[][] maze){
        this.MAZE = maze;
    }

    public boolean verify(){
        //run tests and if they pass, call:
        CustomGameFileManager fileManager = new CustomGameFileManager();
        fileManager.storeNewCustomMaze();

        return true;
        //tests should include checking if TempMaze contains a maze that can be written (ex. exists, all rows/cols same
        // len etc.)
    }
}
