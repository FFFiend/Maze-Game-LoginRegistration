package use_cases;

import entities.items.ICollisionRequestModel;
import entities.items.Item;

import java.util.ArrayList;
import java.util.List;

/** A collection of items within a maze with "collision checking" functionality. */
public class ItemCollisionChecker {
    /** The internal list of items. */
    private final List<Item> items;

    /** Construct a new ItemCollisionChecker class with no items. */
    public ItemCollisionChecker() {
        items = new ArrayList<>();
    }

    /** Check whether the player collides with any item. */
    public boolean anyItemCollision(ICollisionRequestModel request) {
        for (Item item: items) {
            if (item.itemCollision(request))
                return true;
        }
        return false;
    }

    /** Add an item. */
    public void add(Item item) {
        items.add(item);
    }
}
