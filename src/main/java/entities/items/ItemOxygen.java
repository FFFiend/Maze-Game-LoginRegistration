package entities.items;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Oxygen - an item that restores Player's stamina when picked up
 */
public class ItemOxygen extends Item {
    /**
     * Create the item Oxygen
     */
    public ItemOxygen(int x, int y) {
        super(x, y);
        setName("Oxygen");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/oxygen.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
