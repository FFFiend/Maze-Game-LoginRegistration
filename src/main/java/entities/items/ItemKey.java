package entities.items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemKey extends Item {
    public ItemKey(int x, int y) {
        super(x, y);
        setName("Key");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
