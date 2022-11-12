package entities.items;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Photons - an item that restores Player's stamina when picked up
 */
public class ItemPhotons extends Item {
    /**
     * Create the item Photons
     */
    public ItemPhotons(int x, int y) {
        super(x, y);
        setName("Photons");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/photons.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
