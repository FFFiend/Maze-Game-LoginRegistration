package items;

import entities.default_game.IDrawOutputBoundary;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * an IDrawRequestModel implementation for testing only
 */
public class TestDrawRequestModel implements IDrawOutputBoundary {
    @Override
    public int getTileSize() {
        return 48;
    }

    @Override
    public Graphics2D graphics() {
        BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
        return image.createGraphics();
    }
}


