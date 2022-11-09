package hazards;

import adapters.hazards.IHazardRequestModel;
import entities.hazards.Enemy;
import entities.hazards.StationaryEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MapEnemies;

/** Test the MapEnemies class. */
public class MapEnemiesTest {
    /** Test isPlayerKilled with no enemies. */
    @Test
    void IsPlayerKilledNoEnemies() {
        MapEnemies enemies = new MapEnemies();
        IHazardRequestModel request = new TestHazardRequestModel(3, 5);
        Assertions.assertFalse(enemies.isPlayerKilled(request));
    }

    /** Test isPlayerKilled with one enemy. */
    @Test
    void IsPlayerKilledOneEnemy() {
        MapEnemies enemies = new MapEnemies();
        enemies.add(new StationaryEnemy(3, 5));
        IHazardRequestModel player1 = new TestHazardRequestModel(3, 5);
        Assertions.assertTrue(enemies.isPlayerKilled(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(4, 6);
        Assertions.assertFalse(enemies.isPlayerKilled(player2));
    }

    /** Test isPlayerKilled with multiple enemies. */
    @Test
    void IsPlayerKilledMultipleEnemies() {
        MapEnemies enemies = new MapEnemies();
        enemies.add(new StationaryEnemy(1, 3));
        enemies.add(new StationaryEnemy(2, 6));
        IHazardRequestModel player1 = new TestHazardRequestModel(1, 3);
        Assertions.assertTrue(enemies.isPlayerKilled(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(2, 6);
        Assertions.assertTrue(enemies.isPlayerKilled(player2));
        IHazardRequestModel player3 = new TestHazardRequestModel(4, 8);
        Assertions.assertFalse(enemies.isPlayerKilled(player3));
    }

    /** Test get with no enemies. */
    @Test
    void GetNoEnemies() {
        MapEnemies enemies = new MapEnemies();
        Assertions.assertNull(enemies.get(1, 2));
        Assertions.assertNull(enemies.get(17, -4));
    }

    /** Test get with some enemies. */
    @Test
    void GetMultipleEnemies() {
        MapEnemies enemies = new MapEnemies();
        Enemy enemy1 = new StationaryEnemy(3, 17);
        Enemy enemy2 = new StationaryEnemy(10, 20);

        enemies.add(enemy1);
        enemies.add(enemy2);
        Assertions.assertNull(enemies.get(20, 10));
        Assertions.assertEquals(enemies.get(3, 17), enemy1);
        Assertions.assertEquals(enemies.get(10, 20), enemy2);
    }

    /** Test remove */
    @Test
    void Remove() {
        MapEnemies enemies = new MapEnemies();
        Enemy enemy = new StationaryEnemy(0, 0);
        enemies.add(enemy);
        enemies.delete(0, 0);
        Assertions.assertNull(enemies.get(0, 0));
    }

}
