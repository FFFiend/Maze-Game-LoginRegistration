package default_game;

import com.sun.tools.javac.Main;
import entities.default_game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.UpdatePlayer;

public class PlayerTest {
    /**
     * Check the setter and getter methods of Player.
     */
    @Test
    public void SetGetPlayerXY() {
        UpdatePlayer.setPlayerX(96);
        UpdatePlayer.setPlayerY(48);

        Assertions.assertEquals(96, Player.getPlayerX());
        Assertions.assertEquals(48, Player.getPlayerY());
    }

    /**
     * Check that player positions are updated correctly.
     */
    @Test
    public void UpdatePlayerMoveUpTest() {
        UpdatePlayer.setPlayerX(48);
        UpdatePlayer.setPlayerY(48);

        UpdatePlayer.movePlayerUp();
        Assertions.assertEquals(48, Player.getPlayerX());
        Assertions.assertEquals(0, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveDownTest() {
        UpdatePlayer.setPlayerX(48);
        UpdatePlayer.setPlayerY(48);

        UpdatePlayer.movePlayerDown();
        Assertions.assertEquals(48, Player.getPlayerX());
        Assertions.assertEquals(96, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveLeftTest() {
        UpdatePlayer.setPlayerX(48);
        UpdatePlayer.setPlayerY(48);

        UpdatePlayer.movePlayerLeft();
        Assertions.assertEquals(0, Player.getPlayerX());
        Assertions.assertEquals(48, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveRightTest() {
        UpdatePlayer.setPlayerX(48);
        UpdatePlayer.setPlayerY(48);

        UpdatePlayer.movePlayerRight();
        Assertions.assertEquals(96, Player.getPlayerX());
        Assertions.assertEquals(48, Player.getPlayerY());
    }
}
