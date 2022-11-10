package hazards;

import adapters.hazards.IHazardRequestModel;
import entities.hazards.Obstacle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MazeObstacles;

/** Test the MazeObstacles class */
public class MazeObstaclesTest {
    /** Test isPlayerBlocked without any obstacles. */
    @Test
    public void IsPlayerBlockedNoObstacles() {
        MazeObstacles o = new MazeObstacles();
        IHazardRequestModel player = new TestHazardRequestModel(0, 0);
        Assertions.assertFalse(o.isPlayerBlocked(player));
    }

    /** Test isPlayerBlocked with a bunch of obstacles. */
    @Test
    public void IsPlayerBlockedMultipleObstacles() {
        MazeObstacles o = new MazeObstacles();
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

    /** Test get without any obstacles. */
    @Test
    public void GetNoObstacles() {
        MazeObstacles o = new MazeObstacles();
        Assertions.assertNull(o.get(3, 5));
    }

    /** Test get with several obstacles. */
    @Test
    public void GetMultipleObstacles() {
        MazeObstacles o = new MazeObstacles();
        Obstacle o1 = new Obstacle(3, 5);
        Obstacle o2 = new Obstacle(88, 2, 12, 7);
        Assertions.assertNull(o.get(4, 5));
        o.add(o1);
        o.add(o2);
        Assertions.assertEquals(o.get(3, 5), o1);
        Assertions.assertEquals(o.get(89, 5), o2);
    }

    /** Test removing obstacles. */
    @Test
    public void Remove() {
        MazeObstacles o = new MazeObstacles();
        Obstacle o1 = new Obstacle(4, 3);
        Obstacle o2 = new Obstacle(10, 10, 5, 4);
        o.add(o1);
        o.add(o2);
        Assertions.assertEquals(o.get(4, 3), o1);
        o.delete(4, 3);
        Assertions.assertNull(o.get(4, 3));

        Assertions.assertEquals(o.get(11, 12), o2);
        o.delete(13, 12);
        Assertions.assertNull(o.get(11, 12));

    }
}
