package adapters.custom_game.custom_game_file_adapters;

import entities.items.Item;
import entities.items.ItemBlackhole;
import use_cases.MazeItems;
import use_cases.hazards.MazeHazards;

import java.util.Objects;

public class tempMaze {
    //a class to store assets until editing is complete and the finished maze can be written into a text file

    private MazeItems mazeItems;
    private MazeHazards mazeHazards;

    public void addAsset(String assetName, int x, int y){
        if(Objects.equals(assetName, "blackhole")){
            //don't create an instance of the entity, just the image
        }
        // else if ...
        updateDisplay();
    }

    public void updateDisplay(){
        //loop through and display each item in mazeItems and mazeHazards
    }
}
