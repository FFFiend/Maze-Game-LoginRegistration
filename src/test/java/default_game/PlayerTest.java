package default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.Player;
import items.TestDrawRequestModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class PlayerTest {
    /**
     * Check the setter and getter methods of Player.
     */
    @Test
    public void SetGetPlayerXY() {
        Player player = new Player(2, 1);

        Assertions.assertEquals(2, player.getX());
        Assertions.assertEquals(1, player.getY());
    }

    /**
     * Check that player positions are updated correctly.
     */
    @Test
    public void UpdatePlayerMoveUpTest() {
        Player player = new Player(1, 1);

        player.movePlayerY(-1);
        Assertions.assertEquals(1, player.getX());
        Assertions.assertEquals(0, player.getY());
    }

    @Test
    public void UpdatePlayerMoveDownTest() {
        Player player = new Player(1, 1);

        player.movePlayerY(1);
        Assertions.assertEquals(1, player.getX());
        Assertions.assertEquals(2, player.getY());
    }

    @Test
    public void UpdatePlayerMoveLeftTest() {
        Player player = new Player(1, 1);

        player.movePlayerX(-1);
        Assertions.assertEquals(0, player.getX());
        Assertions.assertEquals(1, player.getY());
    }

    @Test
    public void UpdatePlayerMoveRightTest() {
        Player player = new Player(1, 1);

        player.movePlayerX(1);
        Assertions.assertEquals(2, player.getX());
        Assertions.assertEquals(1, player.getY());
    }

    /**
     * Test various methods that change the status of Player
     */
    @Test
    public void ManipulatePlayerStatus() {
        Player player = new Player(1, 1);

        player.setStageClear(true);
        Assertions.assertTrue(player.getStageClear());

        player.setHasKey(true);
        Assertions.assertTrue(player.getHasKey());

        player.setStamina(50);
        player.addStamina(20);
        Assertions.assertEquals(70, player.getStamina());

        player.setDirection("up");
        Assertions.assertEquals("up", player.getDirection());
    }

    /**
     * Test draw
     */
    @Test
    public void DrawPlayer() {
        Player player = new Player(1, 1);
        IDrawOutputBoundary model = new TestDrawRequestModel();
        player.draw(model);
        player.setDirection("up");
        player.draw(model);
        player.setDirection("left");
        player.draw(model);
        player.setDirection("right");
        player.draw(model);
        Assertions.assertEquals(Color.WHITE, model.graphics().getColor());
    }
}
