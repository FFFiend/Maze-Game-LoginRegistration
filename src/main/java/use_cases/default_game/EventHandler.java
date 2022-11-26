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
                UpdatePlayer.playerStamina += 20;
                System.out.println("picked up stamina!" + UpdatePlayer.playerStamina);
                break;
            case "Key":
                items.delete(x, y);
                UpdatePlayer.hasKey = true;
                System.out.println("picked up Key");
                break;
            case "Blackhole":
                if (UpdatePlayer.hasKey){
                    UpdatePlayer.stageClear = true;
                    System.out.println("stageClear!");
                }
                break;
        }
    }
    public void enemyContact(){
        if (UpdatePlayer.playerStamina > 10){
            UpdatePlayer.playerStamina -= 10;
            System.out.println("damage!" + UpdatePlayer.playerStamina);
        } else {
            UpdatePlayer.staminaOut = true;
            UpdatePlayer.playerStamina -= 10;
            System.out.println("you died!" + UpdatePlayer.playerStamina);
        }
    }
}
