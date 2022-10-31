package hazards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapObstaclesTest {
    /** Test isPlayerBlocked without any obstacles. */
    @Test
    public void IsPlayerBlockedNoObstacles() {
        MapObstacles o = new MapObstacles();
        PlayerInfo player = new TestPlayerInfo(0, 0);
        Assertions.assertFalse(o.isPlayerBlocked(player));
    }

    /** Test isPlayerBlocked with a bunch of obstacles. */
    @Test
    public void IsPlayerBlockedMultipleObstacles() {
        MapObstacles o = new MapObstacles();
        o.add(new Obstacle(5, 5, 10, 20));
        o.add(new Obstacle(-12, 5));
        o.add(new Obstacle(18, -33, 9, 9));
        PlayerInfo player1 = new TestPlayerInfo(5, 33);
        Assertions.assertFalse(o.isPlayerBlocked(player1));
        PlayerInfo player2 = new TestPlayerInfo(6, 23);
        Assertions.assertTrue(o.isPlayerBlocked(player2)); // blocked by 1st obstacle
        PlayerInfo player3 = new TestPlayerInfo(-12, 5);
        Assertions.assertTrue(o.isPlayerBlocked(player3)); // blocked by 2nd obstacle
        PlayerInfo player4 = new TestPlayerInfo(20, -29);
        Assertions.assertTrue(o.isPlayerBlocked(player4)); // blocked by 3rd obstacle
    }
}
