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

    public EditorTile (int x, int y){
        this.X = x;
        this.Y = y;
        this.name = "empty";

        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
        setBackground(Color.BLACK);

        //setComponentPopupMenu();

        setTileImage("emptyTile.png");
    }

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

    public String toString(){
        return this.name;
    }

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

    public void tileRightClick(int index){
        changeState(EditorTile.secondaryMenuItems[index]);
    }
}
