package adapters.custom_game.custom_game_file_adapters;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * A tile of an EditorGrid that stores the asset it contains
 */
public class EditorTile extends JLabel {
    private final int X;
    private final int Y;
    private String name;

    private static final String[] secondaryMenuItems = {"photons", "key", "enemy", "start", "end"};
    public static final int secondaryMenuItemsLen = EditorTile.secondaryMenuItems.length;

    /**
     * Creates a tile for the custom maze editor, sets its state to empty and sets its image to reflect that
     * @param x the x position of the Tile on the EditorGrid and position in the array TempMaze
     * @param y the y position of the Tile on the EditorGrid and position in the array TempMaze
     */
    public EditorTile (int x, int y){
        this.X = x;
        this.Y = y;
        this.name = "empty";

        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
        setBackground(Color.BLACK);

        setTileImage("emptyTile.png");
    }

    /**
     * Helper method to replace the image of a tile with a new one
     * @param name The name of the image
     */
    private void setTileImage(String name){
        {
            try {
                BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("custom/" + name));
                setIcon(new ImageIcon(image));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Make an EditorTile's string representation its name (empty, wall, enemy etc.)
     * @return the name (state) of an EditorTile
     */
    public String toString(){
        return this.name;
    }

    /**
     * Change the name of an EditorTile and calls setTileImage to change its image to reflect that
     * @param name the new state an EditorTile is in
     */
    public void changeState(String name) {
        if (Objects.equals(name, "photons")) {
            setTileImage("photons.png");
        } else if (Objects.equals(name, "enemy")) {
            setTileImage("enemy.png");
        } else if (Objects.equals(name, "key")) {
            setTileImage("key.png");
        } else if (Objects.equals(name, "start")) {
            setTileImage("start.png");
        } else if (Objects.equals(name, "end")) {
            setTileImage("blackhole.png");
        }
        else {
            //TODO raise an error
        }
        this.name = name;
    }

    /**
     * Reaction to a left click on an EditorTile. If the tile was a wall or represented any secondary asset (enemy,
     * photons, start location etc.) it will now represent an empty tile
     */
    public void tileLeftClick(){
        //use !equals so that other tile states can be converted to a wall or become empty
        if (!Objects.equals(this.name, "empty")) {
            setTileImage("emptyTile.png");
            this.name = "empty";
        } else if (!Objects.equals(this.name, "wall")){
            setTileImage("wall.png");
            this.name = "wall";
        }
    }

    /**
     * Reaction to a right click on an EditorTile. Each tile cycles through secondaryMenuItems on right clicks by using
     * index
     * @param index the index of secondaryMenuItems, should be incremented by one on each call
     */
    public void tileRightClick(int index){
        changeState(EditorTile.secondaryMenuItems[index]);
    }
}
