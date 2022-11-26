package use_cases.default_game;

import entities.default_game.Maze;
import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

public class CollisionHandler {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final Maze maze = new Maze();
    int MAX_PANEL_COL = maze.getNum("MAX_PANEL_COL");
    int MAX_PANEL_ROW = maze.getNum("MAX_PANEL_ROW");
    int playerSpeed = 1;  // this should also be in Maze (HashMap) ?

    public CollisionHandler(MazeItems items, MazeHazards hazards){
        this.hazards = hazards;
        this.items = items;
    }
    public boolean upPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, 0, -playerSpeed);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    public boolean downPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, 0, playerSpeed);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }
    public boolean leftPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, -playerSpeed, 0);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }
    public boolean rightPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, playerSpeed, 0);

        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    private void handleEvent(IHazardRequestModel hazardModel) {
        if (hazards.isPlayerKilled(hazardModel)) {
            // collide with enemy, Player dies or takes damage;
            enemyContact();
        }
        if (items.anyItemCollision(hazardModel)){
            pickUpItem(hazardModel);
        }
    }

    public void pickUpItem(IHazardRequestModel request){
        int x = request.getPlayerX();
        int y = request.getPlayerY();
        String itemName = items.get(x, y).getName();
        switch(itemName) {
            case "Photons":
                items.delete(x, y);
//                UpdatePlayer.playerStamina += 20;
                break;
            case "Key":
                items.delete(x, y);
//                UpdatePlayer.hasKey = true;
                break;
            case "Blackhole":
//                if (UpdatePlayer.hasKey){
//                    UpdatePlayer.stageClear = true;
//                }
                break;
        }
    }

    public void enemyContact(){
//        if (UpdatePlayer.playerStamina > 10){
//            UpdatePlayer.playerStamina -= 10;
//        } else {
//            UpdatePlayer.staminaOut = true;
//            UpdatePlayer.playerStamina -= 10;
//        }
    }

    IHazardRequestModel getHazardModel(int playerX, int playerY, int moveX, int moveY) {
        return new IHazardRequestModel() {
            @Override
            public int getPlayerX() {
                return playerX + moveX;
            }
            @Override
            public int getPlayerY() {
                return playerY + moveY;
            }
            @Override
            public int mazeWidth() {
                return MAX_PANEL_COL;
            }
            @Override
            public int mazeHeight() {
                return MAX_PANEL_ROW;
            }
        };
    }
}


