package entities.items;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Key - an item required to open the GOAL (Blackhole)
 */
public class ItemKey extends Item {
    /**
     * Create the item Key
     */
    public ItemKey(int x, int y) {
        super(x, y);
        setName("Key");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
