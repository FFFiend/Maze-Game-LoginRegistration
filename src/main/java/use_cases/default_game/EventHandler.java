package use_cases.default_game;

import entities.items.ItemBlackhole;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

public class EventHandler {
    private final MazeItems items;

    public EventHandler(MazeHazards hazards, MazeItems items){
        this.items = items;
    }
    public void pickUpItem(int x, int y){
        if (items.get(x, y).getName().equals("Photons")) {
            items.delete(x, y);
        }
        if (items.get(x, y).getName().equals("Key")) {
            items.delete(x, y);
        }
    }
}
