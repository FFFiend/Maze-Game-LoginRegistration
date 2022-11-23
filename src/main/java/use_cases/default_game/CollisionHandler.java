package use_cases.default_game;

import entities.default_game.Player;
import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

public class CollisionHandler {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final EventHandler eHandler;

    public CollisionHandler(MazeHazards hazards, MazeItems items){
        this.hazards = hazards;
        this.items = items;
        this.eHandler = new EventHandler(hazards, items);
    }

    public void upPressed() {
        IHazardRequestModel hazardModel = new IHazardRequestModel() {
            @Override
            public int getPlayerX() {
                return Player.getPlayerX();
            }
            @Override
            public int getPlayerY() {
                return Player.getPlayerY() - 1;
            }
            @Override
            public int mazeWidth() {
                return 0;
            }
            @Override
            public int mazeHeight() {
                return 0;
            }
        };
        if (!hazards.isPlayerBlocked(hazardModel)){
            UpdatePlayer.movePlayerUp();
        }
        if (hazards.isPlayerKilled(hazardModel)){
            // collide with enemy, Player dies;
        }
        if (items.anyItemCollision(hazardModel)){
            eHandler.pickUpItem(Player.getPlayerX(), Player.getPlayerY() - 1);
        }
    }
    public void downPressed() {
        IHazardRequestModel hazardModel = new IHazardRequestModel() {
            @Override
            public int getPlayerX() {
                return Player.getPlayerX();
            }
            @Override
            public int getPlayerY() {
                return Player.getPlayerY() + 1;
            }
            @Override
            public int mazeWidth() {
                return 0;
            }
            @Override
            public int mazeHeight() {
                return 0;
            }
        };
        if (!hazards.isPlayerBlocked(hazardModel)){
            UpdatePlayer.movePlayerDown();
        }
        if (items.anyItemCollision(hazardModel)){
            eHandler.pickUpItem(Player.getPlayerX(), Player.getPlayerY() + 1);
        }
    }
    public void leftPressed() {
        IHazardRequestModel hazardModel = new IHazardRequestModel() {
            @Override
            public int getPlayerX() {
                return Player.getPlayerX() - 1;
            }
            @Override
            public int getPlayerY() {
                return Player.getPlayerY();
            }
            @Override
            public int mazeWidth() {
                return 0;
            }
            @Override
            public int mazeHeight() {
                return 0;
            }
        };
        if (!hazards.isPlayerBlocked(hazardModel)){
            UpdatePlayer.movePlayerLeft();
        }
        if (items.anyItemCollision(hazardModel)){
            eHandler.pickUpItem(Player.getPlayerX() - 1, Player.getPlayerY());
        }
    }
    public void rightPressed() {
        IHazardRequestModel hazardModel = new IHazardRequestModel() {
            @Override
            public int getPlayerX() {
                return Player.getPlayerX() + 1;
            }
            @Override
            public int getPlayerY() {
                return Player.getPlayerY();
            }
            @Override
            public int mazeWidth() {
                return 0;
            }
            @Override
            public int mazeHeight() {
                return 0;
            }
        };
        if (!hazards.isPlayerBlocked(hazardModel)){
            UpdatePlayer.movePlayerRight();
        }
        if (items.anyItemCollision(hazardModel)){
            eHandler.pickUpItem(Player.getPlayerX() + 1, Player.getPlayerY());
        }
    }
}
