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
        Player player = new Player(96,48);

        Assertions.assertEquals(96, player.getPlayerX());
        Assertions.assertEquals(48, player.getPlayerY());
    }

    /**
     * Check that player positions are updated correctly.
     */
    @Test
    public void UpdatePlayerMoveUpTest() {
        Player player = new Player(48,48);

        player.movePlayerY(-48);
        Assertions.assertEquals(48, player.getPlayerX());
        Assertions.assertEquals(0, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveDownTest() {
        Player player = new Player(48,48);

        player.movePlayerY(48);
        Assertions.assertEquals(48, player.getPlayerX());
        Assertions.assertEquals(96, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveLeftTest() {
        Player player = new Player(48,48);

        player.movePlayerX(-48);
        Assertions.assertEquals(0, player.getPlayerX());
        Assertions.assertEquals(48, player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveRightTest() {
        Player player = new Player(48,48);

        player.movePlayerX(48);
        Assertions.assertEquals(96, player.getPlayerX());
        Assertions.assertEquals(48, player.getPlayerY());
    }
}
