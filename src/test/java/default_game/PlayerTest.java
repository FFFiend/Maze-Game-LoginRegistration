package default_game;

import entities.default_game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    /**
     * Check the setter and getter methods of Player.
     */
    @Test
    public void SetGetPlayerXY() {
        Player player = new Player(2,1);

        Assertions.assertEquals(2, player.getPlayerX());
        Assertions.assertEquals(1, player.getPlayerY());
    }

    /**
     * Check that player positions are updated correctly.
     */
    @Test
    public void UpdatePlayerMoveUpTest() {
        Player player = new Player(1,1);

        player.movePlayerY(-1);
        Assertions.assertEquals(1, player.getPlayerX());
        Assertions.assertEquals(0, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveDownTest() {
        Player player = new Player(1,1);

        player.movePlayerY(1);
        Assertions.assertEquals(1, player.getPlayerX());
        Assertions.assertEquals(2, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveLeftTest() {
        Player player = new Player(1,1);

        player.movePlayerX(-1);
        Assertions.assertEquals(0, player.getPlayerX());
        Assertions.assertEquals(1, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveRightTest() {
        Player player = new Player(1,1);

        player.movePlayerX(1);
        Assertions.assertEquals(2, player.getPlayerX());
        Assertions.assertEquals(1, player.getPlayerY());
    }
}
