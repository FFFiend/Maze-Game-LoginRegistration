package items;

import entities.items.ICollisionRequestModel;
import entities.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Test the Item class */
public class ItemTest {
    /** Try constructing an item. */
    @Test
    public void ConstructItem() {
        Item item = new Item(1, 3);
        Assertions.assertEquals(item.getX(), 1);
        Assertions.assertEquals(item.getY(), 3);
    }

    /** Test setX, setY */
    @Test
    public void SetPos() {
        Item item = new Item(1, 1);
        item.setX(17);
        item.setY(192);
        Assertions.assertEquals(item.getX(), 17);
        Assertions.assertEquals(item.getY(), 192);
    }

    /** Test itemCollision */
    @Test
    public void ItemCollision() {
        Item item = new Item(100, 200);
        ICollisionRequestModel player1 = new TestCollisionRequestModel(100, 200);
        ICollisionRequestModel player2 = new TestCollisionRequestModel(300, 300);
        ICollisionRequestModel player3 = new TestCollisionRequestModel(0, 0);
        Assertions.assertTrue(item.itemCollision(player1));
        Assertions.assertFalse(item.itemCollision(player2));
        Assertions.assertFalse(item.itemCollision(player3));
    }
}