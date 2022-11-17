package adapters.default_game;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The output boundary for drawing to the window.
 * The presenter can implement this interface, and any entities
 * which need drawing can have a draw method which takes this.
 */
public interface IDraw {
    /** Get the size of a tile in pixels */
    int getTileSize();

    /** Draw an image.
     *
     * @param image The image to be drawn.
     * @param x The X position (in pixels) to draw the image at.
     * @param y The Y position (in pixels) to draw the image at.
     * @param width The width (in pixels) that the image should be drawn with.
     *              (If this is different from the image's width, it will be scaled appropriately)
     * @param height The height (in pixels) that the image should be drawn with.
     */
    void drawImage(BufferedImage image, int x, int y, int width, int height);

    /** Draw a rectangle
     *
     * @param x The X position (in pixels) of the top-left corner of the rectangle.
     * @param y The Y position (in pixels) of the top-left corner of the rectangle.
     * @param width The width (in pixels) of the rectangle.
     * @param height The height (in pixels) of the rectangle.
     * @param color The color of the rectangle.
     */
    void drawRect(int x, int y, int width, int height, Color color);
}

// Note: If you have a java.awt.Graphics2D object g, you can implement
// drawImage as
//      g.drawImage(image, x, y, width, height, null);
// and you can implement drawRect as
//      g.setColor(color);
//      g.drawRect(x, y, width, height);