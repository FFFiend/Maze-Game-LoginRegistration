package entities.items;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Blackhole - GOAL item that takes the Player to the next level when picked up
 */
public class ItemBlackhole extends Item {
    /**
     * Create the item Blackhole
     */
    public ItemBlackhole(int x, int y) {
        super(x, y);
        setName("Blackhole");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/blackhole.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLockedTrue();
    }

}
