package items;

import entities.items.ICollisionRequestModel;
import entities.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.ItemCollisionChecker;

/** Test the ItemCollisionChecker class */
public class ItemCollisionCheckerTest {
    /** Test anyItemCollision without any items. */
    @Test
    public void AnyItemCollisionNoItems() {
        ItemCollisionChecker iColChecker = new ItemCollisionChecker();
        ICollisionRequestModel player = new TestCollisionRequestModel(0, 0);
        Assertions.assertFalse(iColChecker.anyItemCollision(player));
    }

    /** Test anyItemCollision with a bunch of items. */
    @Test
    public void AnyItemCollisionMultipleItems() {
        ItemCollisionChecker iColChecker = new ItemCollisionChecker();
        iColChecker.add(new Item(5, 5));
        iColChecker.add(new Item(600, 250));
        iColChecker.add(new Item(1000, 800));
        ICollisionRequestModel player1 = new TestCollisionRequestModel(100, 100);
        Assertions.assertFalse(iColChecker.anyItemCollision(player1));  // no collision
        ICollisionRequestModel player2 = new TestCollisionRequestModel(6, 23);
        Assertions.assertTrue(iColChecker.anyItemCollision(player2)); // collision with 1st item
        ICollisionRequestModel player3 = new TestCollisionRequestModel(610, 260);
        Assertions.assertTrue(iColChecker.anyItemCollision(player3)); // collision with 2nd item
        ICollisionRequestModel player4 = new TestCollisionRequestModel(999, 800);
        Assertions.assertTrue(iColChecker.anyItemCollision(player4)); // collision with 3rd item
    }
}
