package hazards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Test the MapObstacles class */
public class MapObstaclesTest {
    /** Test isPlayerBlocked without any obstacles. */
    @Test
    public void IsPlayerBlockedNoObstacles() {
        MapObstacles o = new MapObstacles();
        IHazardRequestModel player = new TestHazardRequestModel(0, 0);
        Assertions.assertFalse(o.isPlayerBlocked(player));
    }

    /** Test isPlayerBlocked with a bunch of obstacles. */
    @Test
    public void IsPlayerBlockedMultipleObstacles() {
        MapObstacles o = new MapObstacles();
        o.add(new Obstacle(5, 5, 10, 20));
        o.add(new Obstacle(-12, 5));
        o.add(new Obstacle(18, -33, 9, 9));
        IHazardRequestModel player1 = new TestHazardRequestModel(5, 33);
        Assertions.assertFalse(o.isPlayerBlocked(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(6, 23);
        Assertions.assertTrue(o.isPlayerBlocked(player2)); // blocked by 1st obstacle
        IHazardRequestModel player3 = new TestHazardRequestModel(-12, 5);
        Assertions.assertTrue(o.isPlayerBlocked(player3)); // blocked by 2nd obstacle
        IHazardRequestModel player4 = new TestHazardRequestModel(20, -29);
        Assertions.assertTrue(o.isPlayerBlocked(player4)); // blocked by 3rd obstacle
    }
}
