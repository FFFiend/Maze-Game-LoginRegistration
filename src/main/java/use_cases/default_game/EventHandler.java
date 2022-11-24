package use_cases.default_game;

import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

public class EventHandler {
    private final MazeItems items;
    private final MazeHazards hazards;

    public EventHandler(MazeHazards hazards, MazeItems items){
        this.items = items;
        this.hazards = hazards;
    }
    public void pickUpItem(IHazardRequestModel request){
        int x = request.getPlayerX();
        int y = request.getPlayerY();
        String itemName = items.get(x, y).getName();
        switch(itemName) {
            case "Photons":
                items.delete(x, y);
                // restore Player stamina
            case "Key":
                items.delete(x, y);
                // set Player hasKey == True
        }
    }
    public void enemyContact(){
    }
}
