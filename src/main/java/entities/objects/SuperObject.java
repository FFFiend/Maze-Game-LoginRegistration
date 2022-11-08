package entities.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject extends Entity {

    // variables
    private BufferedImage image;
    private String name;
    private boolean collision = false;
    private Rectangle solidArea = new Rectangle(0, 0, 48, 48);

    // methods
    public void draw(Graphics2D g2, Maze maze) {
        g2.drawImage(image, getX(), getY(), maze.tileSize, maze.tileSize, null);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public BufferedImage getImage() {return this.image;}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setCollisionTrue() {this.collision = true;}
    public boolean getCollision() {
        return this.collision;
    }

    public Rectangle getSolidArea() {return this.solidArea;}

}
