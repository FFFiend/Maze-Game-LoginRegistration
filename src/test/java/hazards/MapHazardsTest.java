package hazards;

import adapters.hazards.IHazardRequestModel;
import entities.hazards.Enemy;
import entities.hazards.Obstacle;
import entities.hazards.StationaryEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MapHazards;

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

    /** Test getting and removing enemies. */
    @Test
    public void EnemyManipulation() {
        MapHazards hazards = new MapHazards();
        Enemy enemy = new StationaryEnemy(10, 3);
        hazards.addEnemy(enemy);
        Assertions.assertEquals(hazards.getEnemy(10, 3), enemy);
        Assertions.assertNull(hazards.getEnemy(3, 10));
        hazards.deleteEnemy(10, 3);
        Assertions.assertNull(hazards.getEnemy(10, 3));
    }
}
