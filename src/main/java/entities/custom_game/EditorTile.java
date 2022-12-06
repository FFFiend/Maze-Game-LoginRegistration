package entities.custom_game;
import entities.default_game.MazeInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * A tile of an EditorGrid that stores the asset it contains
 * EditorTiles are also stored in TempMaze for conversion to a text file (storage)
 */
public class EditorTile extends JLabel {
    private String name;
    private int numCode;
    private static final String[] secondaryMenuItems = {"oxygen", "key", "stationaryEnemy", "chasingEnemy", "start", "end"};
    public static final int secondaryMenuItemsLen = EditorTile.secondaryMenuItems.length;
    private final static int START_NUM_CODE = 9;

    /**
     * Creates a tile for the custom maze editor, sets its state to empty and sets its image to reflect that
     */
    public EditorTile () {
        this.name = "empty";
        this.numCode = MazeInfo.getAssetCodeEmpty();

        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
        setBackground(Color.BLACK);
        setTileImage("emptyTile.png");
    }

    /**
     * Helper method to replace the image of a tile with a new one
     *
     * @param name The name of the image
     */
    private void setTileImage(String name) {
        {
            try {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("custom/" + name)));
                Image scaledImage = image.getScaledInstance(48, 48, Image.SCALE_DEFAULT);
                // credit to Seamus for the scaling lines
                setIcon(new ImageIcon(scaledImage));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Make an EditorTile's string representation its name (empty, obstacle, enemy etc.)
     *
     * @return the name (state) of an EditorTile
     */
    public String toString() {
        return this.name;
    }

    /**
     * Returns a number representing the state a tile is in (empty, obstacle, start location etc.) for use when storing
     * mazes in txt files
     *
     * @return the number representing a tile state
     */
    public int getNumCode() {
        return this.numCode;
    }

    /**
     * Change the name and numeric code of an EditorTile and calls setTileImage to change its image to reflect that
     *
     * @param name the new state an EditorTile is in
     */
    public void changeState(String name) {
        if (Objects.equals(name, "oxygen")) {
            setTileImage("oxygen.png");
            this.numCode = MazeInfo.getAssetCodeOxygen();
        }
        else if (Objects.equals(name, "stationaryEnemy")) {
            setTileImage("stationaryEnemy.png");
            this.numCode = MazeInfo.getAssetCodeStationaryEnemy();
        }
        else if (Objects.equals(name, "chasingEnemy")) {
            setTileImage("chasingEnemy.png");
            this.numCode = MazeInfo.getAssetCodeChasingEnemy();
        }
        else if (Objects.equals(name, "key")) {
            setTileImage("key.png");
            this.numCode = MazeInfo.getAssetCodeKey();
        }
        else if (Objects.equals(name, "start")) {
            setTileImage("start.png");
            //this.numCode = MazeInfo.getAssetCodeStart();
            //waiting for start location to be added to maze constants to uncomment above
            this.numCode = START_NUM_CODE;
        }
        else if (Objects.equals(name, "end")) {
            setTileImage("blackhole.png");
            this.numCode = MazeInfo.getAssetCodeGoal();
        }
        else {
            throw new RuntimeException("invalid tile type given");
        }
        this.name = name;
    }

    /**
     * Reaction to a left click on an EditorTile. If the tile was an obstacle or represented any secondary asset (enemy,
     * oxygen, start location etc.) it will now represent an empty tile
     */
    public void tileLeftClick() {
        if (!Objects.equals(this.name, "empty")) {
            setTileImage("emptyTile.png");
            this.name = "empty";
            this.numCode = MazeInfo.getAssetCodeEmpty();
        } else {
            setTileImage("obstacle.png");
            this.name = "obstacle";
            this.numCode = MazeInfo.getAssetCodeObstacle();
        }
    }

    /**
     * Reaction to a right click on an EditorTile. Each tile cycles through secondaryMenuItems on right clicks by using
     * index
     *
     * @param index the index of secondaryMenuItems, should be incremented by one on each call
     */
    public void tileRightClick(int index) {
        changeState(EditorTile.secondaryMenuItems[index]);
    }
}
