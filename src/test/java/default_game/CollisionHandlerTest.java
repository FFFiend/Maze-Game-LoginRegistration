package default_game;

import entities.default_game.Player;
import entities.hazards.IHazardRequestModel;
import items.TestCollisionRequestModel;
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

    /**
     * Test pickUpItem with various Items in each direction
     */
    @Test
    public void TestPickUpItem() {
        MazeItems items = new MazeItems();
        MazeHazards hazards = new MazeHazards();
        new CustomAssetSetter("maze04.txt", items, hazards);
        Player player1 = new Player(3, 1);
        CollisionHandler cHandler = new CollisionHandler(items, hazards, player1);

        int StartingStamina = player1.getStamina();
        IHazardRequestModel modelUp = new TestCollisionRequestModel(3, 0); // up
        cHandler.pickUpItem(modelUp);
        Assertions.assertEquals(player1.getStamina(), StartingStamina + 20);

        IHazardRequestModel modelDown = new TestCollisionRequestModel(3, 2); // down
        cHandler.pickUpItem(modelDown);
        Assertions.assertTrue(player1.getHasKey());

        IHazardRequestModel modelRight = new TestCollisionRequestModel(4, 1); // right
        cHandler.pickUpItem(modelRight);
        Assertions.assertTrue(player1.getStageClear());
    }
}
