package items;

import entities.items.ICollisionRequestModel;
import entities.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.MazeItems;

/** Test the MazeItems class */
public class MazeItemsTest {
    /** Test anyItemCollision without any items. */
    @Test
    public void AnyItemCollisionNoItems() {
        MazeItems mazeItems = new MazeItems();
        ICollisionRequestModel player = new TestCollisionRequestModel(0, 0);
        Assertions.assertFalse(mazeItems.anyItemCollision(player));
    }

    /** Test anyItemCollision with a bunch of items. */
    @Test
    public void AnyItemCollisionMultipleItems() {
        MazeItems mazeItems = new MazeItems();
        mazeItems.add(new Item(5, 5));
        mazeItems.add(new Item(600, 250));
        mazeItems.add(new Item(1000, 800));
        ICollisionRequestModel player1 = new TestCollisionRequestModel(100, 100);
        Assertions.assertFalse(mazeItems.anyItemCollision(player1));  // no collision
        ICollisionRequestModel player2 = new TestCollisionRequestModel(5, 5);
        Assertions.assertTrue(mazeItems.anyItemCollision(player2)); // collision with 1st item
        ICollisionRequestModel player3 = new TestCollisionRequestModel(600, 250);
        Assertions.assertTrue(mazeItems.anyItemCollision(player3)); // collision with 2nd item
        ICollisionRequestModel player4 = new TestCollisionRequestModel(1000, 800);
        Assertions.assertTrue(mazeItems.anyItemCollision(player4)); // collision with 3rd item
    }
}
