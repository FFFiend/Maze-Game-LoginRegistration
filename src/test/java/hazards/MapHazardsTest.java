package hazards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Test the MapHazards class */
public class MapHazardsTest {
    /** test isPlayerBlocked with no hazards */
    @Test
    public void IsPlayerBlockedEmpty() {
        MapHazards hazards = new MapHazards();
        IHazardRequestModel player = new TestHazardRequestModel(1, 12);
        Assertions.assertFalse(hazards.isPlayerBlocked(player));
    }

    /** test isPlayerBlocked with some obstacles */
    @Test
    public void IsPlayerBlockedObstacles() {
        MapHazards hazards = new MapHazards();
        hazards.addObstacle(new Obstacle(12, 33));
        hazards.addObstacle(new Obstacle(48, 5));
        IHazardRequestModel player1 = new TestHazardRequestModel(12, 33);
        Assertions.assertTrue(hazards.isPlayerBlocked(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(48, 6);
        Assertions.assertFalse(hazards.isPlayerBlocked(player2));
    }


    /** test isPlayerKilled with no hazards */
    @Test
    public void IsPlayerKilledEmpty() {
        MapHazards hazards = new MapHazards();
        IHazardRequestModel player = new TestHazardRequestModel(1, 12);
        Assertions.assertFalse(hazards.isPlayerKilled(player));
    }

    /** test isPlayerKilled with some enemies */
    @Test
    public void IsPlayerKilledEnemies() {
        MapHazards hazards = new MapHazards();
        hazards.addEnemy(new StationaryEnemy(1, 2));
        hazards.addEnemy(new StationaryEnemy(3, 4));
        IHazardRequestModel player1 = new TestHazardRequestModel(1, 2);
        Assertions.assertTrue(hazards.isPlayerKilled(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(2, 1);
        Assertions.assertFalse(hazards.isPlayerKilled(player2));
    }
}
