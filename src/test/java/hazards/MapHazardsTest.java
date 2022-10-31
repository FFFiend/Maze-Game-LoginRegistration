package hazards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapHazardsTest {
    /** test isPlayerBlocked with no hazards */
    @Test
    public void IsPlayerBlockedEmpty() {
        MapHazards hazards = new MapHazards();
        PlayerInfo player = new TestPlayerInfo(1, 12);
        Assertions.assertFalse(hazards.isPlayerBlocked(player));
    }

    /** test isPlayerBlocked with some obstacles */
    @Test
    public void IsPlayerBlockedObstacles() {
        MapHazards hazards = new MapHazards();
        hazards.addObstacle(new Obstacle(12, 33));
        hazards.addObstacle(new Obstacle(48, 5));
        PlayerInfo player1 = new TestPlayerInfo(12, 33);
        Assertions.assertTrue(hazards.isPlayerBlocked(player1));
        PlayerInfo player2 = new TestPlayerInfo(48, 6);
        Assertions.assertFalse(hazards.isPlayerBlocked(player2));
    }


}
