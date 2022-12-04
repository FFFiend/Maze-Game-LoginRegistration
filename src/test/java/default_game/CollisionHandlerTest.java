package default_game;

import entities.default_game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.CollisionHandler;
import use_cases.default_game.CustomAssetSetter;
import use_cases.items.MazeItems;
import use_cases.hazards.MazeHazards;

/**
 * Test the CollisionHandler class
 */
public class CollisionHandlerTest {

    /**
     * Test CollisionHandler with an obstacle in UP direction, and other assets in DOWN/LEFT/RIGHT directions.
     */
    @Test
    public void TestObstacleCollision() {
        MazeItems items = new MazeItems();
        MazeHazards hazards = new MazeHazards();
        new CustomAssetSetter("maze04.txt", items, hazards);
        Player player1 = new Player(1, 1);
        CollisionHandler cHandler = new CollisionHandler(items, hazards, player1);

        Assertions.assertFalse(cHandler.upPressed(player1.getX(), player1.getY()));
        Assertions.assertTrue(cHandler.leftPressed(player1.getX(), player1.getY()));
        Assertions.assertTrue(cHandler.rightPressed(player1.getX(), player1.getY()));
        Assertions.assertTrue(cHandler.downPressed(player1.getX(), player1.getY()));
    }

}
