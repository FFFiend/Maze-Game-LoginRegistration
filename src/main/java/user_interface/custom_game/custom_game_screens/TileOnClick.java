package user_interface.custom_game.custom_game_screens;
import adapters.custom_game.custom_game_file_adapters.Tile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileOnClick extends MouseAdapter {
    private final Tile tile;
    private int rightClickCount = 0;

    public TileOnClick(Tile tile){
        this.tile = tile;
    }

    @Override
    public void mousePressed(MouseEvent click){
        if (click.getButton() == MouseEvent.BUTTON1){
            this.tile.tileLeftClick();
        } else if (click.getButton() == MouseEvent.BUTTON3) {
            this.tile.tileRightClick(rightClickCount);
            this.rightClickCount++;
            if (rightClickCount == Tile.secondaryMenuItemsLen){
                rightClickCount = 0;
            }
        }
    }

}