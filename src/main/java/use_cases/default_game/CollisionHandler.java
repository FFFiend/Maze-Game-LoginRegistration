package use_cases.default_game;

import entities.default_game.MazeInfo;
import entities.default_game.Player;
import entities.hazards.IHazardRequestModel;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

/**
 * Check if the Player would collide with any Assets by moving up/down/left/right
 */
public class CollisionHandler {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final Player player;
    int MAX_MAZE_COL = MazeInfo.getMaxMazeCol();
    int MAX_MAZE_ROW = MazeInfo.getMaxMazeRow();
    int playerSpeed = 1;  // this should also be in Maze (HashMap) ?

    /**
     * Construct a new CollisionHandler with the assets (items and hazards).
     **/
    public CollisionHandler(MazeItems items, MazeHazards hazards, Player player) {
        this.hazards = hazards;
        this.items = items;
        this.player = player;
    }

    /**
     * Check upward collision
     *
     * @param playerX player position X
     * @param playerY player position Y
     * @return boolean for whether Player can move without hitting an obstacle
     */
    public boolean upPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, 0, -playerSpeed);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    /**
     * Check downward collision
     *
     * @param playerX player position X
     * @param playerY player position Y
     * @return boolean for whether Player can move without hitting an obstacle
     */
    public boolean downPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, 0, playerSpeed);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    /**
     * Check leftward collision
     *
     * @param playerX player position X
     * @param playerY player position Y
     * @return boolean for whether Player can move without hitting an obstacle
     */
    public boolean leftPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, -playerSpeed, 0);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    /**
     * Check rightward collision
     *
     * @param playerX player position X
     * @param playerY player position Y
     * @return boolean for whether Player can move without hitting an obstacle
     */
    public boolean rightPressed(int playerX, int playerY) {
        IHazardRequestModel hazardModel = getHazardModel(playerX, playerY, playerSpeed, 0);
        handleEvent(hazardModel);
        return !hazards.isPlayerBlocked(hazardModel);
    }

    /**
     * If the Player collides with an item or an enemy, call methods to handle them
     **/
    private void handleEvent(IHazardRequestModel hazardModel) {
        if (hazards.isPlayerKilled(hazardModel)) {
            // collide with enemy, Player dies or takes damage;
            enemyContact();
        }
        if (items.anyItemCollision(hazardModel)) {
            pickUpItem(hazardModel);
        }
    }

    /**
     * Handle Player interaction with an item
     **/
    public void pickUpItem(IHazardRequestModel request) {
        int x = request.getPlayerX();
        int y = request.getPlayerY();
        String itemName = items.get(x, y).getName();
        switch (itemName) {
            case "Oxygen":
                items.delete(x, y);
                player.addStamina(20);
                break;
            case "Key":
                items.delete(x, y);
                player.setHasKey(true);
                break;
            case "Blackhole":
                if (player.getHasKey()){
                    player.setStageClear(true);
                }
                break;
        }
    }

    /**
     * Handle Player interaction with an enemy
     **/
    public void enemyContact() {
//        if (player.getStamina() > 0){
//            player.setStamina(getStamina() - 10);
//        }
    }

    /**
     * Helper method to create the necessary interface IHazardRequestModel for each direction
     **/
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
                return MAX_MAZE_COL;
            }

            @Override
            public int mazeHeight() {
                return MAX_MAZE_ROW;
            }
        };
    }
}
