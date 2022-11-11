package entities.items;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Parent class which all items inherit from */
public class Item {

    // VARIABLES
    /** The image of the item */
    private BufferedImage image;
    /** The name of the item */
    private String name;
    /** The locked boolean of the item */
    private boolean locked = false;

    /** The x position of the item. */
    private int x;
    /** The y position of the item. */
    private int y;


    // METHODS
    /** Create a new item with the given position. */
    public Item(int x, int y) {
        setX(x);
        setY(y);
    }

    /** Set the x position of the item */
    public void setX(int x) {
        this.x = x;
    }
    /** Get the x position of the item */
    public int getX() {return this.x;}

    /** Set the y position of the item */
    public void setY(int y) {
        this.y = y;
    }
    /** Get the y position of the item */
    public int getY() {return this.y;}


    /** Set the image of the item */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    /** Get the image of the item */
    public BufferedImage getImage() {return this.image;}

    /** Set the name of the item */
    public void setName(String name) {
        this.name = name;
    }
    /** Get the name of the item */
    public String getName() {
        return this.name;
    }

    /** Set the locked boolean of the item to be true */
    public void setLockedTrue() {this.locked = true;}
    /** Get the locked boolean of the item */
    public boolean getLocked() {
        return this.locked;
    }

    /**
     * Check whether the item exists at the given point.
     */
    public boolean itemExists(int pointX, int pointY) {
        return pointX == x && pointY == y;
    }

    /** Check whether the item collides with the player. */
    public boolean itemCollision(ICollisionRequestModel request) {
        int playerX = request.getPlayerX();
        int playerY = request.getPlayerY();
        return itemExists(playerX, playerY);
    }

}